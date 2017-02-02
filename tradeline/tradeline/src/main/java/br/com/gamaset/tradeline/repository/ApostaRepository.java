package br.com.gamaset.tradeline.repository;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.ApostaEntity;
import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class ApostaRepository extends JpaGenericDao<ApostaEntity, Long>{

	public boolean isThere(ApostaEntity obj){
		StringBuilder query = new StringBuilder();
		try{
			query.append("FROM ApostaEntity a WHERE a.ticket = :ticket").append(_ESPACE);
			if(obj.getId() != null){
				query.append("AND a.id <> "+obj.getId());
			}
			getEntityManager().createQuery(query.toString()).setParameter("ticket", obj.getTicket()).getSingleResult();
			
			return true;
		}catch(NoResultException nre){
			return false;
		}
	}
	
	@Override
	public List<ApostaEntity> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("FROM ApostaEntity a ORDER BY a.dataAposta DESC, a.planoJogoItem.planoJogo.descricao DESC, a.planoJogoItem.descricao DESC").append(_ESPACE);
		return getEntityManager().createQuery(query.toString()).getResultList();
	}

	public List<ApostaEntity> buscarApostaPorPlanoItem(PlanoJogoItemEntity planoJogoItem) {
		StringBuilder query = new StringBuilder();
		query.append("FROM ApostaEntity a WHERE a.planoJogoItem = :planoJogoItem").append(_ESPACE);
		return getEntityManager().createQuery(query.toString()).setParameter("planoJogoItem", planoJogoItem).getResultList();
	}
	
	
}
