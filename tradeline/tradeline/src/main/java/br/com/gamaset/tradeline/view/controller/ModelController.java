package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.CompeticaoEntity;


@ManagedBean
@SessionScoped
public class ModelController extends AbstractController{

	private final String TELA_XXXX_LIST= "/content/pages/aposta_campeonato/consultar_campeonato.xhtml";
	private final String TELA_XXXX_EDIT= "/content/pages/aposta_campeonato/cadastrar_campeonato.xhtml";
	
	private List<CompeticaoEntity>entities;
	private CompeticaoEntity competicaoCadastrar;
	
	public ModelController() {

	}
	
	@Override
	public String iniciarTela() {
		
		return TELA_XXXX_LIST;
	}
	
	public String navegarEditar(CompeticaoEntity selected){
		competicaoCadastrar = selected;
		
		return TELA_XXXX_EDIT;
	}

	public void navegarExcluir(CompeticaoEntity selected){
		competicaoCadastrar = selected;
		competicaoService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		competicaoCadastrar = new CompeticaoEntity();
		
		return TELA_XXXX_EDIT;
	}
	
	public String salvar(){
		try{
			if(competicaoCadastrar.getId() == null){
				competicaoService.adicionarEntidade(competicaoCadastrar);
			}else{
				competicaoService.editarEntidade(competicaoCadastrar);
			}
		}catch(BusinessException b){
			System.out.println(b.getMessage());
		}
		
		return iniciarTela();
	}

	
	
/* -------------------------------------------------------- */	

	public List<CompeticaoEntity> getEntities() {
		return entities;
	}
	
	public void setEntities(List<CompeticaoEntity> entities) {
		this.entities = entities;
	}

	public CompeticaoEntity getCompeticaoCadastrar() {
		return competicaoCadastrar;
	}

	public void setCompeticaoCadastrar(CompeticaoEntity competicaoCadastrar) {
		this.competicaoCadastrar = competicaoCadastrar;
	}
	
	
}
