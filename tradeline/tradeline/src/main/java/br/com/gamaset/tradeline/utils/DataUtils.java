package br.com.gamaset.tradeline.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public static String converterDataString(Date data, String mascara) {

		String dataFormatada;
		SimpleDateFormat df = new SimpleDateFormat(mascara);
		dataFormatada = df.format(data);

		return dataFormatada;
	}

	// Devolve a data passada como Integer no formato da mascara
	// ex: 26/01/2011, yyyyMMdd -> 20110126
	public static Integer converterDataInteger(Date data, String mascara) {

		String dt = converterDataString(data, mascara);

		return Integer.parseInt(dt);
	}

	// Devolve a data passada como Long no formato de mascara
	// ex: 26/01/2011, yyyyMMdd -> 20110126
	public static Long converterDataLong(Date data, String mascara) {

		String dt = converterDataString(data, mascara);

		return Long.parseLong(dt);

	}

	// Retorna o dia da data em formato String
	public static String extrairDiaData(Date data) {

		Calendar date = Calendar.getInstance();

		if (data != null) {

			date.setTime(data);

			return preencherZerosAEsquerda(String.valueOf(date.get(Calendar.DATE)), 2);
		} else {

			return "";
		}

	}

	// Retorna o mï¿½s da data em formato String
	public static String extrairMesData(Date data) {
		Calendar date = Calendar.getInstance();

		if (data != null) {
			date.setTime(data);
			return preencherZerosAEsquerda(String.valueOf(date.get(Calendar.MONTH) + 1), 2);
		} else {
			return "";
		}

	}
	
	public static String extrairMesDataNome(Date data, boolean abreviado){
		    String[] meses = {"Janeiro", "Fevereiro", "MarÃ§o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};  
		    String[] mesesAbr = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};  
		    
		    Calendar date = Calendar.getInstance();

			if (data != null) {
				date.setTime(data);
				if (abreviado) {
					return mesesAbr[date.get(Calendar.MONTH)];
				}else{
					return meses[date.get(Calendar.MONTH)];
				}
			} else {
				return "";
			}
	}

	// Retorna o ano da data em formato String
	public static String extrairAnoData(Date data) {

		Calendar date = Calendar.getInstance();

		if (data != null) {

			date.setTime(data);

			return String.valueOf(date.get(Calendar.YEAR));
		} else {
			return "";
		}

	}

	// Retorna o dia da data em formato Integer
	public static Integer extrairDiaDataInteiro(Date data) {

		Calendar date = Calendar.getInstance();

		if (data != null) {
			date.setTime(data);
			return date.get(Calendar.DATE);
		} else {

			return 0;

		}

	}

	// Retorna o mï¿½s da data em formato Integer
	public static Integer extrairMesDataInteiro(Date data) {

		Calendar date = Calendar.getInstance();

		if (data != null) {
			date.setTime(data);
			return date.get(Calendar.MONTH) + 1;
		} else {

			return 0;

		}

	}

	// Retorna o ano da data em formato Integer
	public static Integer extrairAnoDataInteiro(Date data) {

		Calendar date = Calendar.getInstance();

		if (data != null) {
			date.setTime(data);
			return date.get(Calendar.YEAR);
		} else {

			return 0;

		}

	}

	/**
	 * Concatena dia(Integer), mï¿½s(Integer) e ano (Integer) e tem como retono uma String.
	 * 
	 * @param dia
	 *            Deve ser passado o dia em inteiro para a formataï¿½ï¿½o
	 * @param mes
	 *            Deve ser passado o mï¿½s em inteiro para a formataï¿½ï¿½o
	 * @param ano
	 *            Deve ser passado o ano em inteiro para a formataï¿½ï¿½o
	 * @param formatacao
	 *            Deve ser passado a String que serï¿½ utilizada como formataï¿½ï¿½o da data
	 * @return data formatada em String
	 */

	public static String concatenaDatas(Integer dia, Integer mes, Integer ano, String formatacao) {

		if (dia == null || mes == null || ano == null) {
			return "";

		} else {

			String diaString = preencherZerosAEsquerda(String.valueOf(dia), 2);
			String mesString = preencherZerosAEsquerda(String.valueOf(mes), 2);
			String anoString = preencherZerosAEsquerda(String.valueOf(ano), 4);

			StringBuilder concatena = new StringBuilder(diaString);

			concatena.append(mesString);
			concatena.append(anoString);

			concatena.insert(2, formatacao);
			concatena.insert(5, formatacao);

			return String.valueOf(concatena);
		}
	}

	/**
	 * Concatena dia, mï¿½s e ano do formato DATE e converte para inteiro.
	 * 
	 * @param data
	 *            Deve ser passado a data no formato DATE para a formataï¿½ï¿½o.
	 * @return data formatada em inteiro.
	 */

	public static Integer extrairDataInteiro(Date data) {

		Calendar calendario = Calendar.getInstance();

		calendario.setTime(data);

		int dia = calendario.get(Calendar.DATE);
		int mes = calendario.get(Calendar.MONTH) + 1;
		int ano = calendario.get(Calendar.YEAR);

		StringBuilder stringBuilder = new StringBuilder(preencherZerosAEsquerda(String.valueOf(dia), 2));
		stringBuilder.append(preencherZerosAEsquerda(String.valueOf(mes), 2));
		stringBuilder.append(preencherZerosAEsquerda(String.valueOf(ano), 4));

		return Integer.parseInt(stringBuilder.toString());
	}

	/**
	 * Concatena dia, mï¿½s e ano do formato STRING e converte para inteiro.
	 * 
	 * @param data
	 *            Deve ser passado uma data no formato String.
	 * @param formatador
	 *            Deve ser passado o formatador da data.
	 * @return data formatada em Inteiro.
	 */

	public static Integer extrairDataString(String data, String formatador) {

		if (data == null) {
			return 0;
		}

		if (data.indexOf(formatador) == -1) {
			return 0;
		}

		String[] dataFormatada = data.split(formatador);

		StringBuilder stringBuilder = new StringBuilder(preencherZerosAEsquerda(dataFormatada[0], 2));
		stringBuilder.append(preencherZerosAEsquerda(dataFormatada[1], 2));
		stringBuilder.append(preencherZerosAEsquerda(dataFormatada[2], 4));

		return Integer.parseInt(stringBuilder.toString());
	}

	/**
	 * 
	 * @param data
	 *            Deve ser passado uma data no formato Integer.
	 * @param mascara
	 *            Deve ser passado a mï¿½scara utilizada para formatar a data.
	 * @return data formatada em String.
	 */
	public static String extrairDataFormatada(Integer data, String mascara) {

		if (data == null || data.toString().length() > 8) {
			return "";
		}

		String dataFinal = preencherZerosAEsquerda(data.toString(), 8);

		StringBuilder calendario = new StringBuilder(dataFinal);

		calendario.insert(2, mascara);
		calendario.insert(5, mascara);

		return calendario.toString();
	}

	/**
	 * 
	 * @param hora
	 *            Deve ser passada uma hora no formato Integer.
	 * @param mascara
	 *            Deve ser passado a mï¿½scara utilizada para formatar a hora, ex: ":".
	 * @return hora formatada em String.
	 */
	public static String extrairHoraFormatada(Integer hora, String mascara) {
		if (hora == null || hora.toString().length() > 6) {
			return "";
		}

		StringBuilder horaFormatada = new StringBuilder(hora.toString());

		horaFormatada.insert(2, mascara);
		horaFormatada.insert(5, mascara);

		return horaFormatada.toString();
	}

	public static String preencherZerosAEsquerda(String campo, int tamanhoMaximo) {
		StringBuilder sb = new StringBuilder(addZero(campo, tamanhoMaximo));
		return sb.toString();

	}

	public static String replaceAll(String sourceText, String find, String replacement) {
		String value = sourceText;
		while (value.indexOf(find) != -1) {
			value = value.replace(find, replacement);
		}
		return value;
	}

	private static String addZero(String vr, int size) {
		StringBuilder resultado = new StringBuilder();
		int vrLength = vr.length();
		if (vrLength <= size) {
			int dif = size - vrLength;
			for (int i = 0; i < dif; i++) {
				resultado.append("0");
			}
			return resultado.append(vr).toString();
		} else {
			return vr;
			// throw new IllegalArgumentException("Valor maior que o intervalo informado.");
		}
	}

}
