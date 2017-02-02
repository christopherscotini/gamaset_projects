package br.com.gamaset.tradeline.business.bo.prosoccer;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;

public interface CompeticaoPSService extends ServiceModel<CompeticaoPSEntity>{

	List<CompeticaoPSEntity> buscarPorPais(PaisEntity pais);

	CompeticaoPSEntity buscarPorCodCompeticao(String codigoCompeticao);


}
