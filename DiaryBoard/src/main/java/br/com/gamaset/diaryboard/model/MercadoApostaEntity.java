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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MercadoApostaEntity other = (MercadoApostaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
