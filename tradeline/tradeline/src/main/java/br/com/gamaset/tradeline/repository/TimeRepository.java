package br.com.gamaset.tradeline.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.TimeEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class TimeRepository extends JpaGenericDao<TimeEntity, Long>{

	public boolean isThere(TimeEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM TimeEntity a WHERE a.descricao = :descricao AND a.pais = :paisId").append(_ESPACE);
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

	public List<TimeEntity> buscarPorPais(PaisEntity pais) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT t FROM TimeEntity t WHERE t.pais = :paisId ORDER BY t.descricao ASC");
	
		return getEntityManager().createQuery(str.toString()).setParameter("paisId", pais) .getResultList();
	}

	public List<TimeEntity> listarTodosVincular(PaisEntity paisId) {
		StringBuilder str = new StringBuilder();
		str.append("select t.* from time t").append(" ");
		str.append("left join time_union tu ON t.TIME_CD_ID_PK = tu.TIME_CD_ID_FK").append(" ");
		str.append("where tu.TIME_CD_ID_FK is null").append(" ");
		str.append("and t.PAIS_CD_ID_FK = ").append(paisId.getId()).append(" ");
		str.append("ORDER BY t.TIME_DS_NOME").append(" ");
	
		List<TimeEntity> entities = new ArrayList<TimeEntity>();
		List<Object[]> objects = getEntityManager().createNativeQuery(str.toString()).getResultList();
//		[79, Eintracht Frankfurt, resources/img/times/eintrachtfrankfurt-200x200.jpg, 3]
		for (int i = 0; i < objects.size(); i++) {
			TimeEntity t = new TimeEntity();
			t.setId(Long.parseLong(objects.get(i)[0].toString()));
			t.setDescricao((String) objects.get(i)[1]);
			PaisEntity p = new PaisEntity();
			p.setId(Long.parseLong(objects.get(i)[3].toString()));
			t.setPais(p);
			entities.add(t);
		}
		
		
		return entities;
	}

}
