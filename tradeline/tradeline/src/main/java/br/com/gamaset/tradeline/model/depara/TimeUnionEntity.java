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
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;

@Entity
@Table(name = "TIME_UNION")
public class TimeUnionEntity extends AbstractEntity{

	private static final long serialVersionUID = -1666398875153483168L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TIUN_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "TIME_CD_ID_FK")
	private TimeEntity timeSistema;

	@ManyToOne
	@JoinColumn(name = "TIGO_CD_ID_FK")
	private TimeGoalEntity timeGoal;

	@ManyToOne
	@JoinColumn(name = "TIPR_CD_ID_FK")
	private TimePSEntity timeProsoccer;
	
	@ManyToOne
	@JoinColumn(name = "PAIS_CD_ID_FK")
	private PaisEntity pais;

	public TimeUnionEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public TimeUnionEntity(Long id, TimeEntity timeSistema,
			TimeGoalEntity timeGoal, TimePSEntity timeProsoccer, PaisEntity pais) {
		super();
		this.id = id;
		this.timeSistema = timeSistema;
		this.timeGoal = timeGoal;
		this.timeProsoccer = timeProsoccer;
		this.pais = pais;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TimeEntity getTimeSistema() {
		return timeSistema;
	}

	public void setTimeSistema(TimeEntity timeSistema) {
		this.timeSistema = timeSistema;
	}

	public TimeGoalEntity getTimeGoal() {
		return timeGoal;
	}

	public void setTimeGoal(TimeGoalEntity timeGoal) {
		this.timeGoal = timeGoal;
	}

	public TimePSEntity getTimeProsoccer() {
		return timeProsoccer;
	}

	public void setTimeProsoccer(TimePSEntity timeProsoccer) {
		this.timeProsoccer = timeProsoccer;
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}
	
}
