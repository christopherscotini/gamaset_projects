package br.com.gamaset.tradeline.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Timeout;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "EVENTO")
public class EventoEntity extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 5473644984592016465L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "EVEN_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "TIME_CD_ID_FK_TIMECASA")
	private TimeEntity timeCasa;

	@ManyToOne
	@JoinColumn(name = "TIME_CD_ID_FK_VISITANTE")
	private TimeEntity timeVisitante;
	
	@Temporal(TemporalType.TIMESTAMP)
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

	public TimeEntity getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(TimeEntity timeCasa) {
		this.timeCasa = timeCasa;
	}

	public TimeEntity getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(TimeEntity timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

//	public ResultadoEntityEnum getResultado() {
//		return resultado;
//	}
//
//	public void setResultado(ResultadoEntityEnum resultado) {
//		this.resultado = resultado;
//	}
	
	
	
}
