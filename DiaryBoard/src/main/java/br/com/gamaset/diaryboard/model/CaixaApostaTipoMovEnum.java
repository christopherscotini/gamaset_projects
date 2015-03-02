package br.com.gamaset.diaryboard.model;

public enum CaixaApostaTipoMovEnum {
	
	DEPOSITO("Deposito"),
	SAQUE("Saque"), 
	ENTRADA_PLANO("Entrada atraves de Plano de Jogo"),//QUANDO SE ENCERRA UM PLANO (ADICIONA)
	SAIDA_PLANO("Saida para iniciar Plano de Jogo");//QUANDO SE INICIA (SUBTRAI)
	
	private final String label;

	private CaixaApostaTipoMovEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
