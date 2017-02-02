package br.com.gamaset.tradeline.dto;

import java.util.Calendar;
import java.util.Date;

public class DataFilterDTO {

	private Date dataInicio;
	private Date dataFinal;
	
	public DataFilterDTO() {
		dataInicio = null;
		dataFinal = null;
	}

	public DataFilterDTO(boolean inicializaFiltroMes) {
		if (inicializaFiltroMes) {
			iniciaFiltroMes();
		}else{
			dataInicio = null;
			dataFinal = null;
		}
	}
	
	public void iniciaFiltroMes(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		dataInicio = cal.getTime();
		dataFinal = new Date();
	}
	
	public DataFilterDTO(Date dataInicio, Date dataFinal) {
		super();
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}


	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
	
}
