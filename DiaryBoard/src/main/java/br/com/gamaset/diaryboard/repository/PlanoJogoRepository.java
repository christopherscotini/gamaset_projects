package br.com.gamaset.diaryboard.repository;

import javax.persistence.NoResultException;

import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class PlanoJogoRepository extends JpaGenericDao<PlanoJogoEntity, Long>{
	
	public boolean isThere(PlanoJogoEntity obj){
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM PlanoJogoEntity a WHERE a.descricao = :descricao").append(_ESPACE);
			if(obj.getId() != null){
				query.append("AND a.id <> "+obj.getId());
			}
			getEntityManager().createQuery(query.toString()).setParameter("descricao", obj.getDescricao()).getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}
	
}
