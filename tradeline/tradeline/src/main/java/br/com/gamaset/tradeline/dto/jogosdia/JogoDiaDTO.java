package br.com.gamaset.tradeline.dto.jogosdia;

import br.com.gamaset.tradeline.dto.prosoccer.JogoProsoccerDTO;
import br.com.gamaset.tradeline.model.depara.CompeticaoUnionEntity;
import br.com.gamaset.tradeline.model.depara.TimeUnionEntity;

public class JogoDiaDTO {

	private TimeUnionEntity timeCasa;
	private Integer placarTimeCasa;
	private TimeUnionEntity timeVisitante;
	private Integer placarTimeVisitante;
	private CompeticaoUnionEntity competicao; 
	private String status;// hora inicicar;minuto de jogo;Fim Jogo
	private String urlDetalhePartidaGoal;
	
	//caso exista analise no prosoccer
	private JogoProsoccerDTO jogoProsoccer;
	
	
	public TimeUnionEntity getTimeCasa() {
		return timeCasa;
	}
	public void setTimeCasa(TimeUnionEntity timeCasa) {
		this.timeCasa = timeCasa;
	}
	public Integer getPlacarTimeCasa() {
		return placarTimeCasa;
	}
	public void setPlacarTimeCasa(Integer placarTimeCasa) {
		this.placarTimeCasa = placarTimeCasa;
	}
	public TimeUnionEntity getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(TimeUnionEntity timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public Integer getPlacarTimeVisitante() {
		return placarTimeVisitante;
	}
	public void setPlacarTimeVisitante(Integer placarTimeVisitante) {
		this.placarTimeVisitante = placarTimeVisitante;
	}
	public CompeticaoUnionEntity getCompeticao() {
		return competicao;
	}
	public void setCompeticao(CompeticaoUnionEntity competicao) {
		this.competicao = competicao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrlDetalhePartidaGoal() {
		return urlDetalhePartidaGoal;
	}
	public void setUrlDetalhePartidaGoal(String urlDetalhePartidaGoal) {
		this.urlDetalhePartidaGoal = urlDetalhePartidaGoal;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(status).append(" | ");
		str.append(timeCasa.getTimeGoal().getDescricao()).append(" ").append(placarTimeCasa==null?"":placarTimeCasa).append(" ").append("x").append(" ").append(placarTimeVisitante==null?"":placarTimeVisitante).append(" ").append(timeVisitante.getTimeGoal().getDescricao()).append(" | ");
		
		return str.toString();
	}
	public JogoProsoccerDTO getJogoProsoccer() {
		return jogoProsoccer;
	}
	public void setJogoProsoccer(JogoProsoccerDTO jogoProsoccer) {
		this.jogoProsoccer = jogoProsoccer;
	}
	
}
