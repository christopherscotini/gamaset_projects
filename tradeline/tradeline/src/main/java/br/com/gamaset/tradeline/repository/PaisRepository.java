package br.com.gamaset.tradeline.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class PaisRepository extends JpaGenericDao<PaisEntity, Long>{

	public List<PaisEntity> listarTodosComCompeticao() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT distinct(p.id), p FROM PaisEntity p, CompeticaoEntity c").append(" ");
		str.append("WHERE p.id = c.pais.id").append(" ");
		str.append("ORDER BY c.pais.descricao").append(" ");
		
		List<Object[]> objects = getEntityManager().createQuery(str.toString()).getResultList();
		List<PaisEntity> returnzz = new ArrayList<PaisEntity>();
		for (int i = 0; i < objects.size(); i++) {
			PaisEntity p = (PaisEntity)objects.get(i)[1];
			returnzz.add(p);
		}
		
		return returnzz;
	}

	public PaisEntity buscarPorGoalId(Long idGoal) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM PaisEntity p").append(" ");
		str.append("WHERE p.idGoal = :idGoal").append(" ");
		
		try{
			return (PaisEntity) getEntityManager().createQuery(str.toString()).setParameter("idGoal", idGoal).getSingleResult();
		}catch(NoResultException nre){}
		
		return null;
	}


}
