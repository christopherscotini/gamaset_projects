package br.com.gamaset.tradeline.business.bo.impl.prosoccer;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.prosoccer.TimePSService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.prosoccer.TimePSEntity;
import br.com.gamaset.tradeline.repository.prosoccer.TimePSRepository;

@Stateless
public class TimePSServiceImpl implements TimePSService{

	@Inject
	private TimePSRepository repo = null;
	
	
	public List<TimePSEntity> listarTodos() {
		return repo.findAll();
	}

	
	public TimePSEntity adicionarEntidade(TimePSEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public TimePSEntity editarEntidade(TimePSEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(TimePSEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<TimePSEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public void validateForm(TimePSEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getDescricao());
		}
	}

	
	public List<TimePSEntity> listarTodosVincular(PaisEntity paisId) {
		// TODO Auto-generated method stub
		return repo.listarTodosVincular(paisId);
	}
	
}
