package br.com.gamaset.diaryboard.business.exception;

import javax.ejb.ApplicationException;

import br.com.gamaset.diaryboard.exception.BusinessException;

@ApplicationException(rollback=true)
public class NoDataFoundException extends BusinessException {

	private static final long serialVersionUID = 5077420954080626074L;

	public NoDataFoundException(String registro) {
		super("Não foram encontrados "+registro );		
	}
}
