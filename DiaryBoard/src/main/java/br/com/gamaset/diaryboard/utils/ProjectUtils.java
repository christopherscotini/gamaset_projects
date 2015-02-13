package br.com.gamaset.diaryboard.utils;

import br.com.gamaset.diaryboard.model.EventoEntity;

public class ProjectUtils {

	public static String genEventDescription(EventoEntity evento) {
		return evento.getDescTimeCasa()+" vs "+evento.getDescTimeVisitante();
	}
	
}
