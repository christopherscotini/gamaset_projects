package br.com.gamaset.tradeline.model.prosoccer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.gamaset.tradeline.model.AbstractEntity;
import br.com.gamaset.tradeline.model.PaisEntity;

@Entity
@Table(name="TIME_PROSOCCER")
public class TimePSEntity extends AbstractEntity{

	private static final long serialVersionUID = -2103900646437323479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TIPR_CD_ID_PK")
	private Long id;
	@Column(name = "TIPR_DS_NOME")
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "PAIS_CD_ID_FK")
	private PaisEntity pais;
	
	@Transient
	private String urlimgTmp;
	@Transient
	private String codigoCompeticao;
	
	public TimePSEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public TimePSEntity(Long id, String descricao, PaisEntity pais,
			String urlimgTmp, String codigoCompeticao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pais = pais;
		this.urlimgTmp = urlimgTmp;
		this.codigoCompeticao = codigoCompeticao;
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

	public String getUrlimgTmp() {
		return urlimgTmp;
	}

	public void setUrlimgTmp(String urlimgTmp) {
		this.urlimgTmp = urlimgTmp;
	}

	public String getCodigoCompeticao() {
		return codigoCompeticao;
	}

	public void setCodigoCompeticao(String codigoCompeticao) {
		this.codigoCompeticao = codigoCompeticao;
	}

	@Override
	public String toString() {
		return "TimePSEntity [id=" + id + ", descricao=" + descricao
				+ ", codigoCompeticao=" + codigoCompeticao + "]";
	}
	
}
