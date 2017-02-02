package br.com.gamaset.tradeline.dto.prosoccer;

public enum PalpiteEnun {

	TIME_CASA("1"), TIME_CASA_EMPATE("1X"), EMPATE("X"), EMPATE_TIME_VISITANTE("X2"), TIME_VISITANTE("2"), TIME_CASA_TIME_VISITANTE("12"), TIME_VISITANTE_TIME_CASA("21"), INDEFINIDO("");
	
	private String descricao = null;

	private PalpiteEnun(String descricao) {
		this.descricao = descricao;
	}

	
	@Override
	public String toString() {
		return descricao;
	}
	
}
