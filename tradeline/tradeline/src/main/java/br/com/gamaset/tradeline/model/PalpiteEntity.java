package br.com.gamaset.tradeline.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PALPITE")
public class PalpiteEntity extends AbstractEntity{
	
	private static final long serialVersionUID = 5393807791517388836L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PALP_CD_ID_PK")
	private Long id;
	
	@ManyToOne    
	@JoinColumn(name = "TIME_CD_ID_FK_CASA")
	private TimeEntity timeCasa;
	
	@ManyToOne
	@JoinColumn(name = "TIME_CD_ID_FK_FORA")
	private TimeEntity timeVisitante;
	
	@ManyToOne
	@JoinColumn(name = "COMP_CD_ID_FK")
	private CompeticaoEntity competicao;

	@ManyToOne
	@JoinColumn(name = "MEAP_CD_ID_FK")
	private MercadoApostaEntity mercadoAposta;

	@ManyToOne
	@JoinColumn(name = "TIPS_CD_ID_FK")
	private TipsterEntity tipster;
	
	@Column(name = "PALP_VL_ODD")
	private BigDecimal valorOdd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PALP_DT_EVENTO")
	private Date dataEvento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PALP_DS_STATUS")
	private ApostaResultadoEnum statusPalpite;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CompeticaoEntity getCompeticao() {
		return competicao;
	}
	public void setCompeticao(CompeticaoEntity competicao) {
		this.competicao = competicao;
	}
	public MercadoApostaEntity getMercadoAposta() {
		return mercadoAposta;
	}
	public void setMercadoAposta(MercadoApostaEntity mercadoAposta) {
		this.mercadoAposta = mercadoAposta;
	}
	public BigDecimal getValorOdd() {
		return valorOdd;
	}
	public void setValorOdd(BigDecimal valorOdd) {
		this.valorOdd = valorOdd;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public ApostaResultadoEnum getStatusPalpite() {
		return statusPalpite;
	}
	public void setStatusPalpite(ApostaResultadoEnum statusPalpite) {
		this.statusPalpite = statusPalpite;
	}
	public TipsterEntity getTipster() {
		return tipster;
	}
	public void setTipster(TipsterEntity tipster) {
		this.tipster = tipster;
	}
	
}
