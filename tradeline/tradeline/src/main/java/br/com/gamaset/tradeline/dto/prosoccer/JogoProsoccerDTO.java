package br.com.gamaset.tradeline.dto.prosoccer;

import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;

public class JogoProsoccerDTO {
	
	private CompeticaoUnionEntity competicao;
	private TimeUnionEntity timeCasa;
	private TimeUnionEntity timeVisitante;
	private Integer probabilidadeCasa;
	private Integer probabilidadeEmpate;
	private Integer probabilidadeFora;
	private PalpiteEnun palpite;
	
	public JogoProsoccerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public JogoProsoccerDTO(CompeticaoUnionEntity competicao,
			TimeUnionEntity timeCasa, TimeUnionEntity timeVisitante,
			Integer probabilidadeCasa, Integer probabilidadeEmpate,
			Integer probabilidadeFora, PalpiteEnun palpite) {
		super();
		this.competicao = competicao;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.probabilidadeCasa = probabilidadeCasa;
		this.probabilidadeEmpate = probabilidadeEmpate;
		this.probabilidadeFora = probabilidadeFora;
		this.palpite = palpite;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(competicao.getCompeticaoProsoccer().getCodigoDescricao()).append(" | ");
		str.append(timeCasa.getTimeProsoccer().getDescricao()).append(" ")
		.append("x").append(" ")
		.append(timeVisitante.getTimeProsoccer().getDescricao()).append(" | ");
		
		return str.toString();
	}


	public CompeticaoUnionEntity getCompeticao() {
		return competicao;
	}
	public void setCompeticao(CompeticaoUnionEntity competicao) {
		this.competicao = competicao;
	}
	public TimeUnionEntity getTimeCasa() {
		return timeCasa;
	}
	public void setTimeCasa(TimeUnionEntity timeCasa) {
		this.timeCasa = timeCasa;
	}
	public TimeUnionEntity getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(TimeUnionEntity timeVisitante) {
		this.timeVisitante = timeVisitante;
	}


	public Integer getProbabilidadeCasa() {
		return probabilidadeCasa;
	}


	public void setProbabilidadeCasa(Integer probabilidadeCasa) {
		this.probabilidadeCasa = probabilidadeCasa;
	}


	public Integer getProbabilidadeEmpate() {
		return probabilidadeEmpate;
	}


	public void setProbabilidadeEmpate(Integer probabilidadeEmpate) {
		this.probabilidadeEmpate = probabilidadeEmpate;
	}


	public Integer getProbabilidadeFora() {
		return probabilidadeFora;
	}


	public void setProbabilidadeFora(Integer probabilidadeFora) {
		this.probabilidadeFora = probabilidadeFora;
	}


	public PalpiteEnun getPalpite() {
		return palpite;
	}


	public void setPalpite(PalpiteEnun palpite) {
		this.palpite = palpite;
	}
	
	
}
