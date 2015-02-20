package br.com.gamaset.diaryboard.repository;

import java.util.List;

import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.model.ResultadoEntityEnum;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class PlanoJogoItemRepository extends JpaGenericDao<PlanoJogoItemEntity, Long>{

	public List<PlanoJogoItemEntity> findByPlanoJogoId(PlanoJogoEntity entity) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT p FROM PlanoJogoItemEntity p").append(_ESPACE);
		query.append("WHERE p.planoJogo = :planoJogo");
		
		List<PlanoJogoItemEntity> returnzz = getEntityManager().createQuery(query.toString()).setParameter("planoJogo", entity).getResultList();
		
		return returnzz;
	}

	public void atualizarPlanoJogoAcompanhamento(ApostaEntity aposta) {
		StringBuilder q = new StringBuilder();
		q.append("SELECT p FROM PlanoJogoItemEntity p WHERE p.planoJogo.id = :idPlanoJogo AND p.id >= :idPlanoItem ORDER BY p.id ASC");
		Long idPlano = aposta.getPlanoJogoItem().getPlanoJogo().getId();
		Long idPlanoItem = aposta.getPlanoJogoItem().getPlanoJogo().getId();
		List<PlanoJogoItemEntity> planos = getEntityManager().createQuery(q.toString()).setParameter("idPlanoJogo", idPlano).setParameter("idPlanoItem", idPlanoItem).getResultList();
		if(aposta.getResultado().equals(ResultadoEntityEnum.AINDA_POR_ACONTECER) || aposta.getResultado().equals(ResultadoEntityEnum.PERDEU)){
			//subtrai
		}else{
			//soma
		}
		
	}
	
}
