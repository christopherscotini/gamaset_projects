package br.com.gamaset.diaryboard.view.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.ApostaService;
import br.com.gamaset.diaryboard.business.bo.CampeonatoService;
import br.com.gamaset.diaryboard.business.bo.FlagService;
import br.com.gamaset.diaryboard.business.bo.MercadoApostaService;
import br.com.gamaset.diaryboard.business.bo.PlanoJogoItemService;
import br.com.gamaset.diaryboard.business.bo.PlanoJogoService;
import br.com.gamaset.diaryboard.business.bo.TipsterService;
import br.com.gamaset.diaryboard.model.ResultadoEntityEnum;

public abstract class BeanModel {
	
	public abstract String iniciarTela();
	
	@Inject
	protected FlagService flagService = null;
	@Inject
	protected CampeonatoService campeonatoService = null;
	@Inject
	protected ApostaService apostaService = null;
	@Inject
	protected MercadoApostaService mercadoApostaService = null;
	@Inject
	protected TipsterService tipsterService = null;
	@Inject
	protected PlanoJogoService planoJogoService = null;
	@Inject
	protected PlanoJogoItemService planoJogoItemService = null;

	
	
	public List<ResultadoEntityEnum> getResultadoApostaList() {
		return new ArrayList<ResultadoEntityEnum>(
				Arrays.asList(ResultadoEntityEnum.values()));
	} 
	
}
