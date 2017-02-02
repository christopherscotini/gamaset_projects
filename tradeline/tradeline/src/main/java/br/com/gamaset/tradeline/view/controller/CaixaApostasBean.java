package br.com.gamaset.tradeline.view.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CaixaApostaTipoMovEnum;
import br.com.gamaset.tradeline.model.CaixaApostasEntity;
import br.com.gamaset.tradeline.utils.ProjectUtils;
import br.com.gamaset.tradeline.view.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class CaixaApostasBean extends AbstractController{

	private final String TELA_CAIXAAPOSTAS_LIST = PATH_PAGES.concat("/caixa/caixaapostas-list.xhtml");
	private final String TELA_CAIXAAPOSTAS_EDIT = PATH_PAGES.concat("/caixa/caixaapostas-edit.xhtml");
	private final String TELA_CAIXAAPOSTAS_DET = PATH_PAGES.concat("/caixa/caixaapostas-det.xhtml");
	
	private List<CaixaApostaTipoMovEnum>cboTipoMovimentacao;
	private List<CaixaApostasEntity>entities;
	private CaixaApostasEntity caixaApostasCadastrar;
	
	@Override
	public String iniciarTela() {
		entities = caixaApostasService.listarTodos();
		
		return TELA_CAIXAAPOSTAS_LIST;
	}

	public String navegarEditar(CaixaApostasEntity selected) {
		caixaApostasCadastrar = selected;
		if(caixaApostasCadastrar.getTipoMovimentacaoEnum().equals(CaixaApostaTipoMovEnum.DEPOSITO) || caixaApostasCadastrar.getTipoMovimentacaoEnum().equals(CaixaApostaTipoMovEnum.SAQUE)){
			cboTipoMovimentacao = new ArrayList<CaixaApostaTipoMovEnum>();
			cboTipoMovimentacao.add(CaixaApostaTipoMovEnum.DEPOSITO);
			cboTipoMovimentacao.add(CaixaApostaTipoMovEnum.SAQUE);
		}else{
			cboTipoMovimentacao = new ArrayList<CaixaApostaTipoMovEnum>(Arrays.asList(CaixaApostaTipoMovEnum.values()));
		}
		
		return TELA_CAIXAAPOSTAS_EDIT;
	}

	public String navegarCadastrar() {
		caixaApostasCadastrar = new CaixaApostasEntity();
		cboTipoMovimentacao = new ArrayList<CaixaApostaTipoMovEnum>();
		cboTipoMovimentacao.add(CaixaApostaTipoMovEnum.DEPOSITO);
		BigDecimal val = caixaApostasService.verificarSaldoDisponivelParaInvestimento();
		if(ProjectUtils.verificaBigDecimalNulo(val).compareTo(BigDecimal.ZERO) > 0){
			cboTipoMovimentacao.add(CaixaApostaTipoMovEnum.SAQUE);
		}
		
		return TELA_CAIXAAPOSTAS_EDIT;
	}

	public String salvar() {

		try{
			if(caixaApostasCadastrar.getId() == null){
				caixaApostasService.adicionarEntidade(caixaApostasCadastrar);
			}else{
				caixaApostasService.editarEntidade(caixaApostasCadastrar);
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		return iniciarTela();
	}

	
	
	public List<CaixaApostasEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<CaixaApostasEntity> entities) {
		this.entities = entities;
	}

	public CaixaApostasEntity getCaixaApostasCadastrar() {
		return caixaApostasCadastrar;
	}

	public void setCaixaApostasCadastrar(CaixaApostasEntity caixaApostasCadastrar) {
		this.caixaApostasCadastrar = caixaApostasCadastrar;
	}

	public List<CaixaApostaTipoMovEnum> getCboTipoMovimentacao() {
		return cboTipoMovimentacao;
	}

	public void setCboTipoMovimentacao(List<CaixaApostaTipoMovEnum> cboTipoMovimentacao) {
		this.cboTipoMovimentacao = cboTipoMovimentacao;
	}

}
