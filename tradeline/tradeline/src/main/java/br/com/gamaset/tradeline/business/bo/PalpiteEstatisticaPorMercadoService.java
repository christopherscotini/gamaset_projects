package br.com.gamaset.tradeline.business.bo;

import br.com.gamaset.tradeline.dto.DataFilterDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoDTO;
import br.com.gamaset.tradeline.model.TipsterEntity;


public interface PalpiteEstatisticaPorMercadoService {

	public PalpiteEstatisticaPorMercadoDTO lerEstatisticasPorData(DataFilterDTO dataFiltro, TipsterEntity tipsterSelecionado);
	

}
