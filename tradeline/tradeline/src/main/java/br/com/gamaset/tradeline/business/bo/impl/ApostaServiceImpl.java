package br.com.gamaset.tradeline.business.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.ApostaService;
import br.com.gamaset.tradeline.business.exception.GenericErrorException;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.ApostaEntity;
import br.com.gamaset.tradeline.repository.ApostaRepository;
import br.com.gamaset.tradeline.repository.PlanoJogoItemRepository;
import br.com.gamaset.tradeline.utils.ProjectUtils;
import br.com.gamaset.tradeline.utils.StringUtils;

@Stateless
public class ApostaServiceImpl implements ApostaService{

	@Inject
	private ApostaRepository repo = null;
	@Inject
	private PlanoJogoItemRepository repoPlanoJogoItem = null;

	
	public List<ApostaEntity> listarTodos() {
		return repo.findAll();
	}

	
	public ApostaEntity adicionarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		//colocar as validações
		try{
			entidade = repo.insert(entidade);
			repoPlanoJogoItem.atualizarPlanoJogoAcompanhamento(entidade, false);
		}catch(Exception e){
			throw new GenericErrorException(e.getMessage());
		}
		
		return entidade;
	}

	
	public ApostaEntity editarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		//colocar as validações
		try{
			repoPlanoJogoItem.atualizarPlanoJogoAcompanhamento(entidade, true);
		}catch (Exception e) {
		
		}
		
		return entidade;
	}
	
	
	public void excluirEntidade(ApostaEntity entidade) {
		repo.delete(entidade);
		repoPlanoJogoItem.atualizarPlanoJogoAcompanhamento(entidade, false);
	}

	
	public void validateForm(ApostaEntity entidade) throws ValidationFormAbstractException {
		entidade.setTicket(StringUtils.trim(entidade.getTicket()));
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException("ticket: "+entidade.getTicket());
		}
	
//		entidade.getBet().getEvento().setOdd(entidade.getBet().getEvento().getOdd()==null?0.0:entidade.getBet().getEvento().getOdd());
		entidade.setValorAposta(entidade.getValorAposta()==null?BigDecimal.ZERO:entidade.getValorAposta());
		entidade.setValorRetorno(entidade.getValorRetorno()==null?BigDecimal.ZERO:entidade.getValorRetorno());
	
	
	}

}
