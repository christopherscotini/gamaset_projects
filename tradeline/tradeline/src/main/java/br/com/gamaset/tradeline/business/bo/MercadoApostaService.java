package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;

public interface MercadoApostaService extends ServiceModel<MercadoApostaEntity>{

	List<MercadoApostaEntity> buscarPorMercadoSelecao(MercadoApostaSelecaoEntity mercadoSelecaoSelecionado);
	
	

}
