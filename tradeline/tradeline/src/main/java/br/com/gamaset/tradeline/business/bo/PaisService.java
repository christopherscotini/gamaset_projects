package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;

public interface PaisService extends ServiceModel<PaisEntity>{

	PaisEntity buscarPorId(Long id);

	List<PaisEntity> listarTodosComCompeticaoAssociada();

	PaisEntity buscarPorGoalId(Long idGoal);
	
	

}
