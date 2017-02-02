package br.com.gamaset.tradeline.model.prosoccer;

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
@Table(name="COMPETICAO_PROSOCCER")
public class CompeticaoPSEntity extends AbstractEntity{

	private static final long serialVersionUID = 5127221166535183292L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COPR_CD_ID_PK")
	private Long id;
	
	@Column(name = "COPR_DS_CODIGO")
	private String codigoDescricao;
	
	@Column(name = "COPR_DS_NOME")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "PAIS_CD_ID_FK")
	private PaisEntity pais;
	
	public CompeticaoPSEntity() {

	}
	
	public CompeticaoPSEntity(Long id, String codigoDescricao,
			String descricao, PaisEntity pais) {
		super();
		this.id = id;
		this.codigoDescricao = codigoDescricao;
		this.descricao = descricao;
		this.pais = pais;
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

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}

	public String getCodigoDescricao() {
		return codigoDescricao;
	}

	public void setCodigoDescricao(String codigoDescricao) {
		this.codigoDescricao = codigoDescricao;
	}
	
	@Override
	public String toString() {
		return "[id="+id+",descricao="+descricao+",pais="+pais.getDescricao()+"]";
	}
	
}
