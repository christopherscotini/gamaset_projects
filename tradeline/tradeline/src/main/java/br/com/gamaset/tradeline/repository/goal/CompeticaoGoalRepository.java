package br.com.gamaset.tradeline.repository.goal;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class CompeticaoGoalRepository extends JpaGenericDao<CompeticaoGoalEntity, Long>{

	@Override
	public List<CompeticaoGoalEntity> findAll() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoGoalEntity c ORDER BY c.pais.descricao ASC");
		
		return getEntityManager().createQuery(str.toString()).getResultList();
		
	}

	public List<CompeticaoGoalEntity> buscarPorPais(PaisEntity pais) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoGoalEntity c WHERE c.pais = :paisId ORDER BY c.pais.descricao ASC, c.descricao ASC");
	
		return getEntityManager().createQuery(str.toString()).setParameter("paisId", pais) .getResultList();
		
	}
	
	public boolean isThere(CompeticaoGoalEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM CompeticaoGoalEntity a WHERE a.descricao = :descricao").append(_ESPACE);
			if(entidade.getId() != null){
				query.append("AND a.id <> "+entidade.getId());
			}
			getEntityManager().createQuery(query.toString())
				.setParameter("descricao", entidade.getDescricao())
				.getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}

}
