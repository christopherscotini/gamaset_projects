package br.com.gamaset.tradeline.dto.palpite;

import java.util.List;

public class PalpiteEstatisticaPorMercadoTableDTO {

	private List<PalpiteEstatisticaPorMercadoLigaDTO> listaEstatisticaPorLiga;
	private List<PalpiteEstatisticaPorMercadoTimeDTO> listaEstatisticaPorTime;
	
	public List<PalpiteEstatisticaPorMercadoLigaDTO> getListaEstatisticaPorLiga() {
		return listaEstatisticaPorLiga;
	}
	public void setListaEstatisticaPorLiga(
			List<PalpiteEstatisticaPorMercadoLigaDTO> listaEstatisticaPorLiga) {
		this.listaEstatisticaPorLiga = listaEstatisticaPorLiga;
	}
	public List<PalpiteEstatisticaPorMercadoTimeDTO> getListaEstatisticaPorTime() {
		return listaEstatisticaPorTime;
	}
	public void setListaEstatisticaPorTime(
			List<PalpiteEstatisticaPorMercadoTimeDTO> listaEstatisticaPorTime) {
		this.listaEstatisticaPorTime = listaEstatisticaPorTime;
	}
	
}
