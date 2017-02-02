package br.com.gamaset.tradeline.business.bo.impl.goal;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.repository.goal.TimeGoalRepository;
import br.com.gamaset.tradeline.business.bo.goal.*;

@Stateless
public class TimeGoalServiceImpl implements TimeGoalService{

	@Inject
	private TimeGoalRepository repo = null;
	
	
	public List<TimeGoalEntity> listarTodos() {
		return repo.findAll();
	}

	
	public TimeGoalEntity adicionarEntidade(TimeGoalEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public TimeGoalEntity editarEntidade(TimeGoalEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(TimeGoalEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<TimeGoalEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public void validateForm(TimeGoalEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getDescricao());
		}
	}

	
	public List<TimeGoalEntity> listarTodosVincular(PaisEntity paisId) {
		return repo.listarTodosVincular(paisId);
	}
	
	
	public TimeGoalEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais) {
		return repo.buscarPorDescricaoGoalAndPais(descricao, pais);
	}
	
}
