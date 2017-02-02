package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;

public interface PlanoJogoItemService extends ServiceModel<PlanoJogoItemEntity>{
	
	List<PlanoJogoItemEntity> buscarPorPlanoJogoId(Long id);

	PlanoJogoItemEntity busarPorId(Long id);

}
