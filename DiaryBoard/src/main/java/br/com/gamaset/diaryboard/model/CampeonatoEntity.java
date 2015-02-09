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
@Table(name = "CAMPEONATO")
public class CampeonatoEntity implements Serializable{
	
	private static final long serialVersionUID = 5473644984592016465L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CAMP_CD_ID_PK")
	private Long id;

	@Column(name = "CAMP_DS_SIGLA")
	private String sigla;

	@Column(name = "CAMP_DS_URL_COMPETICAO")
	private String urlCompeticao;
	
	@ManyToOne
	@JoinColumn(name = "CAMP_DS_FLAG")
	private FlagEntity img;
	
	@Column(name = "CAMP_FL_ACADEMIA")
	private boolean habilitadoAcademia;
	
	@Column(name = "CAMP_FL_PROSOCCER")
	private boolean habilitadoProsoccer;

	public CampeonatoEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlCompeticao() {
		return urlCompeticao;
	}

	public void setUrlCompeticao(String urlCompeticao) {
		this.urlCompeticao = urlCompeticao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public FlagEntity getImg() {
		return img;
	}

	public void setImg(FlagEntity img) {
		this.img = img;
	}

	public boolean isHabilitadoAcademia() {
		return habilitadoAcademia;
	}

	public void setHabilitadoAcademia(boolean habilitadoAcademia) {
		this.habilitadoAcademia = habilitadoAcademia;
	}

	public boolean isHabilitadoProsoccer() {
		return habilitadoProsoccer;
	}

	public void setHabilitadoProsoccer(boolean habilitadoProsoccer) {
		this.habilitadoProsoccer = habilitadoProsoccer;
	}
	

}
