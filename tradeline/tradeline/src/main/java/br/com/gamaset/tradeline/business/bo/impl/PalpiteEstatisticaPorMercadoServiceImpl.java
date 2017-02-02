package br.com.gamaset.tradeline.business.bo.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.PalpiteEstatisticaPorMercadoService;
import br.com.gamaset.tradeline.dto.DataFilterDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoTableDTO;
import br.com.gamaset.tradeline.model.TipsterEntity;
import br.com.gamaset.tradeline.repository.PalpiteEstatisticaPorMercadoRepository;

@Stateless
public class PalpiteEstatisticaPorMercadoServiceImpl implements PalpiteEstatisticaPorMercadoService{

	private final Long RESULTADO_FINAL_ID = 1L;
	private final Long HIPOTESE_DUPLA = 2L;
	private final Long GOLS_ID = 4L;
	
	@Inject
	private PalpiteEstatisticaPorMercadoRepository repo = null;

	public PalpiteEstatisticaPorMercadoDTO lerEstatisticasPorData(DataFilterDTO dataFiltro, TipsterEntity tipsterSelecionado) {
		PalpiteEstatisticaPorMercadoDTO dto = new PalpiteEstatisticaPorMercadoDTO();
		dto.setTabelaResultadoFinal(lerMercadoResultadoFinal(dataFiltro, tipsterSelecionado));
		
		
		return dto;
	}
	
	private PalpiteEstatisticaPorMercadoTableDTO lerMercadoResultadoFinal(DataFilterDTO dataFiltro, TipsterEntity tipsterSelecionado){
		
		return repo.lerEstatisticaPorMercadoData(dataFiltro, RESULTADO_FINAL_ID, tipsterSelecionado);
	}
	
	private PalpiteEstatisticaPorMercadoTableDTO lerMercadoHipoteseDupla(DataFilterDTO dataFiltro){
		
		return null;
	}
	
	private PalpiteEstatisticaPorMercadoTableDTO lerMercadoGols(DataFilterDTO dataFiltro){
		
		return null;
	}

	
	
}
