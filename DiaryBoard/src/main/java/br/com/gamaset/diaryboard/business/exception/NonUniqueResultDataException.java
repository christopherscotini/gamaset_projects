package br.com.gamaset.diaryboard.business.exception;

import javax.ejb.ApplicationException;

import br.com.gamaset.diaryboard.exception.BusinessException;

@ApplicationException(rollback=true)
public class NonUniqueResultDataException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public NonUniqueResultDataException(String registro) {
		super(registro + " já está cadastrado(a).");
	}
}
