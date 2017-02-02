package br.com.gamaset.tradeline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PAIS")
public class PaisEntity extends AbstractEntity{

	private static final long serialVersionUID = 3639402226997839885L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PAIS_CD_ID_PK")
	private Long id;
	@Column(name = "PAIS_CD_GOAL")
	private Long idGoal;
	@Column(name = "PAIS_DS_NOME")
	private String descricao;
	@Column(name = "PAIS_DS_IMG")
	private String urlImg;
	
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

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Long getIdGoal() {
		return idGoal;
	}

	public void setIdGoal(Long idGoal) {
		this.idGoal = idGoal;
	}
	
}
