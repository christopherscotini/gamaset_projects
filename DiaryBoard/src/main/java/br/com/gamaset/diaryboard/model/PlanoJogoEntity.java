package br.com.gamaset.diaryboard.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PLANO_JOGO")
public class PlanoJogoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PLJO_CD_ID_PK")
	private Long id;
	
	@Column(name = "PLJO_DS_DESCRICAO")
	private String descricao;

	@Column(name = "PLJO_VL_INVESTIMENTO_INICIAL")
	private BigDecimal valorInvestimentoInicial;
	
	@Column(name = "PLJO_NM_DIAS_PLANO")
	private Integer numDiasPlano;
	
	@Column(name = "PLJO_PC_LUCRO_DIA")
	private BigDecimal percentualLucroMontanteDia;

	@Column(name = "PLJO_PC_APOSTA_DIA")
	private BigDecimal percentualApostaMontanteDia;

	@Column(name = "PLJO_DT_CRIACAO")
	private Date dataCriacao;

	@Column(name = "PLJO_FL_ATIVO")
	private boolean ativo;

	@OneToMany(mappedBy = "planoJogo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PlanoJogoItemEntity>apostas;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorInvestimentoInicial() {
		return valorInvestimentoInicial;
	}

	public void setValorInvestimentoInicial(BigDecimal valorInvestimentoInicial) {
		this.valorInvestimentoInicial = valorInvestimentoInicial;
	}

	public Integer getNumDiasPlano() {
		return numDiasPlano;
	}

	public void setNumDiasPlano(Integer numDiasPlano) {
		this.numDiasPlano = numDiasPlano;
	}

	public BigDecimal getPercentualLucroMontanteDia() {
		return percentualLucroMontanteDia;
	}

	public void setPercentualLucroMontanteDia(BigDecimal percentualLucroMontanteDia) {
		this.percentualLucroMontanteDia = percentualLucroMontanteDia;
	}

	public BigDecimal getPercentualApostaMontanteDia() {
		return percentualApostaMontanteDia;
	}

	public void setPercentualApostaMontanteDia(
			BigDecimal percentualApostaMontanteDia) {
		this.percentualApostaMontanteDia = percentualApostaMontanteDia;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PlanoJogoItemEntity> getApostas() {
		return apostas;
	}

	public void setApostas(List<PlanoJogoItemEntity> apostas) {
		this.apostas = apostas;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
		PlanoJogoEntity other = (PlanoJogoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Transient
	private BigDecimal montanteAtual;
	public BigDecimal getMontanteAtual(){
		return montanteAtual;
	}
	public void setMontanteAtual(BigDecimal val){
		this.montanteAtual = val;
	}
	
}
