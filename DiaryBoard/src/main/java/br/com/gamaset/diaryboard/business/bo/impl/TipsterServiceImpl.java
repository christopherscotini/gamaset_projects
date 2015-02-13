package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.TipsterService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.TipsterEntity;
import br.com.gamaset.diaryboard.repository.TipsterRepository;

@Stateless
public class TipsterServiceImpl implements TipsterService{

	@Inject
	private TipsterRepository repo = null;

	@Override
	public List<TipsterEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public TipsterEntity adicionarEntidade(TipsterEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public TipsterEntity editarEntidade(TipsterEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(TipsterEntity entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateForm(TipsterEntity entidade)
			throws ValidationFormAbstractException {
		
	}
	

}
