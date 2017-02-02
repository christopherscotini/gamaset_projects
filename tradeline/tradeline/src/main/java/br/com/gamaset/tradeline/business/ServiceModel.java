package br.com.gamaset.tradeline.business;

import java.util.List;

import br.com.gamaset.tradeline.business.exception.ValidationFormAbstractException;


public interface ServiceModel<T> {

	public List<T> listarTodos();
	T adicionarEntidade(T entidade);
	T editarEntidade(T entidade);
	void excluirEntidade(T entidade);
	void validateForm(T entidade) throws ValidationFormAbstractException;
	
}
