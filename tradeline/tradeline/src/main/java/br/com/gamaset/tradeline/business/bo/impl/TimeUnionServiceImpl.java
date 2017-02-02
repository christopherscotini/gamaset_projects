package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.TimeUnionService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.repository.TimeUnionRepository;

@Stateless
public class TimeUnionServiceImpl implements TimeUnionService{

	@Inject
	private TimeUnionRepository repo = null;
	
	
	public List<TimeUnionEntity> listarTodos() {
		return repo.findAll();
	}

	
	public TimeUnionEntity adicionarEntidade(TimeUnionEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public TimeUnionEntity editarEntidade(TimeUnionEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(TimeUnionEntity entidade) {
		repo.delete(entidade);
	}
	
	
	public TimeUnionEntity buscarPorDescricaoProSoccerAndPais(String descricaoTime, PaisEntity pais) {
		return repo.buscarPorDescricaoProSoccerAndPais(descricaoTime, pais);
	}
	
	
	public TimeUnionEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais) {
		return repo.buscarPorDescricaoGoalAndPais(descricao, pais);
	}

	
	public void validateForm(TimeUnionEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException("unionId= "+ entidade.getId() + " - " + entidade.getTimeSistema().getDescricao());
		}
	}

	
}
