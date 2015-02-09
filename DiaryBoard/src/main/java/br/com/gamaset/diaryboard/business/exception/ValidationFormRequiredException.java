package br.com.gamaset.diaryboard.business.exception;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class ValidationFormRequiredException extends ValidationFormAbstractException {

	private static final long serialVersionUID = 8705252009811865635L;

	public ValidationFormRequiredException(String campo) {
		super("O campo " + campo + " � obrigat�rio.");
	}
	
}
