package br.com.gamaset.diaryboard.view.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class FinancasPessoaisBean extends BeanModel{

	private final String TELA_CONSULTAR_FINANCAS_PESSOAIS = "/content/navbar/financaspessoais/consultar_financaspessoais.xhtml";
	
	@Override
	public String iniciarTela() {
		
		return TELA_CONSULTAR_FINANCAS_PESSOAIS;
	}

	
	
	
}
