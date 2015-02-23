package br.com.gamaset.diaryboard.business.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.ApostaService;
import br.com.gamaset.diaryboard.business.exception.NonUniqueResultDataException;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.repository.ApostaRepository;
import br.com.gamaset.diaryboard.repository.PlanoJogoItemRepository;
import br.com.gamaset.diaryboard.utils.ProjectUtils;
import br.com.gamaset.diaryboard.utils.StringUtils;

@Stateless
public class ApostaServiceImpl implements ApostaService{

	@Inject
	private ApostaRepository repo = null;
	@Inject
	private PlanoJogoItemRepository repoPlanoJogoItem = null;

	@Override
	public List<ApostaEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public ApostaEntity adicionarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		//colocar as validações
		try{
			entidade = repo.insert(entidade);
			calcularSaldoPlanoJogo(entidade);
		}catch(Exception e){
			
		}
		
		return entidade;
	}

	@Override
	public ApostaEntity editarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		//colocar as validações
		try{
			 entidade = repo.update(entidade);
			 calcularSaldoPlanoJogo(entidade);
		}catch (Exception e) {
		
		}
		
		return entidade;
	}
	
	@Override
	public void excluirEntidade(ApostaEntity entidade) {
		repoPlanoJogoItem.atualizarPlanoJogoAcompanhamentoExclusao(entidade);
		repo.delete(entidade);
	}

	@Override
	public void validateForm(ApostaEntity entidade) throws ValidationFormAbstractException {
		entidade.setTicket(StringUtils.trim(entidade.getTicket()));
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException("ticket: "+entidade.getTicket());
		}
	
		entidade.getBet().getEvento().setDescTimeCasa(entidade.getBet().getEvento().getDescTimeCasa().toUpperCase().trim());
		entidade.getBet().getEvento().setDescTimeVisitante(entidade.getBet().getEvento().getDescTimeVisitante().toUpperCase().trim());
		entidade.getBet().getEvento().setDescricaoEvento(ProjectUtils.genEventDescription(entidade.getBet().getEvento()));
//		entidade.getBet().getEvento().setOdd(entidade.getBet().getEvento().getOdd()==null?0.0:entidade.getBet().getEvento().getOdd());
		entidade.setValorAposta(entidade.getValorAposta()==null?BigDecimal.ZERO:entidade.getValorAposta());
		entidade.setValorRetorno(entidade.getValorRetorno()==null?BigDecimal.ZERO:entidade.getValorRetorno());
	
	
	}

	
	private void calcularSaldoPlanoJogo(ApostaEntity entidade){
		repoPlanoJogoItem.atualizarPlanoJogoAcompanhamento(entidade);
	}
}
