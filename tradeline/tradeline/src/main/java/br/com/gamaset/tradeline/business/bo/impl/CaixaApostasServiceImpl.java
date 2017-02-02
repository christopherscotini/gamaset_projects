package br.com.gamaset.tradeline.business.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.CaixaApostasService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.CaixaApostaTipoMovEnum;
import br.com.gamaset.tradeline.model.CaixaApostasEntity;
import br.com.gamaset.tradeline.repository.CaixaApostaRepository;

@Stateless
public class CaixaApostasServiceImpl implements CaixaApostasService{

	@Inject
	private CaixaApostaRepository repo = null;

	public List<CaixaApostasEntity> listarTodos() {
		return repo.findAll();
	}

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

	public CaixaApostasEntity editarEntidade(CaixaApostasEntity entidade) {
		validateForm(entidade);
		
		return repo.update(entidade);
	}
	
	public void excluirEntidade(CaixaApostasEntity entidade) {
		
	}

	public void validateForm(CaixaApostasEntity entidade) throws ValidationFormAbstractException {
		
	}

	public BigDecimal verificarSaldoDisponivelParaInvestimento() {
		return repo.getSaldoRestanteParaJogo();
	}
	
	public BigDecimal getSaldoDisponivel() {
		return repo.getSaldoConta();
	}

}
