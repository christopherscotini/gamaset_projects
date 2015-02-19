package br.com.gamaset.diaryboard.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.exception.BusinessException;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;


@ManagedBean
@SessionScoped
public class PlanoJogoBean extends BeanModel{

	private final String TELA_CONSULTAR_PLANOJOGO = "/content/pages/planojogo/planojogo-list.xhtml";
	private final String TELA_CADASTRAR_PLANOJOGO= "/content/pages/planojogo/planojogo-edit.xhtml";
	private final String TELA_CONSULTAR_ITEM_PLANOJOGO= "/content/pages/planojogo/planojogo-acompanhamento.xhtml";
	
	private PlanoJogoEntity planoJogoCadastrar;
	private List<PlanoJogoEntity> entities;
	private PlanoJogoItemEntity planoJogoItem;
	
	public PlanoJogoBean() {

	}
	
	@Override
	public String iniciarTela() {
		entities = planoJogoService.listarTodos();
		return TELA_CONSULTAR_PLANOJOGO;
	}
	
	public String navegarEditar(CampeonatoEntity selected){
		
		return TELA_CADASTRAR_PLANOJOGO;
	}

	public void navegarExcluir(CampeonatoEntity selected){

		iniciarTela();
	}
	
	public String navegarCadastrar(){
		planoJogoCadastrar = new PlanoJogoEntity();
		
		
		return TELA_CADASTRAR_PLANOJOGO;
	}
	
	public String salvar(){
		try{
			if(planoJogoCadastrar.getId() == null){
				planoJogoService.adicionarEntidade(planoJogoCadastrar);
			}else{
				planoJogoService.editarEntidade(planoJogoCadastrar);
			}
		}catch(BusinessException b){

			return "";
		}
		
		return iniciarTela();
	}
	
	
	public String navegarVisualizarPlanoJogo(PlanoJogoEntity selected){
		planoJogoCadastrar = selected;
		
		planoJogoCadastrar.setApostas(planoJogoItemService.buscarPorPlanoJogoId(selected));
		
		return TELA_CONSULTAR_ITEM_PLANOJOGO;
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
	
	

	
}
