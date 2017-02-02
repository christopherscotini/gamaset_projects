package br.com.gamaset.tradeline.business.bo.impl.prosoccer;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.prosoccer.CompeticaoPSService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.prosoccer.CompeticaoPSRepository;

@Stateless
public class CompeticaoPSServiceImpl implements CompeticaoPSService{

	@Inject
	private CompeticaoPSRepository repo = null;
	
	
	public List<CompeticaoPSEntity> listarTodos() {
		return repo.findAll();
	}

	
	public CompeticaoPSEntity adicionarEntidade(CompeticaoPSEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public CompeticaoPSEntity editarEntidade(CompeticaoPSEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(CompeticaoPSEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<CompeticaoPSEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public CompeticaoPSEntity buscarPorCodCompeticao(String codigoCompeticao) {
		return repo.buscarPorCodCompeticao(codigoCompeticao);
	}
	
	
	public void validateForm(CompeticaoPSEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getCodigoDescricao());
		}
	}

	
	
}
