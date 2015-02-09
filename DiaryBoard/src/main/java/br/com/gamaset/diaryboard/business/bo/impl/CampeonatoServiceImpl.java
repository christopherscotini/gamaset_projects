package br.com.gamaset.diaryboard.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.CampeonatoService;
import br.com.gamaset.diaryboard.business.exception.ValidationFormAbstractException;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.repository.CampeonatoRepository;

@Stateless
public class CampeonatoServiceImpl implements CampeonatoService{

	@Inject
	private CampeonatoRepository repo = null;
	
	@Override
	public List<CampeonatoEntity> listarTodos() {
		return repo.findAll();
	}

	@Override
	public CampeonatoEntity adicionarEntidade(CampeonatoEntity entidade) {
		validateForm(entidade);
		entidade.setSigla(entidade.getSigla().toUpperCase());
		return repo.insert(entidade);
	}

	@Override
	public CampeonatoEntity editarEntidade(CampeonatoEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	@Override
	public void excluirEntidade(CampeonatoEntity entidade) {
		repo.delete(entidade);
	}

	@Override
	public void validateForm(CampeonatoEntity entidade) throws ValidationFormAbstractException {
		
	}

}
