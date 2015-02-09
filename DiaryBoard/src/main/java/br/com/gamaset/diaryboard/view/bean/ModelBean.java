package br.com.gamaset.diaryboard.view.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import br.com.gamaset.diaryboard.exception.BusinessException;
import br.com.gamaset.diaryboard.model.CampeonatoEntity;
import br.com.gamaset.diaryboard.model.FlagEntity;


@ManagedBean
@SessionScoped
public class ModelBean extends BeanModel{

	private final String TELA_CONSULTAR_XXXX= "/content/pages/aposta_campeonato/consultar_campeonato.xhtml";
	private final String TELA_CADASTRAR_XXXX= "/content/pages/aposta_campeonato/cadastrar_campeonato.xhtml";
	
	private List<CampeonatoEntity>entities;
	private CampeonatoEntity campeonatoCadastrar;
	
	public ModelBean() {

	}
	
	@Override
	public String iniciarTela() {
		
		return TELA_CONSULTAR_XXXX;
	}
	
	public String navegarEditar(CampeonatoEntity selected){
		campeonatoCadastrar = selected;
		
		return TELA_CADASTRAR_XXXX;
	}

	public void navegarExcluir(CampeonatoEntity selected){
		campeonatoCadastrar = selected;
		campeonatoService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		campeonatoCadastrar = new CampeonatoEntity();
		
		return TELA_CADASTRAR_XXXX;
	}
	
	public String salvar(){
		try{
			if(campeonatoCadastrar.getId() == null){
				campeonatoService.adicionarEntidade(campeonatoCadastrar);
			}else{
				campeonatoService.editarEntidade(campeonatoCadastrar);
			}
		}catch(BusinessException b){
			System.out.println(b.getMessage());
		}
		
		return iniciarTela();
	}
	
	
	
/* -------------------------------------------------------- */	

	public List<CampeonatoEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<CampeonatoEntity> entities) {
		this.entities = entities;
	}

	public CampeonatoEntity getCampeonatoCadastrar() {
		return campeonatoCadastrar;
	}

	public void setCampeonatoCadastrar(CampeonatoEntity campeonatoCadastrar) {
		this.campeonatoCadastrar = campeonatoCadastrar;
	}

	
}
