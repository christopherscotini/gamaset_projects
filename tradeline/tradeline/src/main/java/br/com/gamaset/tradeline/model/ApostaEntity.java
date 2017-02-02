package br.com.gamaset.tradeline.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
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


@Entity
@Table(name = "APOSTA")
public class ApostaEntity implements Serializable{
	
	private static final long serialVersionUID = 521614763444294035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APOS_CD_ID_PK")
	private Long id;

	@Column(name = "APOS_CD_ID_TICKET", unique=true)
	private String ticket;
	
	@Column(name = "APOS_DT_APOSTA")
	private Date dataAposta;

	@Column(name = "APOS_FL_RESOLVIDA")
	private boolean statusResolvida;
	
	@Column(name = "APOS_VL_RETORNO")
	private BigDecimal valorRetorno;
	
	@Column(name = "APOS_VL_APOSTA")
	private BigDecimal valorAposta;
	
//	@Column(name = "APOS_FL_MULTIPLA")
//	private boolean apostaMultipla;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "APOS_DS_RESULTADO")
	private ApostaResultadoEnum resultado;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "BET_CD_ID_FK")
	private BetEntity bet;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PLJI_CD_ID_FK")
	private PlanoJogoItemEntity planoJogoItem;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	public List<BetEntity> getBets() {
//		return bets;
//	}
//
//	public void setBets(List<BetEntity> bets) {
//		this.bets = bets;
//	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Date getDataAposta() {
		return dataAposta;
	}

	public BetEntity getBet() {
		return bet;
	}

	public void setBet(BetEntity bet) {
		this.bet = bet;
	}

	public void setDataAposta(Date dataAposta) {
		this.dataAposta = dataAposta;
	}

	public boolean isStatusResolvida() {
		return statusResolvida;
	}

	public void setStatusResolvida(boolean statusResolvida) {
		this.statusResolvida = statusResolvida;
	}

	public BigDecimal getValorRetorno() {
		return valorRetorno;
	}

	public void setValorRetorno(BigDecimal valorRetorno) {
		this.valorRetorno = valorRetorno;
	}

	public BigDecimal getValorAposta() {
		return valorAposta;
	}

	public void setValorAposta(BigDecimal valorAposta) {
		this.valorAposta = valorAposta;
	}

//	public boolean isApostaMultipla() {
//		return apostaMultipla;
//	}
//
//	public void setApostaMultipla(boolean apostaMultipla) {
//		this.apostaMultipla = apostaMultipla;
//	}

	public ApostaResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ApostaResultadoEnum resultado) {
		this.resultado = resultado;
	}

	public PlanoJogoItemEntity getPlanoJogoItem() {
		return planoJogoItem;
	}

	public void setPlanoJogoItem(PlanoJogoItemEntity planoJogoItem) {
		this.planoJogoItem = planoJogoItem;
	}

	
	
//	@Transient
//	public CampeonatoEntity getCampeonatoAposta(){
//		if(!apostaMultipla){
//			return bets.get(0).getCampeonato();
//		}else{
//			return null;
//		}
//	}
	
}
