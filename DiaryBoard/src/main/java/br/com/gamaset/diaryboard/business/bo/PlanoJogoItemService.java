package br.com.gamaset.diaryboard.business.bo;

import java.util.List;

import br.com.gamaset.diaryboard.business.ServiceModel;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;

public interface PlanoJogoItemService extends ServiceModel<PlanoJogoItemEntity>{
	
	List<PlanoJogoItemEntity> buscarPorPlanoJogoId(Long id);

	PlanoJogoItemEntity busarPorId(Long id);

}
