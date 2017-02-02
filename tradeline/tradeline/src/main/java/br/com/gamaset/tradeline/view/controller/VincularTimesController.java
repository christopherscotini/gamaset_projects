package br.com.gamaset.tradeline.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;
import br.com.gamaset.tradeline.utils.GoalUtils;
import br.com.gamaset.tradeline.utils.ProsoccerUtils;


@ManagedBean
@SessionScoped
public class VincularTimesController extends AbstractController{


	private final String TELA_VINCULAR_TIME = PATH_PAGES+"/vinculartimes-list.xhtml";
	
	private List<PaisEntity> paisList;
	private PaisEntity paisSelecionado;
	
	private List<TimeEntity>timesListSistema;
	private TimeEntity timeSistemaSelecionado;
	private List<TimePSEntity>timesListProsoccer;
	private TimePSEntity timesProsoccerSelecionado;
	private List<TimeGoalEntity>timesListGoal;
	private TimeGoalEntity timesGoalSelecionado;
	
	
	
	@Override
	public String iniciarTela() {
		
		paisList = paisService.listarTodos();
		setPaisSelecionado(paisList.get(0));
		
		timesListSistema = null;
		timeSistemaSelecionado = null;
		timesListGoal = null;
		timesGoalSelecionado = null;
		timesListProsoccer = null;
		timesProsoccerSelecionado = null;
		
		return TELA_VINCULAR_TIME;
	}
	
	public String filtrar(){
		timesListSistema = timeService.listarTodosVincular(paisSelecionado);
		timeSistemaSelecionado = null;
		timesListGoal = timeGoalService.listarTodosVincular(paisSelecionado);
		timesGoalSelecionado = null;
		timesListProsoccer = timePSService.listarTodosVincular(paisSelecionado);
		timesProsoccerSelecionado = null;
		
		return "";
	}


	public String salvar(){
		
		try{
			
			if(timeSistemaSelecionado != null && timesGoalSelecionado != null && timesProsoccerSelecionado != null && paisSelecionado != null){
				TimeUnionEntity t = new TimeUnionEntity(null, timeSistemaSelecionado, timesGoalSelecionado, timesProsoccerSelecionado, paisSelecionado);
				timeUnionService.adicionarEntidade(t);
			}
			
		}catch(BusinessException b){
			System.out.println(">> "+b.getMessage());;
		}
		
		paisList = paisService.listarTodos();
		timesListSistema = timeService.listarTodosVincular(paisSelecionado);
		timeSistemaSelecionado = null;
		timesListGoal = timeGoalService.listarTodosVincular(paisSelecionado);
		timesGoalSelecionado = null;
		timesListProsoccer = timePSService.listarTodosVincular(paisSelecionado);
		timesProsoccerSelecionado = null;
		
		return TELA_VINCULAR_TIME;
	}
	
	public List<PaisEntity> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisEntity> paisList) {
		this.paisList = paisList;
	}

	public PaisEntity getPaisSelecionado() {
		return paisSelecionado;
	}

	public void setPaisSelecionado(PaisEntity paisSelecionado) {
		this.paisSelecionado = paisSelecionado;
	}


	public List<TimeEntity> getTimesListSistema() {
		return timesListSistema;
	}


	public void setTimesListSistema(List<TimeEntity> timesListSistema) {
		this.timesListSistema = timesListSistema;
	}


	public TimeEntity getTimeSistemaSelecionado() {
		return timeSistemaSelecionado;
	}


	public void setTimeSistemaSelecionado(TimeEntity timeSistemaSelecionado) {
		this.timeSistemaSelecionado = timeSistemaSelecionado;
	}


	public List<TimePSEntity> getTimesListProsoccer() {
		return timesListProsoccer;
	}


	public void setTimesListProsoccer(List<TimePSEntity> timesListProsoccer) {
		this.timesListProsoccer = timesListProsoccer;
	}


	public TimePSEntity getTimesProsoccerSelecionado() {
		return timesProsoccerSelecionado;
	}


	public void setTimesProsoccerSelecionado(TimePSEntity timesProsoccerSelecionado) {
		this.timesProsoccerSelecionado = timesProsoccerSelecionado;
	}


	public List<TimeGoalEntity> getTimesListGoal() {
		return timesListGoal;
	}


	public void setTimesListGoal(List<TimeGoalEntity> timesListGoal) {
		this.timesListGoal = timesListGoal;
	}


	public TimeGoalEntity getTimesGoalSelecionado() {
		return timesGoalSelecionado;
	}


	public void setTimesGoalSelecionado(TimeGoalEntity timesGoalSelecionado) {
		this.timesGoalSelecionado = timesGoalSelecionado;
	}


	
}
