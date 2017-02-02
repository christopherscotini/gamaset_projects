package br.com.gamaset.tradeline.model;

public enum ApostaResultadoEnum {
	
	AINDA_POR_ACONTECER("Ainda por Acontecer"), GANHOU("Ganhou"), PERDEU("Perdeu"), TODOS("Todos");
	
	private final String label;

	private ApostaResultadoEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
