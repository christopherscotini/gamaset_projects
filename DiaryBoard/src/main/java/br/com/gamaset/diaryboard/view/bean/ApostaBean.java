package br.com.gamaset.diaryboard.view.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.exception.BusinessException;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.BetEntity;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.model.EventoEntity;
import br.com.gamaset.diaryboard.model.FlagEntity;
import br.com.gamaset.diaryboard.model.MercadoApostaEntity;
import br.com.gamaset.diaryboard.model.ResultadoEntityEnum;


@ManagedBean
@SessionScoped
public class ApostaBean extends BeanModel{

	private final String TELA_APOSTA_LIST= "/content/pages/aposta/aposta-list.xhtml";
	private final String TELA_APOSTA_EDIT= "/content/pages/aposta/aposta-edit.xhtml";
	
	private List<ApostaEntity>entities;
	private ApostaEntity apostaCadastrar;
	private List<FlagEntity>flags;
	private List<MercadoApostaEntity> mercados;
	
	
	public ApostaBean() {

	}
	
	@Override
	public String iniciarTela() {
		
		return TELA_APOSTA_LIST;
	}
	
	public String navegarEditar(ApostaEntity selected){
		apostaCadastrar = selected;
		
		return TELA_APOSTA_EDIT;
	}

	public void navegarExcluir(ApostaEntity selected){
		apostaService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		initApostaEntityObj();
		flags = flagService.listarTodos();
		mercados = mercadoApostaService.listarTodos();
		apostaCadastrar.getBet().getCampeonato().setImg(flags.get(0));
		apostaCadastrar.getBet().getEvento().setMercado(mercados.get(0));
		
		
		return TELA_APOSTA_EDIT;
	}
	
	public String salvar(){
		try{
			if(apostaCadastrar.getId() == null){
				apostaService.adicionarEntidade(apostaCadastrar);
			}else{
				apostaService.editarEntidade(apostaCadastrar);
			}
		}catch(BusinessException b){
			System.out.println(b.getMessage());
		}
		
		return iniciarTela();
	}

	private void initApostaEntityObj() {
		apostaCadastrar = new ApostaEntity();
		apostaCadastrar.setBet(new BetEntity());
		apostaCadastrar.setDataBet(new Date());
		apostaCadastrar.setStatusResolvida(false);
		apostaCadastrar.setValorAposta(BigDecimal.ZERO);
		apostaCadastrar.setValorRetorno(BigDecimal.ZERO);
		apostaCadastrar.getBet().setCampeonato(new CampeonatoEntity());
		apostaCadastrar.getBet().getCampeonato().setImg(new FlagEntity());
		apostaCadastrar.getBet().setEvento(new EventoEntity());
		apostaCadastrar.getBet().getEvento().setMercado(new MercadoApostaEntity());
		apostaCadastrar.getBet().getEvento().setResultado(null);
	}
	
	/* -------------------------------------------------------- */	
	public List<ApostaEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<ApostaEntity> entities) {
		this.entities = entities;
	}

	public ApostaEntity getApostaCadastrar() {
		return apostaCadastrar;
	}

	public void setApostaCadastrar(ApostaEntity apostaCadastrar) {
		this.apostaCadastrar = apostaCadastrar;
	}

	public List<MercadoApostaEntity> getMercados() {
		return mercados;
	}

	public void setMercados(List<MercadoApostaEntity> mercados) {
		this.mercados = mercados;
	}

	public List<FlagEntity> getFlags() {
		return flags;
	}

	public void setFlags(List<FlagEntity> flags) {
		this.flags = flags;
	}
	
	
}
