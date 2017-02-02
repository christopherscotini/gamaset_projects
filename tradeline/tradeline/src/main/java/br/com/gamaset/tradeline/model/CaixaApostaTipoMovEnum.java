package br.com.gamaset.tradeline.model;

public enum CaixaApostaTipoMovEnum {
	
	DEPOSITO("Deposito"),
	SAQUE("Saque"), 
	ENTRADA_PLANO("Entrada via Plano de Jogo (Fim de Metas)"),//QUANDO SE ENCERRA UM PLANO (ADICIONA)
	SAIDA_PLANO("Saida inicio de Plano de Jogo");//QUANDO SE INICIA (SUBTRAI)
	
	private final String label;

	private CaixaApostaTipoMovEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
