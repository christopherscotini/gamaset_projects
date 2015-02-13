package br.com.gamaset.diaryboard.business.bo;

import br.com.gamaset.diaryboard.business.ServiceModel;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;

public interface PlanoJogoItemService extends ServiceModel<PlanoJogoItemEntity>{
	
	PlanoJogoItemEntity buscarPorPlanoJogoId(PlanoJogoEntity entity);

}
