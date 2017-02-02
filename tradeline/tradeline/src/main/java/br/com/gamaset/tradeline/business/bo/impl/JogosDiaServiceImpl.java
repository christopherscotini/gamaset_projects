package br.com.gamaset.tradeline.business.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.CompeticaoUnionService;
import br.com.gamaset.tradeline.business.bo.JogosDiaService;
import br.com.gamaset.tradeline.business.bo.PaisService;
import br.com.gamaset.tradeline.business.bo.TimeUnionService;
import br.com.gamaset.tradeline.business.bo.goal.CompeticaoGoalService;
import br.com.gamaset.tradeline.business.bo.goal.TimeGoalService;
import br.com.gamaset.tradeline.business.bo.prosoccer.CompeticaoPSService;
import br.com.gamaset.tradeline.dto.jogosdia.JogoDiaDTO;
import br.com.gamaset.tradeline.dto.jogosdia.JogosDiaDTO;
import br.com.gamaset.tradeline.dto.prosoccer.JogoProsoccerDTO;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.PaisRepository;
import br.com.gamaset.tradeline.utils.GoalUtils;
import br.com.gamaset.tradeline.utils.ProsoccerUtils;

@Stateless
public class JogosDiaServiceImpl implements JogosDiaService{

	@Inject
	private PaisService paisService = null;
	@Inject
	private CompeticaoGoalService competicaoGoalService = null;
	@Inject
	private CompeticaoPSService competicaoProsoccerService = null;
	@Inject
	private CompeticaoUnionService competicaoUnionService = null;
	@Inject
	private TimeGoalService timeGoalService = null;
	@Inject
	private TimeUnionService timeUnionService = null;
	@Inject
	private PaisRepository repo = null;

	
	public JogosDiaDTO lerJogosDiaGoal() {
		JogosDiaDTO returnzz = GoalUtils.lerJogosDia();
		List<JogoDiaDTO> jogos = new ArrayList<JogoDiaDTO>();
		for (int i = 0; i < returnzz.getJogos().size(); i++) {
			JogoDiaDTO jogoDia = returnzz.getJogos().get(i);
			
			if(jogoDia.getCompeticao().getCompeticaoGoal().getPais() == null){
				continue;
			}else{
				jogoDia.getCompeticao().setPais(paisService.buscarPorGoalId(jogoDia.getCompeticao().getCompeticaoGoal().getPais().getIdGoal()));
				jogoDia.getCompeticao().getCompeticaoGoal().setPais(jogoDia.getCompeticao().getPais());
				jogoDia.setCompeticao(competicaoUnionService.buscarPorIdCompeticaoGoal(jogoDia.getCompeticao().getCompeticaoGoal()));
				if(jogoDia.getCompeticao() != null){
					if(jogoDia.getCompeticao().getId() != null){
						jogoDia.setTimeCasa(timeUnionService.buscarPorDescricaoGoalAndPais(jogoDia.getTimeCasa().getTimeGoal().getDescricao(), jogoDia.getCompeticao().getPais()));
						jogoDia.setTimeVisitante(timeUnionService.buscarPorDescricaoGoalAndPais(jogoDia.getTimeVisitante().getTimeGoal().getDescricao(), jogoDia.getCompeticao().getPais()));
						if(jogoDia.getTimeCasa() != null && jogoDia.getTimeVisitante() != null){
							jogos.add(jogoDia);
						}
					}
				}
			}
		}
		
		lerJogosDiaProsoccer();
		
		returnzz.setJogos(jogos);
		
		return returnzz;
	}
	
	
	public List<JogoProsoccerDTO> lerJogosDiaProsoccer() {
		List<JogoProsoccerDTO> returnzz = new ArrayList<JogoProsoccerDTO>();
		List<JogoProsoccerDTO> aux = new ArrayList<JogoProsoccerDTO>();
		aux = ProsoccerUtils.lerJogosDia();
		for (int i = 0; i < aux.size(); i++) {
			CompeticaoPSEntity comp = competicaoProsoccerService.buscarPorCodCompeticao(aux.get(i).getCompeticao().getCompeticaoProsoccer().getCodigoDescricao());
			if(comp != null){
				aux.get(i).setCompeticao(competicaoUnionService.buscarPorIdCompeticaoProsoccer(comp));
				if(aux.get(i).getCompeticao() != null){
					aux.get(i).setTimeCasa(timeUnionService.buscarPorDescricaoProSoccerAndPais(aux.get(i).getTimeCasa().getTimeProsoccer().getDescricao(), aux.get(i).getCompeticao().getPais()));
					aux.get(i).setTimeVisitante(timeUnionService.buscarPorDescricaoProSoccerAndPais(aux.get(i).getTimeVisitante().getTimeProsoccer().getDescricao(), aux.get(i).getCompeticao().getPais()));
					if(aux.get(i).getTimeCasa() != null && aux.get(i).getTimeVisitante() != null){
						returnzz.add(aux.get(i));
					}
				}
			}
			
		}
		
		return returnzz;
	}
	
}
