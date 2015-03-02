package br.com.gamaset.diaryboard.repository;

import java.util.List;

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
	
	@Override
	public List<PlanoJogoEntity> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("FROM PlanoJogoEntity a ORDER BY a.dataCriacao DESC").append(_ESPACE);
		
		try{
			return (List<PlanoJogoEntity>) getEntityManager().createQuery(query.toString()).getResultList();
		}catch(NoResultException nre){
			return null;
		}
		
	}

	public List<PlanoJogoEntity> findAllAtivos() {
		StringBuilder query = new StringBuilder();
		query.append("FROM PlanoJogoEntity a WHERE a.ativo = 1 ORDER BY a.dataCriacao DESC").append(_ESPACE);
		
		try{
			return (List<PlanoJogoEntity>) getEntityManager().createQuery(query.toString()).getResultList();
		}catch(NoResultException nre){
			return null;
		}
		
	}
	
}
