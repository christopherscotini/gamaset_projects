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
	@JoinColumn(name = "BAND_DS_FLAG")
	private FlagEntity flag;
	
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

	public FlagEntity getFlag() {
		return flag;
	}

	public void setFlag(FlagEntity flag) {
		this.flag = flag;
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
		CampeonatoEntity other = (CampeonatoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
