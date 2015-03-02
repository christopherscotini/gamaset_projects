package br.com.gamaset.diaryboard.business.bo;

import java.math.BigDecimal;

import br.com.gamaset.diaryboard.business.ServiceModel;
import br.com.gamaset.diaryboard.model.CaixaApostasEntity;

public interface CaixaApostasService extends ServiceModel<CaixaApostasEntity>{
	
	BigDecimal verificarSaldoDisponivelParaInvestimento();

	BigDecimal getSaldoDisponivel();

}
