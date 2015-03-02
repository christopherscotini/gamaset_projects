package br.com.gamaset.diaryboard.business.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.CaixaApostasService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.CaixaApostaTipoMovEnum;
import br.com.gamaset.diaryboard.model.CaixaApostasEntity;
import br.com.gamaset.diaryboard.repository.CaixaApostaRepository;

@Stateless
public class CaixaApostasServiceImpl implements CaixaApostasService{

	@Inject
	private CaixaApostaRepository repo = null;

	@Override
	public List<CaixaApostasEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public CaixaApostasEntity adicionarEntidade(CaixaApostasEntity entidade) {
		validateForm(entidade);
		BigDecimal saldoRestante = verificarSaldoDisponivelParaInvestimento();
		if(saldoRestante != null){
			if(entidade.getTipoMovimentacaoEnum().equals(CaixaApostaTipoMovEnum.DEPOSITO) || entidade.getTipoMovimentacaoEnum().equals(CaixaApostaTipoMovEnum.ENTRADA_PLANO)){
				entidade.setValorSaldoDisponivel(saldoRestante.add(entidade.getValorMovimentacao()));
			}else{
				entidade.setValorSaldoDisponivel(saldoRestante.subtract(entidade.getValorMovimentacao()));
			}
		}else{
			entidade.setValorSaldoDisponivel(entidade.getValorMovimentacao());
		}
		
		return repo.insert(entidade);
	}

	@Override
	public CaixaApostasEntity editarEntidade(CaixaApostasEntity entidade) {
		validateForm(entidade);
		
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(CaixaApostasEntity entidade) {
		
	}

	@Override
	public void validateForm(CaixaApostasEntity entidade) throws ValidationFormAbstractException {
		
	}

	@Override
	public BigDecimal verificarSaldoDisponivelParaInvestimento() {
		return repo.getSaldoRestanteParaJogo();
	}
	
	@Override
	public BigDecimal getSaldoDisponivel() {
		return repo.getSaldoConta();
	}

}
