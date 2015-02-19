package br.com.gamaset.diaryboard.business.bo;

import br.com.gamaset.diaryboard.business.ServiceModel;
import br.com.gamaset.diaryboard.dto.PlanoJogoDetalheDTO;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;

public interface PlanoJogoService extends ServiceModel<PlanoJogoEntity>{

	PlanoJogoDetalheDTO detalharPlanoJogo(PlanoJogoEntity planoJogoCadastrar);
	

}
