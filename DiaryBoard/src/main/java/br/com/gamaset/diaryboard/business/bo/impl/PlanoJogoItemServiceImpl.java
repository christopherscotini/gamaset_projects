package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.PlanoJogoItemService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.repository.PlanoJogoItemRepository;

@Stateless
public class PlanoJogoItemServiceImpl implements PlanoJogoItemService{

	@Inject
	private PlanoJogoItemRepository repo = null;

	@Override
	public List<PlanoJogoItemEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public PlanoJogoItemEntity adicionarEntidade(PlanoJogoItemEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public PlanoJogoItemEntity editarEntidade(PlanoJogoItemEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(PlanoJogoItemEntity entidade) {
		
	}
	
	@Override
	public PlanoJogoItemEntity busarPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void validateForm(PlanoJogoItemEntity entidade) throws ValidationFormAbstractException {
		
		
	}
	
	@Override
	public List<PlanoJogoItemEntity> buscarPorPlanoJogoId(Long id) {
		
		return repo.findByPlanoJogoId(id);
	}

}
