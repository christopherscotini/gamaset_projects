package br.com.gamaset.diaryboard.repository;

import java.util.List;

import br.com.gamaset.diaryboard.model.MercadoApostaEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class MercadoApostaRepository extends JpaGenericDao<MercadoApostaEntity, Long>{

	@Override
	public List<MercadoApostaEntity> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("FROM MercadoApostaEntity m ORDER BY m.selecao.id, m.id");
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
}
