package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;

public interface CompeticaoUnionService extends ServiceModel<CompeticaoUnionEntity>{

	CompeticaoUnionEntity buscarPorIdCompeticaoSistema(CompeticaoEntity competicao);
	CompeticaoUnionEntity buscarPorIdCompeticaoGoal(CompeticaoGoalEntity competicao);
	CompeticaoUnionEntity buscarPorIdCompeticaoProsoccer(CompeticaoPSEntity competicao);
	
}
