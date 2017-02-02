package br.com.gamaset.tradeline.repository;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.goal.CompeticaoGoalEntity;
import br.com.gamaset.tradeline.model.prosoccer.CompeticaoPSEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class CompeticaoUnionRepository extends JpaGenericDao<CompeticaoUnionEntity, Long>{

	@Override
	public List<CompeticaoUnionEntity> findAll() {
		StringBuilder str = new StringBuilder();
		str.append("SELECT c FROM CompeticaoUnionEntity c ORDER BY c.competicaoSistema ASC");
		
		return getEntityManager().createQuery(str.toString()).getResultList();
		
	}

	public CompeticaoUnionEntity buscarPorIdCompeticaoGoal(CompeticaoGoalEntity competicao) {
		CompeticaoGoalEntity compGoal = null;
		CompeticaoUnionEntity returnzz = null;
		try{
			StringBuilder strGoal = new StringBuilder();
			strGoal.append("SELECT c FROM CompeticaoGoalEntity c").append(" ");
			strGoal.append("WHERE c.descricao = :compGoalDescricao").append(" ");
			strGoal.append("AND c.pais = :paisId");
			
			compGoal = (CompeticaoGoalEntity) getEntityManager().createQuery(strGoal.toString())
				.setParameter("compGoalDescricao", competicao.getDescricao())
				.setParameter("paisId", competicao.getPais()).getSingleResult();
		}catch(NoResultException nre){
			System.err.println(">> NAO ENCONTRADO CompeticaoGoalEntity "+competicao.toString());
		}
		
		if(compGoal != null){
			try{
				StringBuilder strUnion = new StringBuilder();
				strUnion.append("SELECT cu FROM CompeticaoUnionEntity cu").append(" ");
				strUnion.append("WHERE cu.competicaoGoal = :competicaoGoal").append(" ");
				strUnion.append("AND cu.pais = :paisId");
				
				returnzz = (CompeticaoUnionEntity) getEntityManager().createQuery(strUnion.toString())
				.setParameter("competicaoGoal", compGoal)
				.setParameter("paisId", compGoal.getPais()).getSingleResult();
				
			}catch(NoResultException nre){
				System.err.println(">> NAO ENCONTRADO CompeticaoUnionEntity "+compGoal.toString());
			}
		}
		
		return returnzz;
	}

	public CompeticaoUnionEntity buscarPorIdCompeticaoProsoccer(CompeticaoPSEntity competicao) {
		CompeticaoUnionEntity returnzz = new CompeticaoUnionEntity();
		try{
			StringBuilder strUnion = new StringBuilder();
			strUnion.append("SELECT cu FROM CompeticaoUnionEntity cu").append(" ");
			strUnion.append("WHERE cu.competicaoProsoccer = :competicaoProsoccer").append(" ");
			
			returnzz = (CompeticaoUnionEntity) getEntityManager().createQuery(strUnion.toString())
			.setParameter("competicaoProsoccer", competicao).getSingleResult();
			
		}catch(NoResultException nre){
			System.err.println(">> NAO ENCONTRADO CompeticaoUnionEntity "+competicao.toString());
		}
		return returnzz;
	}

	
}
