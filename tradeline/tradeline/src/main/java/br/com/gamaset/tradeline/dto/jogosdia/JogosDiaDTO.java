package br.com.gamaset.tradeline.dto.jogosdia;

import java.util.Date;
import java.util.List;

public class JogosDiaDTO {

	private List<JogoDiaDTO> jogos;
	private Date dataJogos;

	public List<JogoDiaDTO> getJogos() {
		return jogos;
	}

	public void setJogos(List<JogoDiaDTO> jogos) {
		this.jogos = jogos;
	}

	public Date getDataJogos() {
		return dataJogos;
	}

	public void setDataJogos(Date dataJogos) {
		this.dataJogos = dataJogos;
	}
}
