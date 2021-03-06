package br.com.gamaset.diaryboard.repository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.model.ApostaResultadoEnum;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;
import br.com.gamaset.diaryboard.utils.ProjectUtils;

public class PlanoJogoItemRepository extends JpaGenericDao<PlanoJogoItemEntity, Long>{

	@Inject
	private ApostaRepository repoAposta = null;
	
	public List<PlanoJogoItemEntity> findByPlanoJogoId(Long id) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT p FROM PlanoJogoItemEntity p").append(_ESPACE);
		query.append("WHERE p.planoJogo.id = :id");
		
		List<PlanoJogoItemEntity> returnzz = getEntityManager().createQuery(query.toString()).setParameter("id", id).getResultList();
		
		return returnzz;
	}

	public void atualizarPlanoJogoAcompanhamento(ApostaEntity aposta, boolean update) {
		StringBuilder queryPlanos = new StringBuilder();
		queryPlanos.append("SELECT p FROM PlanoJogoItemEntity p WHERE p.planoJogo.id = :idPlanoJogo AND p.id >= :idPlanoItem ORDER BY p.id ASC");
		Long idPlano = aposta.getPlanoJogoItem().getPlanoJogo().getId();
		Long idPlanoItem = aposta.getPlanoJogoItem().getId();
		if(update){
			idPlanoItem = (Long)getEntityManager().createQuery("SELECT p.planoJogoItem.id FROM ApostaEntity p WHERE p.id = :idAposta").setParameter("idAposta", aposta.getId()).getSingleResult();
			if(idPlanoItem > aposta.getPlanoJogoItem().getId()){
				idPlanoItem = aposta.getPlanoJogoItem().getId();
			}
			repoAposta.update(aposta);
		}
		
		List<PlanoJogoItemEntity> planosItem = getEntityManager().createQuery(queryPlanos.toString()).setParameter("idPlanoJogo", idPlano).setParameter("idPlanoItem", idPlanoItem).getResultList();
		
		for (int i = 0; i < planosItem.size(); i++) {
			PlanoJogoItemEntity p =  planosItem.get(i);
			StringBuilder queryApostas = new StringBuilder();
			queryApostas.append("SELECT p FROM ApostaEntity p WHERE p.planoJogoItem.id = :idPlanoItemAux ");
			Long idPlanoItemAux = p.getId();
			List<ApostaEntity> apostas = getEntityManager().createQuery(queryApostas.toString()).setParameter("idPlanoItemAux", idPlanoItemAux).getResultList();

			p.setVlrLucroDia(BigDecimal.ZERO);
			p.setPercLucroDia(BigDecimal.ZERO);
			p.setPercLucroMeta(BigDecimal.ZERO);
			p.setVlrTotalGanhoDia(BigDecimal.ZERO);
			p.setVlrTotalPerdidoDia(BigDecimal.ZERO);
			if(i==0){
				p.setVlrFinalDia(p.getVlrInicialDia());
			}else{
				p.setVlrInicialDia(planosItem.get(i-1).getVlrFinalDia());
				p.setVlrFinalDia(p.getVlrInicialDia());
			}
			
			for (int j = 0; j < apostas.size(); j++) {
				ApostaEntity a = apostas.get(j);
				BigDecimal lucroAposta = (a.getValorRetorno().subtract(a.getValorAposta()));
				if(a.getResultado().equals(ApostaResultadoEnum.GANHOU)){
					p.setVlrFinalDia(p.getVlrFinalDia().add(lucroAposta));
					p.setVlrLucroDia(p.getVlrLucroDia().add(lucroAposta));
				}else{
					p.setVlrFinalDia(p.getVlrFinalDia().subtract(a.getValorAposta()));
					p.setVlrLucroDia(p.getVlrLucroDia().subtract(a.getValorAposta()));
				}
				
			}
			
			p.setPercLucroMeta(p.getVlrLucroDia().divide(p.getVlrInicialDiaObjetivo(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
			p.setPercLucroDia(p.getVlrLucroDia().divide(p.getVlrInicialDia(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
			p.setPercObjetivoConcluidoDia(p.getVlrFinalDia().divide(p.getVlrFinalDiaObjetivo(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
			
			if(p.getPercObjetivoConcluidoDia().compareTo(new BigDecimal("100.00")) >= 0){
				p.setFinalizado(true);
			}
			
			this.update(p);
		}
		
	
	}
	

	public void atualizarPlanoJogoAcompanhamentoExclusao(ApostaEntity aposta) {
		StringBuilder q = new StringBuilder();
		q.append("SELECT p FROM PlanoJogoItemEntity p WHERE p.planoJogo.id = :idPlanoJogo AND p.id >= :idPlanoItem ORDER BY p.id ASC");
		Long idPlano = aposta.getPlanoJogoItem().getPlanoJogo().getId();
		Long idPlanoItem = aposta.getPlanoJogoItem().getPlanoJogo().getId();
		List<PlanoJogoItemEntity> planos = getEntityManager().createQuery(q.toString()).setParameter("idPlanoJogo", idPlano).setParameter("idPlanoItem", idPlanoItem).getResultList();
		for (int i = 0; i < planos.size(); i++) {
			PlanoJogoItemEntity p = planos.get(i);
			p.setVlrFinalDia(p.getVlrFinalDia().add(aposta.getValorAposta()));
		}
	}
	
	public void excluirItensPorPlanoJogo(PlanoJogoEntity plano){
		
	}
	
}
