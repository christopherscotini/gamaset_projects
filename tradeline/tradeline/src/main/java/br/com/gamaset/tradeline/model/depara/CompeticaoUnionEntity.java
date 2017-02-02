package br.com.gamaset.tradeline.model.depara;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gamaset.tradeline.model.AbstractEntity;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;

@Entity
@Table(name = "COMPETICAO_UNION")
public class CompeticaoUnionEntity extends AbstractEntity{

	private static final long serialVersionUID = -1666398875153483168L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COUN_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COMP_CD_ID_FK")
	private CompeticaoEntity competicaoSistema;

	@ManyToOne
	@JoinColumn(name = "COGO_CD_ID_FK")
	private CompeticaoGoalEntity competicaoGoal;

	@ManyToOne
	@JoinColumn(name = "COPR_CD_ID_FK")
	private CompeticaoPSEntity competicaoProsoccer;
	
	@ManyToOne
	@JoinColumn(name = "PAIS_CD_ID_FK")
	private PaisEntity pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompeticaoEntity getCompeticaoSistema() {
		return competicaoSistema;
	}

	public void setCompeticaoSistema(CompeticaoEntity competicaoSistema) {
		this.competicaoSistema = competicaoSistema;
	}

	public CompeticaoGoalEntity getCompeticaoGoal() {
		return competicaoGoal;
	}

	public void setCompeticaoGoal(CompeticaoGoalEntity competicaoGoal) {
		this.competicaoGoal = competicaoGoal;
	}

	public CompeticaoPSEntity getCompeticaoProsoccer() {
		return competicaoProsoccer;
	}

	public void setCompeticaoProsoccer(CompeticaoPSEntity competicaoProsoccer) {
		this.competicaoProsoccer = competicaoProsoccer;
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "[id="+id+",pais="+pais.getDescricao()+"]";
	}
	
}
