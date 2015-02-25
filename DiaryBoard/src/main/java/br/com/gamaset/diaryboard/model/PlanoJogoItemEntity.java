package br.com.gamaset.diaryboard.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PLANO_JOGO_ITEM")
public class PlanoJogoItemEntity implements Serializable {

	private static final long serialVersionUID = 521614763444294035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLJI_CD_ID_PK")
	private Long id;

	/*** VALORES ESTATICOS ***/
	@Column(name = "PLJI_DS_DESCRICAO")
	private String descricao;
	@Column(name = "PLJI_VL_BET_DIA_OBJETIVO")
	private BigDecimal vlrBetDiaObjetivo;
	@Column(name = "PLJI_VL_INICIAL_DIA_OBJETIVO")
	private BigDecimal vlrInicialDiaObjetivo;
	@Column(name = "PLJI_VL_FINAL_DIA_OBJETIVO")
	private BigDecimal vlrFinalDiaObjetivo;
	@Column(name = "PLJI_VL_LUCRO_DIA_OBJETIVO")
	private BigDecimal vlrLucroDiaObjetivo;
	
	
	@Column(name = "PLJI_VL_BET_DIA")
	private BigDecimal vlrBetDia;
	@Column(name = "PLJI_VL_INICIAL_DIA")
	private BigDecimal vlrInicialDia;
	@Column(name = "PLJI_VL_FINAL_DIA")
	private BigDecimal vlrFinalDia;
	@Column(name = "PLJI_PC_OBJETIVO_CONCLUIDO")
	private BigDecimal percObjetivoConcluidoDia;
	@Column(name = "PLJI_VL_LUCRO_DIA")
	private BigDecimal vlrLucroDia;
	@Column(name = "PLJI_PC_LUCRO_DIA")
	private BigDecimal percLucroDia;
	@Column(name = "PLJI_PC_LUCRO_META")
	private BigDecimal percLucroMeta;
	@Column(name = "PLJI_VL_TOTAL_GANHO_DIA")
	private BigDecimal vlrTotalGanhoDia;
	@Column(name = "PLJI_VL_TOTAL_PERDIDO_DIA")
	private BigDecimal vlrTotalPerdidoDia;

	// bet/dia Saldo inicial/dia Saldo Final/dia % Objetivo R$ Lucro/dia %
	// Lucro/meta % Lucro Total Ganho Total Perdido Total em jogo Loses Wins N°
	// Apostas Meta Lucro/dia

	@ManyToOne
	@JoinColumn(name = "PLJO_CD_ID_FK")
	private PlanoJogoEntity planoJogo;

	@OneToMany(mappedBy = "planoJogoItem", fetch = FetchType.LAZY)
	private List<ApostaEntity> apostas;
	
	@Column(name = "PLJI_FL_FINALIZADO")
	private boolean finalizado;

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

	public BigDecimal getVlrBetDia() {
		return vlrBetDia;
	}

	public void setVlrBetDia(BigDecimal vlrBetDia) {
		this.vlrBetDia = vlrBetDia;
	}

	public BigDecimal getVlrInicialDia() {
		return vlrInicialDia;
	}

	public void setVlrInicialDia(BigDecimal vlrInicialDia) {
		this.vlrInicialDia = vlrInicialDia;
	}

	public BigDecimal getVlrFinalDia() {
		return vlrFinalDia;
	}

	public void setVlrFinalDia(BigDecimal vlrFinalDia) {
		this.vlrFinalDia = vlrFinalDia;
	}

	public BigDecimal getPercObjetivoConcluidoDia() {
		return percObjetivoConcluidoDia;
	}

	public void setPercObjetivoConcluidoDia(BigDecimal percObjetivoConcluidoDia) {
		this.percObjetivoConcluidoDia = percObjetivoConcluidoDia;
	}

	public BigDecimal getVlrLucroDia() {
		return vlrLucroDia;
	}

	public void setVlrLucroDia(BigDecimal vlrLucroDia) {
		this.vlrLucroDia = vlrLucroDia;
	}

	public BigDecimal getPercLucroDia() {
		return percLucroDia;
	}

	public void setPercLucroDia(BigDecimal percLucroDia) {
		this.percLucroDia = percLucroDia;
	}

	public BigDecimal getPercLucroMeta() {
		return percLucroMeta;
	}

	public void setPercLucroMeta(BigDecimal percLucroMeta) {
		this.percLucroMeta = percLucroMeta;
	}

	public BigDecimal getVlrTotalGanhoDia() {
		return vlrTotalGanhoDia;
	}

	public void setVlrTotalGanhoDia(BigDecimal vlrTotalGanhoDia) {
		this.vlrTotalGanhoDia = vlrTotalGanhoDia;
	}

	public BigDecimal getVlrTotalPerdidoDia() {
		return vlrTotalPerdidoDia;
	}

	public void setVlrTotalPerdidoDia(BigDecimal vlrTotalPerdidoDia) {
		this.vlrTotalPerdidoDia = vlrTotalPerdidoDia;
	}

	public PlanoJogoEntity getPlanoJogo() {
		return planoJogo;
	}

	public void setPlanoJogo(PlanoJogoEntity planoJogo) {
		this.planoJogo = planoJogo;
	}

	public List<ApostaEntity> getApostas() {
		return apostas;
	}

	public void setApostas(List<ApostaEntity> apostas) {
		this.apostas = apostas;
	}

	public BigDecimal getVlrBetDiaObjetivo() {
		return vlrBetDiaObjetivo;
	}

	public void setVlrBetDiaObjetivo(BigDecimal vlrBetDiaObjetivo) {
		this.vlrBetDiaObjetivo = vlrBetDiaObjetivo;
	}

	public BigDecimal getVlrInicialDiaObjetivo() {
		return vlrInicialDiaObjetivo;
	}

	public void setVlrInicialDiaObjetivo(BigDecimal vlrInicialDiaObjetivo) {
		this.vlrInicialDiaObjetivo = vlrInicialDiaObjetivo;
	}

	public BigDecimal getVlrFinalDiaObjetivo() {
		return vlrFinalDiaObjetivo;
	}

	public void setVlrFinalDiaObjetivo(BigDecimal vlrFinalDiaObjetivo) {
		this.vlrFinalDiaObjetivo = vlrFinalDiaObjetivo;
	}

	public BigDecimal getVlrLucroDiaObjetivo() {
		return vlrLucroDiaObjetivo;
	}

	public void setVlrLucroDiaObjetivo(BigDecimal vlrLucroDiaObjetivo) {
		this.vlrLucroDiaObjetivo = vlrLucroDiaObjetivo;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
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
		PlanoJogoItemEntity other = (PlanoJogoItemEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Transient
	public String getDescStatus(){
		return finalizado?"Concluido":"Em Aberto";
	}
	
	
}
