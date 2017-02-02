package br.com.gamaset.tradeline.dto.palpite;

import br.com.gamaset.tradeline.model.TimeEntity;

public class PalpiteEstatisticaPorMercadoTimeDTO extends PalpiteEstatisticaPorMercadoAbstract{

	private TimeEntity time;

	public TimeEntity getTime() {
		return time;
	}

	public void setTime(TimeEntity time) {
		this.time = time;
	}
	
}
