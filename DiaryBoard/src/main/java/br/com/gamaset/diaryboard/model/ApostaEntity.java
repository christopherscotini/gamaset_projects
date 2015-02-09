package br.com.gamaset.diaryboard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "APOSTA")
public class ApostaEntity implements Serializable{
	
	private static final long serialVersionUID = 521614763444294035L;

	@Id
	@Column(name = "APOS_CD_ID_PK")
	private String id;

	@ManyToOne
	@JoinColumn(name = "BET_CD_ID_FK")
	private BetEntity bet;
	
	@Column(name = "APOS_DT_APOSTA")
	private Date dataBet;

	@Column(name = "APOS_FL_RESOLVIDA")
	private boolean statusResolvida;
	
	@Column(name = "APOS_VL_RETORNO")
	private BigDecimal valorRetorno;
	
	@Column(name = "APOS_VL_APOSTA")
	private BigDecimal valorAposta;
	
	@Column(name = "APOS_FL_MULTIPLA")
	private boolean apostaMultipla;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public List<BetEntity> getBets() {
//		return bets;
//	}
//
//	public void setBets(List<BetEntity> bets) {
//		this.bets = bets;
//	}

	public Date getDataBet() {
		return dataBet;
	}

	public BetEntity getBet() {
		return bet;
	}

	public void setBet(BetEntity bet) {
		this.bet = bet;
	}

	public void setDataBet(Date dataBet) {
		this.dataBet = dataBet;
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

	public boolean isApostaMultipla() {
		return apostaMultipla;
	}

	public void setApostaMultipla(boolean apostaMultipla) {
		this.apostaMultipla = apostaMultipla;
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
