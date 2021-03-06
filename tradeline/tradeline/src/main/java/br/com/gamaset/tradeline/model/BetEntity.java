package br.com.gamaset.tradeline.model;

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
public class BetEntity extends AbstractEntity implements Serializable{
	
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
	@JoinColumn(name = "COMP_CD_ID_FK", nullable = false)
	private CompeticaoEntity competicao;
	

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

	public CompeticaoEntity getCompeticao() {
		return competicao;
	}

	public void setCompeticao(CompeticaoEntity competicao) {
		this.competicao = competicao;
	}

//	public ApostaEntity getAposta() {
//		return aposta;
//	}
//
//	public void setAposta(ApostaEntity aposta) {
//		this.aposta = aposta;
//	}

}
