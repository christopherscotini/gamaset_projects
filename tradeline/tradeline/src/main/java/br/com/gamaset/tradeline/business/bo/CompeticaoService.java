package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;

public interface CompeticaoService extends ServiceModel<CompeticaoEntity>{

	List<CompeticaoEntity> buscarPorPais(PaisEntity pais);
	

}
