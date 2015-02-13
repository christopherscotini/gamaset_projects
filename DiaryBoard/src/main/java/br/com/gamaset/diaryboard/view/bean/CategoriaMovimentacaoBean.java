package br.com.gamaset.diaryboard.view.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.model.financas.CategoriaMovimentacaoEntity;


@ManagedBean
@SessionScoped
public class CategoriaMovimentacaoBean extends BeanModel{

	private final String TELA_CONSULTAR_CATEGORIA_MOVIMENTACAO = "/content/navbar/financaspessoais/categoriamovimentacao/consultar_categoriamovimentacao.xhtml";
	private final String TELA_CADASTRAR_CATEGORIA_MOVIMENTACAO = "/content/navbar/financaspessoais/categoriamovimentacao/cadastrar_categoriamovimentacao.xhtml";
	
	private List<CategoriaMovimentacaoEntity>data;
	private CategoriaMovimentacaoEntity categoriaCadastro;
	
	public CategoriaMovimentacaoBean() {
		data = new ArrayList<CategoriaMovimentacaoEntity>();
		data.add(new CategoriaMovimentacaoEntity(1L, "Gastos Pessoais"));
		data.add(new CategoriaMovimentacaoEntity(2L, "Gastos com Refeição"));
		data.add(new CategoriaMovimentacaoEntity(3L, "Gastos com Viagens"));
		data.add(new CategoriaMovimentacaoEntity(4L, "Gastos com Educação"));
	}
	
	
	@Override
	public String iniciarTela() {
		
		return TELA_CONSULTAR_CATEGORIA_MOVIMENTACAO;
	}

	
	public String navegarCadastrar(){
		categoriaCadastro = new CategoriaMovimentacaoEntity();
		
		return TELA_CADASTRAR_CATEGORIA_MOVIMENTACAO;
	}
	
	
	public String salvar(){
		
		data.add(categoriaCadastro);
		
		return iniciarTela();
	}
	
	
	
	
	public List<CategoriaMovimentacaoEntity> getData() {
		return data;
	}

	public void setData(List<CategoriaMovimentacaoEntity> data) {
		this.data = data;
	}


	public CategoriaMovimentacaoEntity getCategoriaCadastro() {
		return categoriaCadastro;
	}


	public void setCategoriaCadastro(CategoriaMovimentacaoEntity categoriaCadastro) {
		this.categoriaCadastro = categoriaCadastro;
	}
	

	
	
	
}
