package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.ApostaService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.repository.ApostaRepository;

@Stateless
public class ApostaServiceImpl implements ApostaService{

	@Inject
	private ApostaRepository repo = null;
	
	@Override
	public List<ApostaEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public ApostaEntity adicionarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public ApostaEntity editarEntidade(ApostaEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(ApostaEntity entidade) {
		repo.delete(entidade);
	}

	@Override
	public void validateForm(ApostaEntity entidade) throws ValidationFormAbstractException {
		entidade.getBet().getEvento().setDescTimeCasa(entidade.getBet().getEvento().getDescTimeCasa().toUpperCase());
		entidade.getBet().getEvento().setDescTimeVisitante(entidade.getBet().getEvento().getDescTimeVisitante().toUpperCase());
		
		
	}

}
