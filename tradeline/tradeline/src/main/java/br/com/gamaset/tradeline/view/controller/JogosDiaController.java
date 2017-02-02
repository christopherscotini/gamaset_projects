package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.dto.jogosdia.JogoDiaDTO;
import br.com.gamaset.tradeline.dto.jogosdia.JogosDiaDTO;
import br.com.gamaset.tradeline.dto.prosoccer.JogoProsoccerDTO;
import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.utils.GoalUtils;
import br.com.gamaset.tradeline.utils.TradelineUtils;

@ManagedBean
@SessionScoped
public class JogosDiaController extends AbstractController{

	private final String TELA_JOGOSDIA_LIST = PATH_PAGES+"/jogosdia/jogosdia-list.xhtml";
	
	private JogosDiaDTO jogosDia;
	private List<JogoProsoccerDTO>jogosProsoccer;
	
	private List<TimeEntity>timeSys;
	private List<TimeGoalEntity>timeGoal;
	private List<CompeticaoEntity>competicaoSys;
	private List<CompeticaoGoalEntity>competicaoGoal;
	
	public JogosDiaController() {
		
	}
	
	@Override
	public String iniciarTela() {
		
		jogosDia = jogosDiaService.lerJogosDiaGoal();
		jogosProsoccer = jogosDiaService.lerJogosDiaProsoccer();
		
		for (int i = 0; i < jogosDia.getJogos().size(); i++) {
			JogoDiaDTO jogoGoal = jogosDia.getJogos().get(i);
			for (int j = 0; j < jogosProsoccer.size(); j++) {
				JogoProsoccerDTO jogoPS = jogosProsoccer.get(j);
				if(jogoGoal.getTimeCasa().equals(jogoPS.getTimeCasa()) && jogoGoal.getTimeVisitante().equals(jogoPS.getTimeVisitante())){
					jogosDia.getJogos().get(i).setJogoProsoccer(jogoPS);
				}
			}
		}
		
		return TELA_JOGOSDIA_LIST;
	}

	
	
	public JogosDiaDTO getJogosDia() {
		return jogosDia;
	}

	public void setJogosDia(JogosDiaDTO jogosDia) {
		this.jogosDia = jogosDia;
	}

	public List<TimeEntity> getTimeSys() {
		return timeSys;
	}

	public void setTimeSys(List<TimeEntity> timeSys) {
		this.timeSys = timeSys;
	}

	public List<TimeGoalEntity> getTimeGoal() {
		return timeGoal;
	}

	public void setTimeGoal(List<TimeGoalEntity> timeGoal) {
		this.timeGoal = timeGoal;
	}

	public List<CompeticaoEntity> getCompeticaoSys() {
		return competicaoSys;
	}

	public void setCompeticaoSys(List<CompeticaoEntity> competicaoSys) {
		this.competicaoSys = competicaoSys;
	}

	public List<CompeticaoGoalEntity> getCompeticaoGoal() {
		return competicaoGoal;
	}

	public void setCompeticaoGoal(List<CompeticaoGoalEntity> competicaoGoal) {
		this.competicaoGoal = competicaoGoal;
	}

	public List<JogoProsoccerDTO> getJogosProsoccer() {
		return jogosProsoccer;
	}

	public void setJogosProsoccer(List<JogoProsoccerDTO> jogosProsoccer) {
		this.jogosProsoccer = jogosProsoccer;
	}

	
}
