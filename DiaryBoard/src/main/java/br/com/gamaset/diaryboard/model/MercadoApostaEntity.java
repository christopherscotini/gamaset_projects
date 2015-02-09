package br.com.gamaset.diaryboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MERCADO_APOSTA")
public class MercadoApostaEntity implements Serializable{
	
	private static final long serialVersionUID = 6884028521908601699L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEAP_CD_ID_PK")
	private Long id;
	
	@Column(name = "MEAP_DS_DESCRICAO")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "MEAS_CD_ID_FK")
	private MercadoApostaSelecaoEntity selecao;

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

	public MercadoApostaSelecaoEntity getSelecao() {
		return selecao;
	}

	public void setSelecao(MercadoApostaSelecaoEntity selecao) {
		this.selecao = selecao;
	}


}
