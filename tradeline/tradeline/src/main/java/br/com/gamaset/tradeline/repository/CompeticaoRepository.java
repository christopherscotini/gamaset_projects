package br.com.gamaset.tradeline.repository;

import java.util.List;

import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class CompeticaoRepository extends JpaGenericDao<CompeticaoEntity, Long>{

	@Override
	public List<CompeticaoEntity> findAll() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoEntity c ORDER BY c.pais.descricao ASC");
		
		return getEntityManager().createQuery(str.toString()).getResultList();
		
	}

	public List<CompeticaoEntity> buscarPorPais(PaisEntity pais) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoEntity c WHERE c.pais = :paisId ORDER BY c.pais.descricao ASC, c.descricao ASC");
	
		return getEntityManager().createQuery(str.toString()).setParameter("paisId", pais) .getResultList();
		
	}
	
}
