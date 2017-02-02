package br.com.gamaset.tradeline.business.bo.impl.goal;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.goal.CompeticaoGoalService;
import br.com.gamaset.tradeline.business.exception.NonUniqueResultDataException;
import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.repository.goal.CompeticaoGoalRepository;

@Stateless
public class CompeticaoGoalServiceImpl implements CompeticaoGoalService{

	@Inject
	private CompeticaoGoalRepository repo = null;
	
	
	public List<CompeticaoGoalEntity> listarTodos() {
		return repo.findAll();
	}

	
	public CompeticaoGoalEntity adicionarEntidade(CompeticaoGoalEntity entidade) {
		validateForm(entidade);
		return repo.insert(entidade);
	}

	
	public CompeticaoGoalEntity editarEntidade(CompeticaoGoalEntity entidade) {
		validateForm(entidade);
		return repo.update(entidade);
	}
	
	
	public void excluirEntidade(CompeticaoGoalEntity entidade) {
		repo.delete(entidade);
	}

	
	public List<CompeticaoGoalEntity> buscarPorPais(PaisEntity pais) {
		if(pais != null & pais.getId() != null){
			return repo.buscarPorPais(pais);
		}
		return null;
	}
	
	
	public void validateForm(CompeticaoGoalEntity entidade) throws ValidationFormAbstractException {
		if(repo.isThere(entidade)){
			throw new NonUniqueResultDataException(entidade.getPais().getDescricao() +" - "+ entidade.getDescricao());
		}
	}

	
	
}
