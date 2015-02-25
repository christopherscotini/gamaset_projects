package br.com.gamaset.diaryboard.business.bo.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.PlanoJogoService;
import br.com.gamaset.diaryboard.business.exception.NoDataFoundException;
import br.com.gamaset.diaryboard.business.exception.NonUniqueResultDataException;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.dto.PlanoJogoDetalheDTO;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.repository.ApostaRepository;
import br.com.gamaset.diaryboard.repository.PlanoJogoItemRepository;
import br.com.gamaset.diaryboard.repository.PlanoJogoRepository;

@Stateless
public class PlanoJogoServiceImpl implements PlanoJogoService{

	@Inject
	private PlanoJogoRepository repo = null;
	@Inject
	private PlanoJogoItemRepository repoItem= null;
	@Inject
	private ApostaRepository repoAposta= null;

	@Override
	public List<PlanoJogoEntity> listarTodos() {
		List<PlanoJogoEntity> returnzz = repo.findAll();
		if(returnzz.size() == 0 || returnzz == null){
			throw new NoDataFoundException("Planos de Jogo Cadastrados");
		}
		for (int i = 0; i < returnzz.size(); i++) {
			returnzz.get(i).setMontanteAtual(returnzz.get(i).getApostas().get(returnzz.get(i).getApostas().size()-1).getVlrFinalDia());
		}
		return returnzz;
	}

	@Override
	public List<PlanoJogoEntity> listarTodosAtivos() {
		List<PlanoJogoEntity> returnzz = repo.findAllAtivos();
		if(returnzz.size() == 0 || returnzz == null){
			throw new NoDataFoundException("Planos de Jogo Ativos Cadastrados");
		}
		for (int i = 0; i < returnzz.size(); i++) {
			returnzz.get(i).setMontanteAtual(returnzz.get(i).getApostas().get(returnzz.get(i).getApostas().size()-1).getVlrFinalDia());
		}
		return returnzz;
	}

	@Override
	public PlanoJogoEntity adicionarEntidade(PlanoJogoEntity entidade) {
		validateForm(entidade);
		entidade.setAtivo(true);
		entidade = repo.insert(entidade);
		generateItensPlanoJogo(entidade);
		
		for (int i = 0; i < entidade.getApostas().size(); i++) {
			repoItem.insert(entidade.getApostas().get(i));
		}
		return entidade;
	}

	private void generateItensPlanoJogo(PlanoJogoEntity entidade) {
		entidade.setApostas(new ArrayList<PlanoJogoItemEntity>());
		for (int i = 0; i < entidade.getNumDiasPlano(); i++) {
			PlanoJogoItemEntity e = new PlanoJogoItemEntity();
			e.setPlanoJogo(entidade);
			e.setDescricao("DIA "+(i+1));
			if(i==0){
				e.setVlrInicialDiaObjetivo(entidade.getValorInvestimentoInicial());//OBJETIVO
				e.setVlrInicialDia(entidade.getValorInvestimentoInicial());
				e.setVlrFinalDia(entidade.getValorInvestimentoInicial());
			}else{
				e.setVlrInicialDiaObjetivo(entidade.getApostas().get(i-1).getVlrFinalDiaObjetivo());//OBJETIVO
				e.setVlrInicialDia(entidade.getValorInvestimentoInicial());
				e.setVlrFinalDia(entidade.getApostas().get(i-1).getVlrFinalDia());
			}
			//OBJETIVO
			BigDecimal vlrFinalAux = (e.getVlrInicialDiaObjetivo().multiply(entidade.getPercentualLucroMontanteDia())).divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN);
			e.setVlrFinalDiaObjetivo(e.getVlrInicialDiaObjetivo().add(vlrFinalAux));
			e.setVlrLucroDiaObjetivo((e.getVlrFinalDiaObjetivo().subtract(e.getVlrInicialDiaObjetivo())).setScale(2, RoundingMode.HALF_EVEN));
			e.setVlrBetDiaObjetivo((e.getVlrInicialDiaObjetivo().multiply(entidade.getPercentualApostaMontanteDia())).divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
			e.setVlrBetDia(e.getVlrBetDiaObjetivo());

			e.setVlrLucroDia(BigDecimal.ZERO);
			e.setPercObjetivoConcluidoDia(e.getVlrFinalDia().divide(e.getVlrFinalDiaObjetivo(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
//			e.setPercLucroDia(percLucroDia);
//			e.setPercLucroMeta(percLucroMeta);
//			e.setVlrTotalGanhoDia(vlrTotalGanhoDia);
//			e.setVlrTotalPerdidoDia(vlrTotalPerdidoDia);
			entidade.getApostas().add(e);
		}
		
	}

	@Override
	public PlanoJogoEntity editarEntidade(PlanoJogoEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(PlanoJogoEntity entidade) {
		List<PlanoJogoItemEntity> itensPlano = null;
		try{
			itensPlano = repo.findById(entidade.getId()).getApostas();
			for (int i = 0; i < itensPlano.size(); i++) {
				List<ApostaEntity>apostasItem = repoAposta.buscarApostaPorPlanoItem(itensPlano.get(i));
				if(apostasItem.size() > 0){
					for (int j = 0; j < apostasItem.size(); j++) {
						repoAposta.delete(apostasItem.get(j));
					}
				}
			}
		}catch(NullPointerException n){}
		repo.delete(entidade);
	}

	@Override
	public PlanoJogoDetalheDTO detalharPlanoJogo(PlanoJogoEntity planoJogoCadastrar) {
		
		return null;
	}
	
	@Override
	public void validateForm(PlanoJogoEntity entidade)
			throws ValidationFormAbstractException {
		
		if(entidade.getId() == null && entidade.getDataCriacao() == null){
			entidade.setDataCriacao(new Date());
		}
		
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException("plano de jogo ["+entidade.getDescricao()+"]");
		}
		
		
	}
	

}
