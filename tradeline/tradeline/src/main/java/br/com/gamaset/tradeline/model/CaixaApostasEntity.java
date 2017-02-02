package br.com.gamaset.tradeline.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAIXA_APOSTA")
public class CaixaApostasEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -3186260062624887725L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAAP_CD_ID_PK")
	private Long id;

	@Column(name = "CAAP_DT_MOVIMENTACAO")
	private Date dataMovimentacao;
	
	@Column(name = "CAAP_VL_MOVIMENTACAO", scale=2)
	private BigDecimal valorMovimentacao;

	@Column(name = "CAAP_VL_SALDO_PARA_JOGO", scale=2)
	private BigDecimal valorSaldoDisponivel;

	@Enumerated(EnumType.STRING)
	@Column(name = "CAAP_DS_MOVIMENTACAO", scale=2)
	private CaixaApostaTipoMovEnum tipoMovimentacaoEnum;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public BigDecimal getValorMovimentacao() {
		return valorMovimentacao;
	}

	public void setValorMovimentacao(BigDecimal valorMovimentacao) {
		this.valorMovimentacao = valorMovimentacao;
	}

	public CaixaApostaTipoMovEnum getTipoMovimentacaoEnum() {
		return tipoMovimentacaoEnum;
	}

	public void setTipoMovimentacaoEnum(CaixaApostaTipoMovEnum tipoMovimentacaoEnum) {
		this.tipoMovimentacaoEnum = tipoMovimentacaoEnum;
	}

	public BigDecimal getValorSaldoDisponivel() {
		return valorSaldoDisponivel;
	}

	public void setValorSaldoDisponivel(BigDecimal valorSaldoDisponivel) {
		this.valorSaldoDisponivel = valorSaldoDisponivel;
	}
}
