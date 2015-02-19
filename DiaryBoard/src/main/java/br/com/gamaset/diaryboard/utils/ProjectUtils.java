package br.com.gamaset.diaryboard.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.com.gamaset.diaryboard.model.EventoEntity;

public class ProjectUtils {

	public static String genEventDescription(EventoEntity evento) {
		return evento.getDescTimeCasa()+" vs "+evento.getDescTimeVisitante();
	}
	
	public static void calcularValoresAcompanhamento(){
//		e.setVlrLucroDia(BigDecimal.ZERO);
//		e.setPercObjetivoConcluidoDia(e.getVlrFinalDia().divide(e.getVlrFinalDiaObjetivo(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
//		e.setPercLucroDia(percLucroDia);
//		e.setPercLucroMeta(percLucroMeta);
//		e.setVlrTotalGanhoDia(vlrTotalGanhoDia);
//		e.setVlrTotalPerdidoDia(vlrTotalPerdidoDia);
	}
	
}
