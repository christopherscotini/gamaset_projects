package br.com.gamaset.tradeline.dto.palpite;

import java.math.BigDecimal;

public abstract class PalpiteEstatisticaPorMercadoAbstract {

	private BigDecimal percentAproveitamento; 
	private BigDecimal percentRentabilidade;
	private Integer totalDePalpites;
	private Integer totalDeAcertos;
	
	
	
	public BigDecimal getPercentAproveitamento() {
		return percentAproveitamento;
	}
	public void setPercentAproveitamento(BigDecimal percentAproveitamento) {
		this.percentAproveitamento = percentAproveitamento;
	}
	public BigDecimal getPercentRentabilidade() {
		return percentRentabilidade;
	}
	public void setPercentRentabilidade(BigDecimal percentRentabilidade) {
		this.percentRentabilidade = percentRentabilidade;
	}
	public Integer getTotalDePalpites() {
		return totalDePalpites;
	}
	public void setTotalDePalpites(Integer totalDePalpites) {
		this.totalDePalpites = totalDePalpites;
	}
	public Integer getTotalDeAcertos() {
		return totalDeAcertos;
	}
	public void setTotalDeAcertos(Integer totalDeAcertos) {
		this.totalDeAcertos = totalDeAcertos;
	}
	
}
