package br.com.gamaset.tradeline.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.CaixaApostaTipoMovEnum;
import br.com.gamaset.tradeline.model.CaixaApostasEntity;
import br.com.gamaset.tradeline.model.PlanoJogoEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

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


	public void atualizarCaixaPlanoJogo(PlanoJogoEntity entidade, CaixaApostaTipoMovEnum tipoMov) {
		CaixaApostasEntity c = new CaixaApostasEntity();
		c.setTipoMovimentacaoEnum(tipoMov);
		
		BigDecimal restante = getSaldoRestanteParaJogo();
		if(tipoMov.equals(CaixaApostaTipoMovEnum.SAIDA_PLANO)){
			c.setValorSaldoDisponivel(restante.subtract(entidade.getValorInvestimentoInicial()));
			c.setValorMovimentacao(entidade.getValorInvestimentoInicial());
		}else{
			c.setValorMovimentacao(entidade.getApostas().get(entidade.getApostas().size()-1).getVlrFinalDia());
			c.setValorSaldoDisponivel(restante.add(entidade.getApostas().get(entidade.getApostas().size()-1).getVlrFinalDia()));
		}
		
		insert(c);
	}
	
}
