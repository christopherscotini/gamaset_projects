package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.dto.jogosdia.JogoDiaDTO;
import br.com.gamaset.tradeline.dto.jogosdia.JogosDiaDTO;
import br.com.gamaset.tradeline.dto.prosoccer.JogoProsoccerDTO;

public interface JogosDiaService {

	JogosDiaDTO lerJogosDiaGoal();
	List<JogoProsoccerDTO> lerJogosDiaProsoccer();
	
}
