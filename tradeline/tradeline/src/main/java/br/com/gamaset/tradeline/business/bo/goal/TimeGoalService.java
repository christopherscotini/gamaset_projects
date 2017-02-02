package br.com.gamaset.tradeline.business.bo.goal;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;

public interface TimeGoalService extends ServiceModel<TimeGoalEntity>{

	List<TimeGoalEntity> buscarPorPais(PaisEntity paisSelecionada);

	List<TimeGoalEntity> listarTodosVincular(PaisEntity paisSelecionada);

	TimeGoalEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais);


}
