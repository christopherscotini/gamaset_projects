package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.view.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class MercadoApostaSelecaoController extends AbstractController{

	private final String TELA_MERCADOAPOSTASELECAO_LIST = "/content/mercadoapostaselecao/mercadoapostaselecao-list.xhtml";
	private final String TELA_MERCADOAPOSTASELECAO_EDIT = "/content/mercadoapostaselecao/mercadoapostaselecao-edit.xhtml";
	
	private List<MercadoApostaSelecaoEntity> entities;
	private MercadoApostaSelecaoEntity mercadoApostaSelecaocadastrar;
	
	@Override
	public String iniciarTela() {
		entities = mercadoApostaSelecaoService.listarTodos();
		
		return TELA_MERCADOAPOSTASELECAO_LIST;
	}	
	
	public String navegarInserirMercadoSelecao(){
		mercadoApostaSelecaocadastrar = new MercadoApostaSelecaoEntity();
		
		
		return TELA_MERCADOAPOSTASELECAO_EDIT;
	}
	
	public String navegarEditarMercadoSelecao(MercadoApostaSelecaoEntity editar){
		mercadoApostaSelecaocadastrar = editar;
		
		return TELA_MERCADOAPOSTASELECAO_EDIT;
	}
	
	public String salvar(){
		
		try{
			if (mercadoApostaSelecaocadastrar.getId() == null) {
				mercadoApostaSelecaoService.adicionarEntidade(mercadoApostaSelecaocadastrar);
			}else{
				mercadoApostaSelecaoService.editarEntidade(mercadoApostaSelecaocadastrar);
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
		}
		
		return iniciarTela();
	}

	public MercadoApostaSelecaoEntity getMercadoApostaSelecaocadastrar() {
		return mercadoApostaSelecaocadastrar;
	}

	public void setMercadoApostaSelecaocadastrar(
			MercadoApostaSelecaoEntity mercadoApostaSelecaocadastrar) {
		this.mercadoApostaSelecaocadastrar = mercadoApostaSelecaocadastrar;
	}

	public List<MercadoApostaSelecaoEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<MercadoApostaSelecaoEntity> entities) {
		this.entities = entities;
	}
	
}
