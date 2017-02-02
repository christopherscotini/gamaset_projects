package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.MercadoApostaSelecaoService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.repository.MercadoApostaSelecaoRepository;

@Stateless
public class MercadoApostaSelecaoServiceImpl implements MercadoApostaSelecaoService{

	@Inject
	private MercadoApostaSelecaoRepository repo = null;
	
	
	public List<MercadoApostaSelecaoEntity> listarTodos() {
		return repo.findAll();
	}

	
	public MercadoApostaSelecaoEntity adicionarEntidade(MercadoApostaSelecaoEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public MercadoApostaSelecaoEntity editarEntidade(MercadoApostaSelecaoEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(MercadoApostaSelecaoEntity entidade) {
		repo.delete(entidade);
	}

	
	public void validateForm(MercadoApostaSelecaoEntity entidade) throws ValidationFormAbstractException {
		
	}

}
