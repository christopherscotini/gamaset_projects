package br.com.gamaset.tradeline.view.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.tradeline.dto.PlanoJogoDetalheDTO;
import br.com.gamaset.tradeline.exception.BusinessException;
import br.com.gamaset.tradeline.model.PlanoJogoEntity;
import br.com.gamaset.tradeline.model.PlanoJogoItemEntity;
import br.com.gamaset.tradeline.view.utils.FacesUtils;


@ManagedBean
@SessionScoped
public class PlanoJogoBean extends AbstractController{

	private final String TELA_PLANOJOGO_LIST = PATH_PAGES+"/planojogo/planojogo-list.xhtml";
	private final String TELA_PLANOJOGO_EDIT= PATH_PAGES+"/planojogo/planojogo-edit.xhtml";
	private final String TELA_PLANOJOGO_ACOMPANHAMENTO= PATH_PAGES+"/planojogo/planojogo-acompanhamento.xhtml";
	private final String TELA_PLANOJOGO_DETALHE= PATH_PAGES+"/planojogo/planojogo-detalhe.xhtml";
	
	private PlanoJogoEntity planoJogoCadastrar;
	private List<PlanoJogoEntity> entities;
	private PlanoJogoItemEntity planoJogoItem;
	private PlanoJogoDetalheDTO planoJogoDetalheDto;
	
	public PlanoJogoBean() {

	}
	
	@Override
	public String iniciarTela() {
		try{entities = planoJogoService.listarTodos();}catch(BusinessException ignore){}
		
		return TELA_PLANOJOGO_LIST;
	}
	
	public String navegarEditar(PlanoJogoEntity selected){
		planoJogoCadastrar = selected;
		
		
		return TELA_PLANOJOGO_EDIT;
	}

	public void navegarExcluir(PlanoJogoEntity selected){
		planoJogoService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		planoJogoCadastrar = new PlanoJogoEntity();
		planoJogoCadastrar.setAtivo(true);
		
		
		return TELA_PLANOJOGO_EDIT;
	}
	
	public String salvar(){
		try{
			if(planoJogoCadastrar.getId() == null){
				planoJogoService.adicionarEntidade(planoJogoCadastrar);
			}else{
				planoJogoService.editarEntidade(planoJogoCadastrar);
			}
		}catch(BusinessException b){
			FacesUtils.addErrorMessage(b.getMessage());
			return "";
		}
		
		return iniciarTela();
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
	
	

	
}
