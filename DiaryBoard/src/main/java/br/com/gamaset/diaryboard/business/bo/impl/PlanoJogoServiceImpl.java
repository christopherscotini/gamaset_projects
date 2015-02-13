package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.PlanoJogoService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.repository.PlanoJogoRepository;

@Stateless
public class PlanoJogoServiceImpl implements PlanoJogoService{

	@Inject
	private PlanoJogoRepository repo = null;

	@Override
	public List<PlanoJogoEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public PlanoJogoEntity adicionarEntidade(PlanoJogoEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public PlanoJogoEntity editarEntidade(PlanoJogoEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(PlanoJogoEntity entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateForm(PlanoJogoEntity entidade)
			throws ValidationFormAbstractException {
		
		if(entidade.getId() == null && entidade.getDataCriacao() == null){
			entidade.setDataCriacao(new Date());
		}
		
	}
	

}
