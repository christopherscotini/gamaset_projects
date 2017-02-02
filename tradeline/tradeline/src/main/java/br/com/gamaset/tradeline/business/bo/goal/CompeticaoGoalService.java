package br.com.gamaset.tradeline.business.bo.goal;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;

public interface CompeticaoGoalService extends ServiceModel<CompeticaoGoalEntity>{

	List<CompeticaoGoalEntity> buscarPorPais(PaisEntity pais);

}
