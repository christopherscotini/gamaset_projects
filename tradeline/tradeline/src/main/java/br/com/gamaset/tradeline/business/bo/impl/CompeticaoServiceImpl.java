package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.CompeticaoService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.repository.CompeticaoRepository;

@Stateless
public class CompeticaoServiceImpl implements CompeticaoService{

	@Inject
	private CompeticaoRepository repo = null;
	
	
	public List<CompeticaoEntity> listarTodos() {
		return repo.findAll();
	}

	
	public CompeticaoEntity adicionarEntidade(CompeticaoEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public CompeticaoEntity editarEntidade(CompeticaoEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(CompeticaoEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<CompeticaoEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public void validateForm(CompeticaoEntity entidade) throws ValidationFormAbstractException {

	}

	
	
}
