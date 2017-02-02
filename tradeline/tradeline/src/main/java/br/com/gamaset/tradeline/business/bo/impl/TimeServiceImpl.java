package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.TimeService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.repository.TimeRepository;

@Stateless
public class TimeServiceImpl implements TimeService{

	@Inject
	private TimeRepository repo = null;
	
	
	public List<TimeEntity> listarTodos() {
		return repo.findAll();
	}

	
	public TimeEntity adicionarEntidade(TimeEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public TimeEntity editarEntidade(TimeEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(TimeEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<TimeEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public void validateForm(TimeEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getDescricao());
		}
	}

	
	public List<TimeEntity> listarTodosVincular(PaisEntity pais) {
		
		return repo.listarTodosVincular(pais);
	}
	
	
}
