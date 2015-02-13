package br.com.gamaset.diaryboard.repository;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class CampeonatoRepository extends JpaGenericDao<CampeonatoEntity, Long>{

	public boolean isThere(CampeonatoEntity obj) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM CampeonatoEntity a WHERE a.sigla = :sigla").append(_ESPACE);
			if(obj.getId() != null){
				query.append("AND a.id <> "+obj.getId());
			}
			getEntityManager().createQuery(query.toString()).setParameter("sigla", obj.getSigla()).getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}
	
	@Override
	public List<CampeonatoEntity> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("FROM CampeonatoEntity a ORDER BY a.flag.nomeCompeticao ASC").append(_ESPACE);
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}

}
