package br.com.gamaset.diaryboard.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.gamaset.diaryboard.model.CaixaApostasEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.repository.dao.JpaGenericDao;

public class CaixaApostaRepository extends JpaGenericDao<CaixaApostasEntity, Long>{

	@Inject
	private PlanoJogoRepository repoPlano = null;
	
	public BigDecimal getSaldoRestanteParaJogo() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT c.valorSaldoDisponivel FROM CaixaApostasEntity c ORDER BY c.id DESC").append(_ESPACE);
		
		try{
			return (BigDecimal) getEntityManager().createQuery(query.toString()).setMaxResults(1).getSingleResult();
		}catch(NoResultException nre){}
		
		return null;
	}
	
	
	public BigDecimal getSaldoConta(){
		BigDecimal ret = null;
		ret = getSaldoRestanteParaJogo();
		if(ret == null){
			ret = BigDecimal.ZERO;
		}
		List<PlanoJogoEntity> planos = repoPlano.findAllAtivos();
		for (int i = 0; i < planos.size(); i++) {
			ret = ret.add(planos.get(i).getApostas().get(planos.get(i).getApostas().size()-1).getVlrFinalDia());
		}
		
		
		return ret;
	}
	
}
