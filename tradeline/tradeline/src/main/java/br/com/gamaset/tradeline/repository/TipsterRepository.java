package br.com.gamaset.tradeline.repository;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.TipsterEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class TipsterRepository extends JpaGenericDao<TipsterEntity, Long>{

	public boolean isThere(TipsterEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM TipsterEntity a WHERE a.descricao = :descricao").append(_ESPACE);
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
