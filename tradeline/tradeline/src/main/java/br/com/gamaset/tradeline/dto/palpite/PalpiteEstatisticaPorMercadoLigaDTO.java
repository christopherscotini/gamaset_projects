package br.com.gamaset.tradeline.dto.palpite;

import br.com.gamaset.tradeline.model.CompeticaoEntity;

public class PalpiteEstatisticaPorMercadoLigaDTO extends PalpiteEstatisticaPorMercadoAbstract{

	private CompeticaoEntity liga; 
	
	public CompeticaoEntity getLiga() {
		return liga;
	}
	public void setLiga(CompeticaoEntity liga) {
		this.liga = liga;
	} 
	
	
}
