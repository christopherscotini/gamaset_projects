package br.com.gamaset.diaryboard.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BET")
public class BetEntity implements Serializable{
	
	private static final long serialVersionUID = 5473644984592016465L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BET_CD_ID_PK")
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "EVEN_CD_ID_FK", nullable = false)
	private EventoEntity evento;
	
//	@ManyToOne
//	@JoinColumn(name = "APOS_CD_ID_FK", nullable = false)
//	private ApostaEntity aposta;
	
	@ManyToOne
	@JoinColumn(name = "CAMP_CD_ID_FK", nullable = false)
	private CampeonatoEntity campeonato;
	

	public EventoEntity getEvento() {
		return evento;
	}

	public void setEvento(EventoEntity evento) {
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public ApostaEntity getAposta() {
//		return aposta;
//	}
//
//	public void setAposta(ApostaEntity aposta) {
//		this.aposta = aposta;
//	}

	public CampeonatoEntity getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(CampeonatoEntity campeonato) {
		this.campeonato = campeonato;
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
		BetEntity other = (BetEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
