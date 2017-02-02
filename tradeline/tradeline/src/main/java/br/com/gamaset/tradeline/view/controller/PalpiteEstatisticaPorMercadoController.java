package br.com.gamaset.tradeline.view.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.dto.DataFilterDTO;
import br.com.gamaset.tradeline.dto.palpite.PalpiteEstatisticaPorMercadoDTO;
import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.TipsterEntity;


@ManagedBean
@SessionScoped
public class PalpiteEstatisticaPorMercadoController extends AbstractController{

	private final String TELA_PALPITE_ESTATISTICA= "/content/palpite/palpite_estatistica_mercado.xhtml";
	
	private PalpiteEstatisticaPorMercadoDTO entities;
	private DataFilterDTO dataFiltro;
	private List<TipsterEntity> tipsterList;
	private TipsterEntity tipsterSelecionado;
	
	@Override
	public String iniciarTela() {
		dataFiltro = new DataFilterDTO();
		dataFiltro.setDataInicio(new Date());
		dataFiltro.setDataFinal(new Date());
		tipsterList = tipsterService.listarTodos();
		tipsterSelecionado = tipsterList.get(0);
		entities = null;
		return TELA_PALPITE_ESTATISTICA;
	}
	
	public void lerEstatisticas(){
		entities = palpiteEstatisticaPorMercadoService.lerEstatisticasPorData(dataFiltro, tipsterSelecionado);
	}
	

	
	
/* -------------------------------------------------------- */	



	public PalpiteEstatisticaPorMercadoDTO getEntities() {
		return entities;
	}

	public void setEntities(PalpiteEstatisticaPorMercadoDTO entities) {
		this.entities = entities;
	}

	public DataFilterDTO getDataFiltro() {
		return dataFiltro;
	}

	public void setDataFiltro(DataFilterDTO dataFiltro) {
		this.dataFiltro = dataFiltro;
	}

	public List<TipsterEntity> getTipsterList() {
		return tipsterList;
	}

	public void setTipsterList(List<TipsterEntity> tipsterList) {
		this.tipsterList = tipsterList;
	}

	public TipsterEntity getTipsterSelecionado() {
		return tipsterSelecionado;
	}

	public void setTipsterSelecionado(TipsterEntity tipsterSelecionado) {
		this.tipsterSelecionado = tipsterSelecionado;
	}
	
}
