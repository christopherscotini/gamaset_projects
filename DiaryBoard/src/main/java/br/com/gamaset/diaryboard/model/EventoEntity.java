package br.com.gamaset.diaryboard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "EVENTO")
public class EventoEntity implements Serializable{
	
	private static final long serialVersionUID = 5473644984592016465L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "EVEN_CD_ID_PK")
	private Long id;
	
	@Column(name = "EVEN_DS_EVENTO")
	private String descricaoEvento;
	
	@Column(name = "EVEN_DS_TIMECASA")
	private String descTimeCasa;

	@Column(name = "EVEN_DS_TIMEVISITANTE")
	private String descTimeVisitante;
	
	@Column(name = "EVEN_DT_EVENTO")
	private Date dataEvento;
	
	@Column(name = "EVEN_NM_ODD", scale=3)
	private BigDecimal odd;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "EVEN_DS_RESULTADO")
//	private ResultadoEntityEnum resultado;

	@ManyToOne
	@JoinColumn(name = "MEAP_CD_ID_FK")
	private MercadoApostaEntity mercado;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public String getDescTimeCasa() {
		return descTimeCasa;
	}

	public void setDescTimeCasa(String descTimeCasa) {
		this.descTimeCasa = descTimeCasa;
	}

	public String getDescTimeVisitante() {
		return descTimeVisitante;
	}

	public void setDescTimeVisitante(String descTimeVisitante) {
		this.descTimeVisitante = descTimeVisitante;
	}

	public MercadoApostaEntity getMercado() {
		return mercado;
	}

	public void setMercado(MercadoApostaEntity mercado) {
		this.mercado = mercado;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public BigDecimal getOdd() {
		return odd==null?odd:odd.setScale(3);
	}

	public void setOdd(BigDecimal odd) {
		this.odd = odd;
	}

//	public ResultadoEntityEnum getResultado() {
//		return resultado;
//	}
//
//	public void setResultado(ResultadoEntityEnum resultado) {
//		this.resultado = resultado;
//	}
	
	
}
