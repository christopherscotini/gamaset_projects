package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.CaixaApostasService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.CaixaApostasEntity;
import br.com.gamaset.diaryboard.repository.CaixaApostaRepository;

@Stateless
public class CaixaApostasServiceImpl implements CaixaApostasService{

	@Inject
	private CaixaApostaRepository repo = null;

	@Override
	public List<CaixaApostasEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public CaixaApostasEntity adicionarEntidade(CaixaApostasEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	@Override
	public CaixaApostasEntity editarEntidade(CaixaApostasEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(CaixaApostasEntity entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateForm(CaixaApostasEntity entidade)
			throws ValidationFormAbstractException {
		
	}
	

}
