package br.com.gamaset.diaryboard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovimentacaoEntity implements Serializable{

	private static final long serialVersionUID = 8439040107080399547L;

	private Long id;
	private String descricao;
	private Date dataMovimentacao;
	private BigDecimal valorMovimentacao;
	private TipoMovimentacaoEntity tipoMovimentacao;
	private CategoriaMovimentacaoEntity categoriaMovimentacao;
	
	
	public MovimentacaoEntity() {

	}

	public MovimentacaoEntity(Long id, String descricao, Date dataMovimentacao,
			BigDecimal valorMovimentacao,
			TipoMovimentacaoEntity tipoMovimentacao,
			CategoriaMovimentacaoEntity categoriaMovimentacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataMovimentacao = dataMovimentacao;
		this.valorMovimentacao = valorMovimentacao;
		this.tipoMovimentacao = tipoMovimentacao;
		this.categoriaMovimentacao = categoriaMovimentacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public TipoMovimentacaoEntity getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEntity tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public CategoriaMovimentacaoEntity getCategoriaMovimentacao() {
		return categoriaMovimentacao;
	}

	public void setCategoriaMovimentacao(
			CategoriaMovimentacaoEntity categoriaMovimentacao) {
		this.categoriaMovimentacao = categoriaMovimentacao;
	}
	
}
