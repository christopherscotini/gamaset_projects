package br.com.gamaset.tradeline.business.bo;

import java.math.BigDecimal;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.CaixaApostasEntity;

public interface CaixaApostasService extends ServiceModel<CaixaApostasEntity>{
	
	BigDecimal verificarSaldoDisponivelParaInvestimento();

	BigDecimal getSaldoDisponivel();

}
