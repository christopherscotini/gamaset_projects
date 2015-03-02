package br.com.gamaset.diaryboard.view.bean;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.dto.PlanoJogoDetalheDTO;
import br.com.gamaset.diaryboard.exception.BusinessException;
import br.com.gamaset.diaryboard.model.ApostaEntity;
import br.com.gamaset.diaryboard.model.BetEntity;
import br.com.gamaset.diaryboard.model.CaixaApostaTipoMovEnum;
import br.com.gamaset.diaryboard.model.CaixaApostasEntity;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.model.EventoEntity;
import br.com.gamaset.diaryboard.model.MercadoApostaEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.model.TipsterEntity;
import br.com.gamaset.diaryboard.repository.ApostaRepository;
import br.com.gamaset.diaryboard.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class PlanoJogoBean extends BeanModel{

	private final String TELA_PLANOJOGO_LIST = "/content/pages/planojogo/planojogo-list.xhtml";
	private final String TELA_PLANOJOGO_EDIT= "/content/pages/planojogo/planojogo-edit.xhtml";
	private final String TELA_PLANOJOGO_ACOMPANHAMENTO= "/content/pages/planojogo/planojogo-acompanhamento.xhtml";
	private final String TELA_PLANOJOGO_DETALHE= "/content/pages/planojogo/planojogo-detalhe.xhtml";
	private final String TELA_PLANOJOGO_APOSTA_EDIT= "/content/pages/planojogo/planojogo_aposta-edit.xhtml";
	
	private PlanoJogoEntity planoJogoCadastrar;
	private List<PlanoJogoEntity> entities;
	private PlanoJogoItemEntity planoJogoItem;
	private PlanoJogoDetalheDTO planoJogoDetalheDto;
	
	private ApostaEntity apostaCadastrar;
	private List<CampeonatoEntity>campeonatoList;
	private List<MercadoApostaEntity> mercadosList;
	private List<TipsterEntity> tipsterList;
	private List<PlanoJogoItemEntity> planoJogoItemList;
	private BigDecimal valorApostaSugerido;
	
	
	
	public PlanoJogoBean() {

	}
	
	@Override
	public String iniciarTela() {
		try{entities = planoJogoService.listarTodos();}catch(BusinessException ignore){}
		
		return TELA_PLANOJOGO_LIST;
	}
	
	public String navegarEditar(PlanoJogoEntity selected){
		
		return TELA_PLANOJOGO_EDIT;
	}

	public void navegarExcluir(PlanoJogoEntity selected){
		planoJogoService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		
		if(caixaApostasService.verificarSaldoDisponivelParaInvestimento()==null || (caixaApostasService.verificarSaldoDisponivelParaInvestimento().compareTo(BigDecimal.ZERO) <= 0)){
			FacesUtils.addErrorMessage("Não há saldo para iniciar um plano de jogo.");
			return "";
		}
		planoJogoCadastrar = new PlanoJogoEntity();
		
		return TELA_PLANOJOGO_EDIT;
	}
	
	public String salvar(){
		try{
			if(planoJogoCadastrar.getId() == null){
				planoJogoService.adicionarEntidade(planoJogoCadastrar);
				caixaApostasService.adicionarEntidade(generateCaixaAtivo());
			}else{
				if(planoJogoService.buscarPorId(planoJogoCadastrar.getId()).isAtivo() && !planoJogoCadastrar.isAtivo()){
					planoJogoService.editarEntidade(planoJogoCadastrar);
					caixaApostasService.adicionarEntidade(generateCaixaFinalizado());
				}else{
					planoJogoService.editarEntidade(planoJogoCadastrar);
				}
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		return iniciarTela();
	}
	
	private CaixaApostasEntity generateCaixaAtivo(){
		CaixaApostasEntity c = new CaixaApostasEntity();
		c.setDataMovimentacao(new Date());
		c.setTipoMovimentacaoEnum(CaixaApostaTipoMovEnum.SAIDA_PLANO);
		c.setValorMovimentacao(planoJogoCadastrar.getValorInvestimentoInicial());
		return c;
	}

	private CaixaApostasEntity generateCaixaFinalizado(){
		CaixaApostasEntity c = new CaixaApostasEntity();
		c.setDataMovimentacao(new Date());
		c.setTipoMovimentacaoEnum(CaixaApostaTipoMovEnum.ENTRADA_PLANO);
		List<PlanoJogoItemEntity> itens = planoJogoItemService.buscarPorPlanoJogoId(planoJogoCadastrar.getId());
		c.setValorMovimentacao(itens.get(itens.size()-1).getVlrFinalDia());
		return c;
	}
	
	public String navegarPlanoJogoDetalhe(PlanoJogoEntity selected){
		planoJogoCadastrar = selected;
		planoJogoDetalheDto = planoJogoService.detalharPlanoJogo(planoJogoCadastrar);
		
		return TELA_PLANOJOGO_DETALHE;
	}	
	
	
	public String navegarPlanoJogoAcompanhamento(PlanoJogoEntity selected){
		planoJogoCadastrar = selected;
		planoJogoCadastrar.setApostas(planoJogoItemService.buscarPorPlanoJogoId(planoJogoCadastrar.getId()));
		
		return TELA_PLANOJOGO_ACOMPANHAMENTO;
	}
	
	
	public String navegarVoltarTelaPlanojogoAcompanhamento(){
		
		return TELA_PLANOJOGO_ACOMPANHAMENTO;
	}
	
	public String navegarCadastrarAposta(){
		initApostaEntityObj();
		campeonatoList = campeonatoService.listarTodos();
		mercadosList = mercadoApostaService.listarTodos();
		tipsterList = tipsterService.listarTodos();
		apostaCadastrar.getBet().setCampeonato(campeonatoList.get(0));
		apostaCadastrar.getBet().getEvento().setMercado(mercadosList.get(0));
		apostaCadastrar.setTipster(tipsterList.get(0));
		apostaCadastrar.setResultado(getResultadoApostaList().get(0));
		onchangePlanojogoCombo();
		
		
		return TELA_PLANOJOGO_APOSTA_EDIT;
	}
	
	public String salvarAposta(){
		try{
			apostaCadastrar.setTicket(new Date().getTime()+"");
			apostaService.adicionarEntidade(apostaCadastrar);
			planoJogoCadastrar = planoJogoService.buscarPorId(apostaCadastrar.getPlanoJogoItem().getPlanoJogo().getId());
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		return navegarPlanoJogoAcompanhamento(planoJogoCadastrar);
		
	}	
	
	public void onchangePlanojogoCombo(){
		planoJogoItemList = planoJogoItemService.buscarPorPlanoJogoId(planoJogoCadastrar.getId());
		for (int i = 0; i < planoJogoItemList.size(); i++) {
			if(!planoJogoItemList.get(i).isFinalizado()){
				apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(i));
				break;
			}else{
				apostaCadastrar.setPlanoJogoItem(planoJogoItemList.get(planoJogoItemList.size()-1));
			}
		}
		
		onchangePlanojogoItemCombo();
	}

	public void onchangePlanojogoItemCombo(){
		valorApostaSugerido = apostaCadastrar.getPlanoJogoItem().getVlrBetDia();
	}
	
	public void calculaValorOdd(){
		if((apostaCadastrar.getValorAposta() != null && apostaCadastrar.getValorAposta().compareTo(BigDecimal.ZERO) > 0) && apostaCadastrar.getValorRetorno() != null){
			apostaCadastrar.getBet().getEvento().setOdd(apostaCadastrar.getValorRetorno().divide(apostaCadastrar.getValorAposta(), MathContext.DECIMAL128).setScale(3, RoundingMode.CEILING));
		}else{
			apostaCadastrar.getBet().getEvento().setOdd(null);
		}
	}
	
	private void initApostaEntityObj() {
		apostaCadastrar = new ApostaEntity();
		apostaCadastrar.setBet(new BetEntity());
		apostaCadastrar.setTipster(new TipsterEntity());
		apostaCadastrar.setDataAposta(new Date());
		apostaCadastrar.setStatusResolvida(false);
		apostaCadastrar.setValorAposta(null);
		apostaCadastrar.setValorRetorno(null);
		apostaCadastrar.setResultado(null);
		apostaCadastrar.getBet().setCampeonato(new CampeonatoEntity());
		apostaCadastrar.getBet().setEvento(new EventoEntity());
		apostaCadastrar.getBet().getEvento().setMercado(new MercadoApostaEntity());
//		apostaCadastrar.getBet().getEvento().setResultado(null);
		apostaCadastrar.getBet().getEvento().setOdd(null);
	}

	public PlanoJogoEntity getPlanoJogoCadastrar() {
		return planoJogoCadastrar;
	}

	public void setPlanoJogoCadastrar(PlanoJogoEntity planoJogoCadastrar) {
		this.planoJogoCadastrar = planoJogoCadastrar;
	}

	public List<PlanoJogoEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<PlanoJogoEntity> entities) {
		this.entities = entities;
	}

	public PlanoJogoItemEntity getPlanoJogoItem() {
		return planoJogoItem;
	}

	public void setPlanoJogoItem(PlanoJogoItemEntity planoJogoItem) {
		this.planoJogoItem = planoJogoItem;
	}

	public PlanoJogoDetalheDTO getPlanoJogoDetalheDto() {
		return planoJogoDetalheDto;
	}

	public void setPlanoJogoDetalheDto(PlanoJogoDetalheDTO planoJogoDetalheDto) {
		this.planoJogoDetalheDto = planoJogoDetalheDto;
	}

	public ApostaEntity getApostaCadastrar() {
		return apostaCadastrar;
	}

	public void setApostaCadastrar(ApostaEntity apostaCadastrar) {
		this.apostaCadastrar = apostaCadastrar;
	}

	public List<CampeonatoEntity> getCampeonatoList() {
		return campeonatoList;
	}

	public void setCampeonatoList(List<CampeonatoEntity> campeonatoList) {
		this.campeonatoList = campeonatoList;
	}

	public List<MercadoApostaEntity> getMercadosList() {
		return mercadosList;
	}

	public void setMercadosList(List<MercadoApostaEntity> mercadosList) {
		this.mercadosList = mercadosList;
	}

	public List<TipsterEntity> getTipsterList() {
		return tipsterList;
	}

	public void setTipsterList(List<TipsterEntity> tipsterList) {
		this.tipsterList = tipsterList;
	}

	public BigDecimal getValorApostaSugerido() {
		return valorApostaSugerido;
	}

	public void setValorApostaSugerido(BigDecimal valorApostaSugerido) {
		this.valorApostaSugerido = valorApostaSugerido;
	}

	public List<PlanoJogoItemEntity> getPlanoJogoItemList() {
		return planoJogoItemList;
	}

	public void setPlanoJogoItemList(List<PlanoJogoItemEntity> planoJogoItemList) {
		this.planoJogoItemList = planoJogoItemList;
	}

	
}
