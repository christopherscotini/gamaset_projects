package br.com.gamaset.tradeline.business.bo;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;

public interface TimeUnionService extends ServiceModel<TimeUnionEntity>{

	TimeUnionEntity buscarPorDescricaoProSoccerAndPais(String descricaoTime, PaisEntity pais);

	TimeUnionEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais);

}
