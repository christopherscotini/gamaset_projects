package br.com.gamaset.tradeline.business.bo.prosoccer;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;

public interface TimePSService extends ServiceModel<TimePSEntity>{

	List<TimePSEntity> buscarPorPais(PaisEntity paisSelecionada);

	List<TimePSEntity> listarTodosVincular(PaisEntity paisSelecionada);
	

}
