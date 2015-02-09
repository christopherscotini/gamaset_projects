package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.MercadoApostaService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.MercadoApostaEntity;
import br.com.gamaset.diaryboard.repository.MercadoApostaRepository;

@Stateless
public class MercadoApostaServiceImpl implements MercadoApostaService{

	@Inject
	private MercadoApostaRepository repo = null;
	
	@Override
	public List<MercadoApostaEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public MercadoApostaEntity adicionarEntidade(MercadoApostaEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public MercadoApostaEntity editarEntidade(MercadoApostaEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(MercadoApostaEntity entidade) {
		repo.delete(entidade);
	}

	@Override
	public void validateForm(MercadoApostaEntity entidade) throws ValidationFormAbstractException {
		
	}

}
