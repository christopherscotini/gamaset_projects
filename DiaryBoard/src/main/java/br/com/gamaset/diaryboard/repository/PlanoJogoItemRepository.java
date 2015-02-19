package br.com.gamaset.diaryboard.repository;

import java.util.List;

import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class PlanoJogoItemRepository extends JpaGenericDao<PlanoJogoItemEntity, Long>{

	public List<PlanoJogoItemEntity> findByPlanoJogoId(PlanoJogoEntity entity) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT p FROM PlanoJogoItemEntity p").append(_ESPACE);
		query.append("WHERE p.planoJogo = :planoJogo");
		
		List<PlanoJogoItemEntity> returnzz = getEntityManager().createQuery(query.toString()).setParameter("planoJogo", entity).getResultList();
		
		return returnzz;
	}
	
}
