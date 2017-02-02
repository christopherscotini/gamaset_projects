package br.com.gamaset.tradeline.business.bo.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.CompeticaoUnionService;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.CompeticaoUnionRepository;

@Stateless
public class CompeticaoUnionServiceImpl implements CompeticaoUnionService{

	@Inject
	private CompeticaoUnionRepository repo = null;
	
	
	public List<CompeticaoUnionEntity> listarTodos() {
		return repo.findAll();
	}

	
	public CompeticaoUnionEntity adicionarEntidade(CompeticaoUnionEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public CompeticaoUnionEntity editarEntidade(CompeticaoUnionEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(CompeticaoUnionEntity entidade) {
		repo.delete(entidade);
	}

	
	
	public void validateForm(CompeticaoUnionEntity entidade) throws ValidationFormAbstractException {

	}

	
	public CompeticaoUnionEntity buscarPorIdCompeticaoSistema(CompeticaoEntity competicao) {

		return null;
	}

	
	public CompeticaoUnionEntity buscarPorIdCompeticaoGoal(CompeticaoGoalEntity competicao) {
		
		return repo.buscarPorIdCompeticaoGoal(competicao);
	}

	
	public CompeticaoUnionEntity buscarPorIdCompeticaoProsoccer(CompeticaoPSEntity competicao) {

		return repo.buscarPorIdCompeticaoProsoccer(competicao);
	}

	
	
}
