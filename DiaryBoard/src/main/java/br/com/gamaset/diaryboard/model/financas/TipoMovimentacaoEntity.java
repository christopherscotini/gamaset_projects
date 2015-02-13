package br.com.gamaset.diaryboard.model.financas;

import java.io.Serializable;

public class TipoMovimentacaoEntity implements Serializable{
	
	private static final long serialVersionUID = 5473644984592016465L;
	
	private Long id;
	private String descricao;

	public TipoMovimentacaoEntity() {

	}

	public TipoMovimentacaoEntity(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
	
}
