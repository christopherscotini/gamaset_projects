package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.PlanoJogoItemService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;
import br.com.gamaset.tradeline.repository.PlanoJogoItemRepository;

@Stateless
public class PlanoJogoItemServiceImpl implements PlanoJogoItemService{

	@Inject
	private PlanoJogoItemRepository repo = null;

	
	public List<PlanoJogoItemEntity> listarTodos() {
		return repo.findAll();
	}

	
	public PlanoJogoItemEntity adicionarEntidade(PlanoJogoItemEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public PlanoJogoItemEntity editarEntidade(PlanoJogoItemEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(PlanoJogoItemEntity entidade) {
		
	}
	
	
	public PlanoJogoItemEntity busarPorId(Long id) {
		return repo.findById(id);
	}

	
	public void validateForm(PlanoJogoItemEntity entidade) throws ValidationFormAbstractException {
		
		
	}
	
	
	public List<PlanoJogoItemEntity> buscarPorPlanoJogoId(Long id) {
		
		return repo.findByPlanoJogoId(id);
	}

}
