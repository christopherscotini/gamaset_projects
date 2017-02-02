package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.MercadoApostaService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.repository.MercadoApostaRepository;

@Stateless
public class MercadoApostaServiceImpl implements MercadoApostaService{

	@Inject
	private MercadoApostaRepository repo = null;
	
	
	public List<MercadoApostaEntity> listarTodos() {
		return repo.findAll();
	}

	
	public MercadoApostaEntity adicionarEntidade(MercadoApostaEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public MercadoApostaEntity editarEntidade(MercadoApostaEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(MercadoApostaEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<MercadoApostaEntity> buscarPorMercadoSelecao(MercadoApostaSelecaoEntity mercadoSelecaoSelecionado) {
		if(mercadoSelecaoSelecionado != null && mercadoSelecaoSelecionado.getId() != null){
			return repo.buscarPorMercadoSelecao(mercadoSelecaoSelecionado);
		}
		
		return null;
	}
	
	
	public void validateForm(MercadoApostaEntity entidade) throws ValidationFormAbstractException {
		
	}

}
