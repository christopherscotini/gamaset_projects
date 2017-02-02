package br.com.gamaset.tradeline.repository.goal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.model.goal.TimeGoalEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class TimeGoalRepository extends JpaGenericDao<TimeGoalEntity, Long>{

	public boolean isThere(TimeGoalEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM TimeGoalEntity a WHERE a.descricao = :descricao AND a.pais = :paisId").append(_ESPACE);
			if(entidade.getId() != null){
				query.append("AND a.id <> "+entidade.getId());
			}
			getEntityManager().createQuery(query.toString())
				.setParameter("descricao", entidade.getDescricao())
				.setParameter("paisId", entidade.getPais())
				.getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}

	public List<TimeGoalEntity> buscarPorPais(PaisEntity pais) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT t FROM TimeGoalEntity t WHERE t.pais = :paisId ORDER BY t.descricao ASC");
	
		return getEntityManager().createQuery(str.toString()).setParameter("paisId", pais) .getResultList();
	}

	public List<TimeGoalEntity> listarTodosVincular(PaisEntity paisId) {
		StringBuilder str = new StringBuilder();
		str.append("select tg.* from time_goal tg ");
		str.append("left join time_union tu ON tg.TIGO_CD_ID_PK = tu.TIGO_CD_ID_FK").append(" ");
		str.append("where tu.TIGO_CD_ID_FK is null").append(" ");
		str.append("and tg.PAIS_CD_ID_FK = ").append(paisId.getId()).append(" ");
		str.append("ORDER BY tg.TIGO_DS_NOME").append(" ");
		
		List<TimeGoalEntity> entities = new ArrayList<TimeGoalEntity>();
		List<Object[]> objects = getEntityManager().createNativeQuery(str.toString()).getResultList();
//		[79, Eintracht Frankfurt, resources/img/times/eintrachtfrankfurt-200x200.jpg, 3]
		for (int i = 0; i < objects.size(); i++) {
			TimeGoalEntity t = new TimeGoalEntity();
			t.setId(Long.parseLong(objects.get(i)[0].toString()));
			t.setDescricao((String) objects.get(i)[1]);
			PaisEntity p = new PaisEntity();
			p.setId(Long.parseLong(objects.get(i)[2].toString()));
			t.setPais(p);
			entities.add(t);
		}
		
		
		return entities;
	}

	public TimeGoalEntity buscarPorDescricaoGoalAndPais(String descricao, PaisEntity pais) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM TimeGoalEntity a WHERE a.descricao = :descricao AND a.pais = :paisId").append(_ESPACE);
			
			return (TimeGoalEntity) getEntityManager().createQuery(query.toString())
			.setParameter("descricao", descricao)
			.setParameter("paisId", pais)
			.getSingleResult();
			
		}catch(NoResultException nre){
			return null;
		}
	}

}
