package br.com.gamaset.tradeline.repository.prosoccer;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.PaisEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;
import br.com.gamaset.tradeline.utils.StringUtils;

public class CompeticaoPSRepository extends JpaGenericDao<CompeticaoPSEntity, Long>{

	@Override
	public List<CompeticaoPSEntity> findAll() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoPSEntity c ORDER BY c.pais.descricao ASC");
		
		return getEntityManager().createQuery(str.toString()).getResultList();
		
	}

	public List<CompeticaoPSEntity> buscarPorPais(PaisEntity pais) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoPSEntity c WHERE c.pais = :paisId ORDER BY c.pais.descricao ASC, c.descricao ASC");
	
		return getEntityManager().createQuery(str.toString()).setParameter("paisId", pais) .getResultList();
		
	}
	
	public boolean isThere(CompeticaoPSEntity entidade) {
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM CompeticaoPSEntity a WHERE a.codigoDescricao = :descricao").append(_ESPACE);
			if(entidade.getId() != null){
				query.append("AND a.id <> "+entidade.getId());
			}
			getEntityManager().createQuery(query.toString())
				.setParameter("descricao", entidade.getCodigoDescricao())
				.getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}

	public CompeticaoPSEntity buscarPorCodCompeticao(String codigoCompeticao) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoPSEntity c WHERE c.codigoDescricao = :codigoDescricao");
		try{
			codigoCompeticao = StringUtils.trimLeft(codigoCompeticao);
			return (CompeticaoPSEntity) getEntityManager().createQuery(str.toString()).setParameter("codigoDescricao", codigoCompeticao).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}
	
}
