package br.com.gamaset.diaryboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MERCADO_APOSTA_SELECAO")
public class MercadoApostaSelecaoEntity implements Serializable{

	private static final long serialVersionUID = 2873210809174537994L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEAS_CD_ID_PK")
	private Long id;
	
	@Column(name = "MEAS_DS_DESCRICAO")
	private String descricao;
	
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
