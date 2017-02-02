package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.PaisService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.repository.PaisRepository;

@Stateless
public class PaisServiceImpl implements PaisService{

	@Inject
	private PaisRepository repo = null;
	
	
	public List<PaisEntity> listarTodos() {
		return repo.findAll();
	}

	
	public PaisEntity buscarPorId(Long id) {
		return repo.findById(id);
	}
	
	
	public List<PaisEntity> listarTodosComCompeticaoAssociada() {
		return repo.listarTodosComCompeticao();
	}
	
	
	public PaisEntity adicionarEntidade(PaisEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public PaisEntity editarEntidade(PaisEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(PaisEntity entidade) {
		repo.delete(entidade);
	}

	
	public PaisEntity buscarPorGoalId(Long idGoal) {
		return repo.buscarPorGoalId(idGoal);
	}
	
	
	public void validateForm(PaisEntity entidade) throws ValidationFormAbstractException {
	
	}

	
	
}
