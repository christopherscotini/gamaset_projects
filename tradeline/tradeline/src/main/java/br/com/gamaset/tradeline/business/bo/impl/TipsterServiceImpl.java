package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.TipsterService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.TipsterEntity;
import br.com.gamaset.tradeline.repository.TipsterRepository;

@Stateless
public class TipsterServiceImpl implements TipsterService{

	@Inject
	private TipsterRepository repo = null;
	
	
	public List<TipsterEntity> listarTodos() {
		return repo.findAll();
	}

	
	public TipsterEntity adicionarEntidade(TipsterEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public TipsterEntity editarEntidade(TipsterEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(TipsterEntity entidade) {
		repo.delete(entidade);
	}

	
	public void validateForm(TipsterEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getDescricao());
		}
	}

	
}
