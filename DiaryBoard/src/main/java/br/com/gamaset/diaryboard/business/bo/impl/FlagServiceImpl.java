package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.FlagService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.FlagEntity;
import br.com.gamaset.diaryboard.repository.FlagRepository;

@Stateless
public class FlagServiceImpl implements FlagService{

	@Inject
	private FlagRepository repo = null;

	@Override
	public List<FlagEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public FlagEntity adicionarEntidade(FlagEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public FlagEntity editarEntidade(FlagEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(FlagEntity entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateForm(FlagEntity entidade)
			throws ValidationFormAbstractException {
		
	}
	

}
