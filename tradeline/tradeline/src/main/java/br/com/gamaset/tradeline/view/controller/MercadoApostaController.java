package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.MercadoApostaEntity;
import br.com.gamaset.tradeline.model.MercadoApostaSelecaoEntity;
import br.com.gamaset.tradeline.view.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class MercadoApostaController extends AbstractController{

	private final String TELA_MERCADOAPOSTA_LIST = "/content/mercadoaposta/mercadoaposta-list.xhtml";
	private final String TELA_MERCADOAPOSTA_EDIT = "/content/mercadoaposta/mercadoaposta-edit.xhtml";
	
	private List<MercadoApostaSelecaoEntity> listaMercadoSelecao;
	private List<MercadoApostaEntity> entities;
	private MercadoApostaEntity mercadoApostaCadastrar;
	
	@Override
	public String iniciarTela() {
		entities = mercadoApostaService.listarTodos();
		
		return TELA_MERCADOAPOSTA_LIST;
	}
	
	public String navegarInserirMercado(){
		mercadoApostaCadastrar = new MercadoApostaEntity();
		listaMercadoSelecao = mercadoApostaSelecaoService.listarTodos();
		mercadoApostaCadastrar.setSelecao(listaMercadoSelecao.get(0));
		
		return TELA_MERCADOAPOSTA_EDIT;
	}
	
	public String navegarEditarMercado(MercadoApostaEntity editar){
		mercadoApostaCadastrar = editar;
		listaMercadoSelecao = mercadoApostaSelecaoService.listarTodos();
		
		return TELA_MERCADOAPOSTA_EDIT;
	}
	
	public String salvar(){
		
		try{
			if (mercadoApostaCadastrar.getId() == null) {
				mercadoApostaService.adicionarEntidade(mercadoApostaCadastrar);
			}else{
				mercadoApostaService.editarEntidade(mercadoApostaCadastrar);
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
		}
		
		return iniciarTela();
	}

	public List<MercadoApostaEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<MercadoApostaEntity> entities) {
		this.entities = entities;
	}

	public MercadoApostaEntity getMercadoApostaCadastrar() {
		return mercadoApostaCadastrar;
	}

	public void setMercadoApostaCadastrar(MercadoApostaEntity mercadoApostaCadastrar) {
		this.mercadoApostaCadastrar = mercadoApostaCadastrar;
	}

	public List<MercadoApostaSelecaoEntity> getListaMercadoSelecao() {
		return listaMercadoSelecao;
	}

	public void setListaMercadoSelecao(List<MercadoApostaSelecaoEntity> listaMercadoSelecao) {
		this.listaMercadoSelecao = listaMercadoSelecao;
	}
	
	
}
