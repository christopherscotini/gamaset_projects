package br.com.gamaset.diaryboard.view.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gamaset.diaryboard.Mock;
import br.com.gamaset.diaryboard.dto.CreditoMensalDTO;
import br.com.gamaset.diaryboard.model.financas.MovimentacaoEntity;


@ManagedBean
@SessionScoped
public class CreditosMovimentacaoBean extends BeanModel{

	private final String TELA_CONSULTAR_FINANCAS_PESSOAIS = "/content/navbar/financaspessoais/creditosmovimentacao/consultar_creditomovimentacao.xhtml";
	
	private List<MovimentacaoEntity>data;
	private MovimentacaoEntity movimentacaoCadastro;
	
	public CreditosMovimentacaoBean() {
		movimentacaoCadastro = new MovimentacaoEntity();
	}
	
	@Override
	public String iniciarTela() {
		data = new ArrayList<MovimentacaoEntity>();
		for (int i = 0; i < 20; i++) {
			data.add(Mock.gerarMovimentacao());
		}
		
		return TELA_CONSULTAR_FINANCAS_PESSOAIS;
	}

	
	public List<MovimentacaoEntity> getData() {
		return data;
	}

	public void setData(List<MovimentacaoEntity> data) {
		this.data = data;
	}


	public MovimentacaoEntity getMovimentacaoCadastro() {
		return movimentacaoCadastro;
	}


	public void setMovimentacaoCadastro(MovimentacaoEntity movimentacaoCadastro) {
		this.movimentacaoCadastro = movimentacaoCadastro;
	}

	
	
	
}
