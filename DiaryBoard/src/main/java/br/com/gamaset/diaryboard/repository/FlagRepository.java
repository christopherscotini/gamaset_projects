package br.com.gamaset.diaryboard.repository;

import java.util.List;

import br.com.gamaset.diaryboard.model.FlagEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class FlagRepository extends JpaGenericDao<FlagEntity, Long>{
	
	@Override
	public List<FlagEntity> findAll() {

		return getEntityManager().createQuery("SELECT f FROM FlagEntity f ORDER BY f.nomeCompeticao ASC").getResultList();
	}

}
