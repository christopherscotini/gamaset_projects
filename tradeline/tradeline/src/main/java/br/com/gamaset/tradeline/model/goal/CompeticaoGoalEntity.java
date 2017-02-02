package br.com.gamaset.tradeline.model.goal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gamaset.tradeline.model.AbstractEntity;
import br.com.gamaset.tradeline.model.PaisEntity;


@Entity
@Table(name="COMPETICAO_GOAL")
public class CompeticaoGoalEntity extends AbstractEntity{

	
	private static final long serialVersionUID = 5127221166535183292L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COGO_CD_ID_PK")
	private Long id;
	@Column(name = "COGO_DS_NOME")
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "PAIS_CD_ID_FK")
	private PaisEntity pais;
	
	
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

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "[id="+id+",descricao="+descricao+",pais="+(pais==null?null:pais.getDescricao())+"]";
	}
}
