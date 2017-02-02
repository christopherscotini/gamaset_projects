package br.com.gamaset.tradeline.view.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.gamaset.tradeline.business.bo.ApostaService;
import br.com.gamaset.tradeline.business.bo.CaixaApostasService;
import br.com.gamaset.tradeline.business.bo.CompeticaoService;
import br.com.gamaset.tradeline.business.bo.JogosDiaService;
import br.com.gamaset.tradeline.business.bo.MercadoApostaSelecaoService;
import br.com.gamaset.tradeline.business.bo.MercadoApostaService;
import br.com.gamaset.tradeline.business.bo.PaisService;
import br.com.gamaset.tradeline.business.bo.PalpiteEstatisticaPorMercadoService;
import br.com.gamaset.tradeline.business.bo.PalpiteService;
import br.com.gamaset.tradeline.business.bo.PlanoJogoItemService;
import br.com.gamaset.tradeline.business.bo.PlanoJogoService;
import br.com.gamaset.tradeline.business.bo.TimeService;
import br.com.gamaset.tradeline.business.bo.TimeUnionService;
import br.com.gamaset.tradeline.business.bo.TipsterService;
import br.com.gamaset.tradeline.business.bo.goal.CompeticaoGoalService;
import br.com.gamaset.tradeline.business.bo.goal.TimeGoalService;
import br.com.gamaset.tradeline.business.bo.prosoccer.CompeticaoPSService;
import br.com.gamaset.tradeline.business.bo.prosoccer.TimePSService;
import br.com.gamaset.tradeline.model.ApostaResultadoEnum;


public abstract class AbstractController {
	
	protected final String PATH_PAGES = "/content";
	
	@Inject
	protected MercadoApostaSelecaoService mercadoApostaSelecaoService = null;
	@Inject
	protected MercadoApostaService mercadoApostaService = null;
	@Inject
	protected PaisService paisService = null;
	@Inject
	protected CompeticaoPSService competicaoPSService = null;
	@Inject
	protected CompeticaoGoalService competicaoGoalService = null;
	@Inject
	protected CompeticaoService competicaoService = null;
	@Inject
	protected TimeGoalService timeGoalService = null;
	@Inject
	protected TimePSService timePSService = null;
	@Inject
	protected TimeService timeService = null;
	@Inject
	protected TipsterService tipsterService = null;
	@Inject
	protected TimeUnionService timeUnionService = null;
	@Inject
	protected PalpiteService palpiteService = null;
	@Inject
	protected JogosDiaService jogosDiaService = null;
	@Inject
	protected CaixaApostasService caixaApostasService = null;
	@Inject
	protected ApostaService apostaService = null;
	@Inject
	protected PlanoJogoService planoJogoService = null;
	@Inject
	protected PlanoJogoItemService planoJogoItemService = null;
	@Inject
	protected PalpiteEstatisticaPorMercadoService palpiteEstatisticaPorMercadoService;
	
	public abstract String iniciarTela();
	
	public List<ApostaResultadoEnum> getApostaResultadoList() {
		return new ArrayList<ApostaResultadoEnum>(
				Arrays.asList(ApostaResultadoEnum.values()));
	} 
	
	
	public static String getMsgs(String messageId) {    
        FacesContext facesContext = FacesContext.getCurrentInstance();    
        String msg = "";    
        Locale locale = facesContext.getViewRoot().getLocale();    
        ResourceBundle bundle = ResourceBundle.getBundle("br.com.gamaset.tradeline.view.bundle.Messages", locale);    
        try {    
            msg = bundle.getString(messageId);    
        } catch (Exception e) {    
        }    
        return msg;    
    }  
	
	public BigDecimal getSaldoGeral(){
		return caixaApostasService.getSaldoDisponivel();
	}
	
}
