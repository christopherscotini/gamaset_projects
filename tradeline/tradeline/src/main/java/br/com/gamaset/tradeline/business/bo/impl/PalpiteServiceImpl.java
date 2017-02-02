package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.PalpiteService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.ApostaResultadoEnum;
import br.com.gamaset.tradeline.model.PalpiteEntity;
import br.com.gamaset.tradeline.repository.PalpiteRepository;

@Stateless
public class PalpiteServiceImpl implements PalpiteService{

	@Inject
	private PalpiteRepository repo = null;
	
	
	public List<PalpiteEntity> listarTodos() {
		return repo.findAll();
	}

	public List<PalpiteEntity> buscarPorApostaResultado(ApostaResultadoEnum apostaResultadoFiltro) {
		if(apostaResultadoFiltro.equals(ApostaResultadoEnum.TODOS)){
			return listarTodos();
		}else{
			return repo.findByApostaResultado(apostaResultadoFiltro);
		}
	}
	
	public PalpiteEntity adicionarEntidade(PalpiteEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public PalpiteEntity editarEntidade(PalpiteEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(PalpiteEntity entidade) {
		repo.delete(entidade);
	}

	
	public void validateForm(PalpiteEntity entidade) throws ValidationFormAbstractException {
	
	}

	
	
}
