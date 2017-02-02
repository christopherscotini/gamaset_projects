package br.com.gamaset.tradeline.dto;

import java.math.BigDecimal;

import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;

public class PlanoJogoDetalheDTO {

	private PlanoJogoItemEntity planoJogoItemAtual;
	private BigDecimal lucroParcial;
	private Integer numeroBets;
	private Integer numeroAcertos;
	private Integer numeroErros;
	private BigDecimal totalGanhoParcial;
	private BigDecimal totalPerdidoParcial;
	
	public PlanoJogoItemEntity getPlanoJogoItemAtual() {
		return planoJogoItemAtual;
	}
	public void setPlanoJogoItemAtual(PlanoJogoItemEntity planoJogoItemAtual) {
		this.planoJogoItemAtual = planoJogoItemAtual;
	}
	public BigDecimal getLucroParcial() {
		return lucroParcial;
	}
	public void setLucroParcial(BigDecimal lucroParcial) {
		this.lucroParcial = lucroParcial;
	}
	public Integer getNumeroBets() {
		return numeroBets;
	}
	public void setNumeroBets(Integer numeroBets) {
		this.numeroBets = numeroBets;
	}
	public Integer getNumeroAcertos() {
		return numeroAcertos;
	}
	public void setNumeroAcertos(Integer numeroAcertos) {
		this.numeroAcertos = numeroAcertos;
	}
	public Integer getNumeroErros() {
		return numeroErros;
	}
	public void setNumeroErros(Integer numeroErros) {
		this.numeroErros = numeroErros;
	}
	public BigDecimal getTotalGanhoParcial() {
		return totalGanhoParcial;
	}
	public void setTotalGanhoParcial(BigDecimal totalGanhoParcial) {
		this.totalGanhoParcial = totalGanhoParcial;
	}
	public BigDecimal getTotalPerdidoParcial() {
		return totalPerdidoParcial;
	}
	public void setTotalPerdidoParcial(BigDecimal totalPerdidoParcial) {
		this.totalPerdidoParcial = totalPerdidoParcial;
	}
	
}
