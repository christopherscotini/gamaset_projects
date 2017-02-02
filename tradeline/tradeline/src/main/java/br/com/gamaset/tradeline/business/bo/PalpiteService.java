package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.ApostaResultadoEnum;
import br.com.gamaset.tradeline.model.PalpiteEntity;

public interface PalpiteService extends ServiceModel<PalpiteEntity>{

	List<PalpiteEntity> buscarPorApostaResultado(ApostaResultadoEnum apostaResultadoFiltro);
	
	

}
