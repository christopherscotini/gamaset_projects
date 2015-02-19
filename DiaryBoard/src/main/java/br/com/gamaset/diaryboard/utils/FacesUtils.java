package br.com.gamaset.diaryboard.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class FacesUtils {

	private FacesUtils() {
		super();
	}

	public static void addMessageInclusaoSucesso() {
		addInfoMessage(getMsgs("generico.mensagem.inclusosucesso").concat("."));
	}

	public static void addMessageAlteracaoSucesso() {
		addInfoMessage(getMsgs("generico.mensagem.alteracaosucesso").concat("."));
	}
	
	public static void addMessageExclusaoSucesso() {
		addInfoMessage(getMsgs("generico.mensagem.exclusaosucesso").concat("."));
	}

	public static void addErrorMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, msg);
	}

	public static void addInfoMessage(String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, msg);
	}

	private static void addMessage(FacesMessage.Severity severity, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, msg));
	}
	
	private static String getMsgs(String messageId) {    
        FacesContext facesContext = FacesContext.getCurrentInstance();    
        String msg = "";    
        Locale locale = facesContext.getViewRoot().getLocale();    
        ResourceBundle bundle = ResourceBundle.getBundle("br.com.gamaset.diaryboard.view.bundle.Messages", locale);    
        try {    
            msg = bundle.getString(messageId);    
        } catch (Exception e) {    
        }    
        return msg;    
    }  
}
