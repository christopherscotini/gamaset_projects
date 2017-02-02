package br.com.gamaset.tradeline.repository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import br.com.gamaset.tradeline.dto.DataFilterDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoLigaDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoTableDTO;
import br.com.gamaset.tradeline.model.ApostaResultadoEnum;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.PalpiteEntity;
import br.com.gamaset.tradeline.model.TipsterEntity;
import br.com.gamaset.tradeline.repository.dao.JpaGenericDao;
import br.com.gamaset.tradeline.utils.ProjectUtils;

public class PalpiteEstatisticaPorMercadoRepository extends JpaGenericDao<PalpiteEntity, Long>{

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

	public PalpiteEstatisticaPorMercadoTableDTO lerEstatisticaPorMercadoData(DataFilterDTO dataFiltro, Long mercadoSelecaoId, TipsterEntity tipsterSelecionado) {
//		SELECT c.COMP_DS_NOME AS COMPETICAO, count(*)AS CERTAS, (SUM(p.PALP_VL_ODD)-count(*)) AS SOMA_ODDS

		
		PalpiteEstatisticaPorMercadoTableDTO dto = new PalpiteEstatisticaPorMercadoTableDTO();
		dto.setListaEstatisticaPorLiga(calcularPorLiga(dataFiltro, mercadoSelecaoId, tipsterSelecionado));
		
		
		return dto;
	}
	
	private List<PalpiteEstatisticaPorMercadoLigaDTO> calcularPorLiga(DataFilterDTO dataFiltro, Long mercadoSelecaoId, TipsterEntity tipsterSelecionado){
		
		StringBuilder str2 = new StringBuilder();
		str2.append("SELECT p.competicao, count(p) AS TOTAL FROM PalpiteEntity p").append(_ESPACE);
		str2.append("WHERE p.mercadoAposta.selecao.id = :mercadoSelecaoId").append(_ESPACE);
		str2.append("AND p.tipster = :tipsterId").append(_ESPACE);
//		/*TEMP*/ str2.append("AND p.competicao.id = 59").append(_ESPACE);
		str2.append("GROUP BY p.competicao.id").append(_ESPACE);
		str2.append("ORDER BY p.competicao.id");
		List<Object[]> palpitesTotal = getEntityManager().createQuery(str2.toString()).setParameter("mercadoSelecaoId", mercadoSelecaoId).setParameter("tipsterId", tipsterSelecionado).getResultList();

		
		StringBuilder str = new StringBuilder();
		str.append("SELECT p.competicao, count(p) AS CERTAS, (SUM(p.valorOdd)-count(p)) AS SOMA_RENT FROM PalpiteEntity p").append(_ESPACE);
		str.append("WHERE p.mercadoAposta.selecao.id = :mercadoSelecaoId").append(_ESPACE);
		str.append("AND p.statusPalpite = :statusPalpite").append(_ESPACE);
		str.append("AND p.tipster = :tipsterId").append(_ESPACE);
//		/*TEMP*/ str.append("AND p.competicao.id = 59").append(_ESPACE);
		str.append("GROUP BY p.competicao.id").append(_ESPACE);
		str.append("ORDER BY p.competicao.id");
		List<Object[]> listaLigasEstatisticaGanhos = getEntityManager().createQuery(str.toString()).setParameter("mercadoSelecaoId", mercadoSelecaoId).setParameter("tipsterId", tipsterSelecionado).setParameter("statusPalpite", ApostaResultadoEnum.GANHOU).getResultList();

		List<PalpiteEstatisticaPorMercadoLigaDTO> listaLigasEstatistica = new ArrayList<PalpiteEstatisticaPorMercadoLigaDTO>();
		for (int i = 0; i < palpitesTotal.size(); i++) {
			PalpiteEstatisticaPorMercadoLigaDTO dto = new PalpiteEstatisticaPorMercadoLigaDTO();
			dto.setLiga((CompeticaoEntity) palpitesTotal.get(i)[0]);
			dto.setTotalDePalpites(Integer.parseInt(palpitesTotal.get(i)[1].toString()));
			listaLigasEstatistica.add(dto);
		}
		
		for (int i = 0; i < listaLigasEstatistica.size(); i++) {
			PalpiteEstatisticaPorMercadoLigaDTO dto = listaLigasEstatistica.get(i);
			for (int j = 0; j < listaLigasEstatisticaGanhos.size(); j++) {
				CompeticaoEntity c = (CompeticaoEntity) listaLigasEstatisticaGanhos.get(j)[0];
				if(dto.getLiga().equals(c)){
					dto.setTotalDeAcertos(Integer.parseInt(listaLigasEstatisticaGanhos.get(j)[1].toString()));
					BigDecimal rent = (BigDecimal) listaLigasEstatisticaGanhos.get(j)[2];
					dto.setPercentAproveitamento(calcularAproveitamento(dto.getTotalDePalpites(), dto.getTotalDeAcertos()));
					dto.setPercentRentabilidade(calcularRentabilidade(dto.getTotalDePalpites()-dto.getTotalDeAcertos(), rent));
					break;
				}else{
					dto.setTotalDeAcertos(0);
					dto.setPercentAproveitamento(new BigDecimal(dto.getTotalDePalpites()).multiply(new BigDecimal("-100")));
					dto.setPercentRentabilidade(new BigDecimal(dto.getTotalDePalpites()).multiply(new BigDecimal("-100")));
				}
				
			}
		}
		
		return listaLigasEstatistica;
		
	}
	
	
	private BigDecimal calcularRentabilidade(int totalErro, BigDecimal rentabilidade) {
		BigDecimal rent = rentabilidade.multiply(new BigDecimal("100"));
		for (int i = 0; i < totalErro; i++) {
			rent = rent.subtract(new BigDecimal("100"));
		}
		return rent;
	}

	private BigDecimal calcularAproveitamento(Integer totalPalpites, Integer totalAcertos){
		if(totalPalpites.equals(totalAcertos)){
			return new BigDecimal("100");
		}else{
			BigDecimal aproveitamento = new BigDecimal(totalAcertos, MathContext.DECIMAL128).divide(new BigDecimal(totalPalpites, MathContext.DECIMAL128), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
			aproveitamento = aproveitamento.multiply(new BigDecimal("100"));
			
			return aproveitamento;
		}
		
	}
}
