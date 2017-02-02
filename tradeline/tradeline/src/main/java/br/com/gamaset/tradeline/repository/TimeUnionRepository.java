package br.com.gamaset.tradeline.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class TimeUnionRepository extends JpaGenericDao<TimeUnionEntity, Long>{

	public boolean isThere(TimeUnionEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("SELECT tu FROM TimeUnionEntity tu").append(_ESPACE);
			query.append("WHERE tu.timeSistema = :timeSistemaId").append(_ESPACE);
			query.append("AND tu.timeGoal = :timeGoalId").append(_ESPACE);
			query.append("AND tu.timeProsoccer = :timeProsoccerId").append(_ESPACE);
			query.append("AND tu.pais = :paisId").append(_ESPACE);
			query.append("").append(_ESPACE);
			if(entidade.getId() != null){
				query.append("AND tu.id <> "+entidade.getId());
			}
			getEntityManager().createQuery(query.toString())
				.setParameter("timeSistemaId", entidade.getTimeSistema())
				.setParameter("timeGoalId", entidade.getTimeGoal())
				.setParameter("timeProsoccerId", entidade.getTimeProsoccer())
				.setParameter("paisId", entidade.getPais())
				.getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}

	public TimeUnionEntity buscarPorDescricaoProSoccerAndPais(String descricaoTime, PaisEntity pais) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tu FROM TimeUnionEntity tu").append(_ESPACE);
		query.append("WHERE tu.timeProsoccer.descricao = :descricaoTime").append(_ESPACE);
		query.append("AND tu.pais = :paisId").append(_ESPACE);
		
		try{
			return (TimeUnionEntity) getEntityManager().createQuery(query.toString())
					.setParameter("descricaoTime", descricaoTime)
					.setParameter("paisId", pais)
					.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}

	public TimeUnionEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tu FROM TimeUnionEntity tu").append(_ESPACE);
		query.append("WHERE tu.timeGoal.descricao = :descricao").append(_ESPACE);
		query.append("AND tu.pais = :paisId").append(_ESPACE);
		
		try{
			return (TimeUnionEntity) getEntityManager().createQuery(query.toString())
					.setParameter("descricao", descricao)
					.setParameter("paisId", pais)
					.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}

	}


}
