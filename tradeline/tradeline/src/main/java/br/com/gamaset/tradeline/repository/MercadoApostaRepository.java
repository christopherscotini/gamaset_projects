package br.com.gamaset.tradeline.repository;

import java.util.List;

import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;

public class MercadoApostaRepository extends JpaGenericDao<MercadoApostaEntity, Long>{

	@Override
	public List<MercadoApostaEntity> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("FROM MercadoApostaEntity m ORDER BY m.selecao.id, m.id");
		return getEntityManager().createQuery(query.toString()).getResultList();
	}

	public List<MercadoApostaEntity> buscarPorMercadoSelecao(
			MercadoApostaSelecaoEntity mercadoSelecaoSelecionado) {
		StringBuilder query = new StringBuilder();
		query.append("FROM MercadoApostaEntity m WHERE m.selecao = :mercadoSelecaoId ORDER BY m.selecao.id, m.id");
		
		return getEntityManager().createQuery(query.toString()).setParameter("mercadoSelecaoId", mercadoSelecaoSelecionado).getResultList();
		
	}
}
