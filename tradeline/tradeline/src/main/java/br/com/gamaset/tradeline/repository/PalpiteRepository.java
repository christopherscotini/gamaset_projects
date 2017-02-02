package br.com.gamaset.tradeline.repository;

import java.util.List;

import br.com.gamaset.tradeline.model.ApostaResultadoEnum;
import br.com.gamaset.tradeline.model.PalpiteEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class PalpiteRepository extends JpaGenericDao<PalpiteEntity, Long>{

	@Override
	public List<PalpiteEntity> findAll() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM PalpiteEntity p ORDER BY p.id ASC");
		
		return getEntityManager().createQuery(str.toString()).getResultList();
		
	}

	public List<PalpiteEntity> findByApostaResultado(ApostaResultadoEnum apostaResultadoFiltro) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM PalpiteEntity p WHERE p.statusPalpite = :apostaResultadoFiltro ORDER BY p.id ASC");
		
		return getEntityManager().createQuery(str.toString()).setParameter("apostaResultadoFiltro", apostaResultadoFiltro).getResultList();

	}
	
}
