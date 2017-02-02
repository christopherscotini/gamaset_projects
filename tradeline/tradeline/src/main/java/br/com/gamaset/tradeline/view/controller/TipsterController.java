package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;
import br.com.gamaset.tradeline.model.TipsterEntity;


@ManagedBean
@SessionScoped
public class TipsterController extends AbstractController{

	private final String TELA_TIPSTER_LIST= "/content/tipster/tipster-list.xhtml";
	private final String TELA_TIPSTER_EDIT= "/content/tipster/tipster-edit.xhtml";
	
	private List<TipsterEntity>entities;
	private TipsterEntity tipsterCadastrar;
	
	public TipsterController() {

	}
	
	@Override
	public String iniciarTela() {
		
		entities = tipsterService.listarTodos();
		
		return TELA_TIPSTER_LIST;
	}
	
	public String navegarEditar(TipsterEntity selected){
		tipsterCadastrar = selected;
		
		return TELA_TIPSTER_EDIT;
	}

	public void navegarExcluir(TipsterEntity selected){
		tipsterCadastrar = selected;
		tipsterService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		tipsterCadastrar = new TipsterEntity();
		
		return TELA_TIPSTER_EDIT;
	}
	
	public String salvar(){
		try{
			if(tipsterCadastrar.getId() == null){
				tipsterService.adicionarEntidade(tipsterCadastrar);
			}else{
				tipsterService.editarEntidade(tipsterCadastrar);
			}
		}catch(BusinessException b){
			System.out.println(b.getMessage());
		}
		
		return iniciarTela();
	}

	
	/* -------------------------------------------------------- */	

	public List<TipsterEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<TipsterEntity> entities) {
		this.entities = entities;
	}

	public TipsterEntity getTipsterCadastrar() {
		return tipsterCadastrar;
	}

	public void setTipsterCadastrar(TipsterEntity tipsterCadastrar) {
		this.tipsterCadastrar = tipsterCadastrar;
	}

	
	

	
}
