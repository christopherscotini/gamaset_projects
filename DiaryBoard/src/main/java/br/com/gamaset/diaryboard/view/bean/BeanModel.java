package br.com.gamaset.diaryboard.view.bean;

import javax.inject.Inject;

import br.com.gamaset.diaryboard.business.bo.ApostaService;
import br.com.gamaset.diaryboard.business.bo.CampeonatoService;
import br.com.gamaset.diaryboard.business.bo.FlagService;
import br.com.gamaset.diaryboard.business.bo.MercadoApostaService;

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

}
