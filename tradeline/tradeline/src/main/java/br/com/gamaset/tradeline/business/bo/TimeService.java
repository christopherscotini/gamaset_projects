package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;

public interface TimeService extends ServiceModel<TimeEntity>{

	List<TimeEntity> buscarPorPais(PaisEntity paisSelecionada);

	List<TimeEntity> listarTodosVincular(PaisEntity pais);

}
