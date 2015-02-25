package br.com.gamaset.diaryboard.model;

public enum CaixaApostaTipoMovEnum {
	
	DEPOSITO("Deposito"),
	SAQUE("Saque"), 
	ENTRADA_PLANO("Entrada atraves de Plano de Jogo"),
	SAIDA_PLANO("Saida para Plano de Jogo");
	
	private final String label;

	private CaixaApostaTipoMovEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
