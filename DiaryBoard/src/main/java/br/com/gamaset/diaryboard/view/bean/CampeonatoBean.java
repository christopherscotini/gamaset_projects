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
public class CampeonatoBean extends BeanModel{

	private final String TELA_CONSULTAR_CAMPEONATOS= "/content/pages/aposta_campeonato/campeonato-list.xhtml";
	private final String TELA_CADASTRAR_CAMPEONATOS= "/content/pages/aposta_campeonato/campeonato-edit.xhtml";
	
	private List<CampeonatoEntity>entities;
	private CampeonatoEntity campeonatoCadastrar;
	private List<FlagEntity>flags;
	
	public CampeonatoBean() {

	}
	
	@Override
	public String iniciarTela() {
		entities = campeonatoService.listarTodos();
		campeonatoCadastrar = null;
		
		return TELA_CONSULTAR_CAMPEONATOS;
	}
	
	public String navegarEditar(CampeonatoEntity selected){
		campeonatoCadastrar = selected;
		flags = flagService.listarTodos();
		campeonatoCadastrar.setFlag(campeonatoCadastrar.getFlag());
		
		return TELA_CADASTRAR_CAMPEONATOS;
	}

	public void navegarExcluir(CampeonatoEntity selected){
		campeonatoCadastrar = selected;
		campeonatoService.excluirEntidade(selected);
		iniciarTela();
	}
	
	public String navegarCadastrar(){
		campeonatoCadastrar = new CampeonatoEntity();
		flags = flagService.listarTodos();
		campeonatoCadastrar.setFlag(flags.get(0));
		
//		try {
//			listarFlags();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
		return TELA_CADASTRAR_CAMPEONATOS;
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
	
	
	private void listarFlags() throws IOException { 
		File file = new File("C:\\Users\\christopher.rozario\\Desktop\\flags"); 
		File afile[] = file.listFiles(); 
		for (int j = 0; j < afile.length; j++) {
			File arquivos = afile[j]; 
			FlagEntity f = new FlagEntity();
			f.setNomeCompeticao(arquivos.getName().substring(0, arquivos.getName().lastIndexOf(".")));
			f.setNomeImagem(arquivos.getName());
			f = flagService.adicionarEntidade(f);
			f.setUrlImagem("/resources/images/flags/"+f.getId()+".gif");
			flagService.editarEntidade(f);
			copiar(arquivos, f.getId().toString());
		}
	}
	
	private void copiar(File arquivoOrigem, String urlNovoArq) throws FileNotFoundException{
		FacesContext aFacesContext = FacesContext.getCurrentInstance();
        ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
		FileInputStream origem = new FileInputStream(arquivoOrigem);//arquivo que você quer copiar 
		FileOutputStream destino = new FileOutputStream("C:\\Users\\christopher.rozario\\git\\meusprojetos\\DiaryBoard\\src\\main\\webapp\\resources\\images\\flags\\"+urlNovoArq+".gif");//onde irá ficar a copia do aquivo  
			  
        FileChannel fcOrigem = origem.getChannel();  
        FileChannel fcDestino = destino.getChannel();  
        try {
			fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
			origem.close();  
			destino.close();  
		} catch (IOException e) {
			e.printStackTrace();
		} 
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

	public List<FlagEntity> getFlags() {
		return flags;
	}

	public void setFlags(List<FlagEntity> flags) {
		this.flags = flags;
	}

	
}
