package br.com.gamaset.tradeline.dto.palpite;


public class PalpiteEstatisticaPorMercadoDTO {

	
	private PalpiteEstatisticaPorMercadoTableDTO tabelaResultadoFinal;
	private PalpiteEstatisticaPorMercadoTableDTO tabelaHipoteseDupla;
	private PalpiteEstatisticaPorMercadoTableDTO tabelaMercadoGols;

	public PalpiteEstatisticaPorMercadoTableDTO getTabelaResultadoFinal() {
		return tabelaResultadoFinal;
	}

	public void setTabelaResultadoFinal(PalpiteEstatisticaPorMercadoTableDTO tabelaResultadoFinal) {
		this.tabelaResultadoFinal = tabelaResultadoFinal;
	}

	public PalpiteEstatisticaPorMercadoTableDTO getTabelaHipoteseDupla() {
		return tabelaHipoteseDupla;
	}

	public void setTabelaHipoteseDupla(
			PalpiteEstatisticaPorMercadoTableDTO tabelaHipoteseDupla) {
		this.tabelaHipoteseDupla = tabelaHipoteseDupla;
	}

	public PalpiteEstatisticaPorMercadoTableDTO getTabelaMercadoGols() {
		return tabelaMercadoGols;
	}

	public void setTabelaMercadoGols(
			PalpiteEstatisticaPorMercadoTableDTO tabelaMercadoGols) {
		this.tabelaMercadoGols = tabelaMercadoGols;
	}
	
}
