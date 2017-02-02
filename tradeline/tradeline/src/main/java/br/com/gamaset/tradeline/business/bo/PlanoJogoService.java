package br.com.gamaset.tradeline.business.bo;

import java.util.List;

import br.com.gamaset.tradeline.business.ServiceModel;
import br.com.gamaset.tradeline.dto.PlanoJogoDetalheDTO;
import br.com.gamaset.tradeline.model.PlanoJogoEntity;

public interface PlanoJogoService extends ServiceModel<PlanoJogoEntity>{

	PlanoJogoDetalheDTO detalharPlanoJogo(PlanoJogoEntity planoJogoCadastrar);
	
	List<PlanoJogoEntity> listarTodosAtivos();
}
