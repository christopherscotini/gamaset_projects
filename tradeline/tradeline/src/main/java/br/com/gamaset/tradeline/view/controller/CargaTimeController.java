package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.utils.AsMelhoresApostasUtils;
import br.com.gamaset.tradeline.utils.GoalUtils;


@ManagedBean
@SessionScoped
public class CargaTimeController extends AbstractController{

	private final String TELA_CARGA_TIME = PATH_PAGES+"/cargatime/cargatime-list.xhtml";
	
	private String competicaoInput;
	private List<PaisEntity> paisList;
	private List<TimeEntity> timeList;
	private PaisEntity paisSelecionado;
	
	
	@Override
	public String iniciarTela() {
		timeList = null;
		competicaoInput = null;
		
		paisList = paisService.listarTodos();
		setPaisSelecionado(paisList.get(0));
		
		
		return TELA_CARGA_TIME;
	}
	
	public void lerTimesAsMelhoresApostasCalendario(){
		timeList = AsMelhoresApostasUtils.lerTimesCalendario(competicaoInput);
		for (int i = 0; i < timeList.size(); i++) {
			TimeEntity t = timeList.get(i);
			try{
				t.setPais(paisSelecionado);
				timeService.adicionarEntidade(t);
			}catch(BusinessException b){
				System.err.println(b.getMessage());
			}
		}
	}
	
	public void lerTimesAsMelhoresApostas(){
		timeList = AsMelhoresApostasUtils.lerTimes(competicaoInput);
		for (int i = 0; i < timeList.size(); i++) {
			try{
				TimeEntity t = new TimeEntity();
				t = timeList.get(i);
				t.setPais(paisSelecionado);
				timeService.adicionarEntidade(t);
			}catch(BusinessException b){
				System.err.println(b.getMessage());
			}
		}
	}

	public void lerTimesGoal(){
		timeList = GoalUtils.lerTimes(competicaoInput, false);
		for (int i = 0; i < timeList.size(); i++) {
			try{
				timeGoalService.adicionarEntidade(new TimeGoalEntity(null, timeList.get(i).getDescricao(), paisSelecionado, null));
			}catch(BusinessException b){
				System.err.println(b.getMessage());
			}
		}
	}
	
	public void lerTimesGoalParaSistema(){
		timeList = GoalUtils.lerTimes(competicaoInput, true);
		for (int i = 0; i < timeList.size(); i++) {
			try{
				TimeEntity t = new TimeEntity();
				t = timeList.get(i);
				t.setPais(paisSelecionado);
				timeService.adicionarEntidade(t);
			}catch(BusinessException b){
				System.err.println(b.getMessage());
			}
		}
	}
	
	public String lerCampeonatoAsmelhoresApostas(){
		
		CompeticaoEntity competicaoCadastrar = AsMelhoresApostasUtils.lerCompeticao(competicaoInput);
		
		try{
			competicaoCadastrar.setPais(paisSelecionado);
			competicaoService.adicionarEntidade(competicaoCadastrar);
		}catch(BusinessException b){
			System.err.println(b.getMessage());
		}
		
		return "";
	}
	


	public List<TimeEntity> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<TimeEntity> timeList) {
		this.timeList = timeList;
	}

	public String getCompeticaoInput() {
		return competicaoInput;
	}

	public void setCompeticaoInput(String competicaoInput) {
		this.competicaoInput = competicaoInput;
	}

	public PaisEntity getPaisSelecionado() {
		return paisSelecionado;
	}

	public void setPaisSelecionado(PaisEntity paisSelecionado) {
		this.paisSelecionado = paisSelecionado;
	}

	public List<PaisEntity> getPaisList() {
		return paisList;
	}

	public void setPaisList(List<PaisEntity> paisList) {
		this.paisList = paisList;
	}
	
}
