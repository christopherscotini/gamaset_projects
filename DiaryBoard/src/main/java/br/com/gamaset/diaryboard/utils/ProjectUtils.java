package br.com.gamaset.diaryboard.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.com.gamaset.diaryboard.model.EventoEntity;
import br.com.gamaset.diaryboard.model.PlanoJogoItemEntity;
import br.com.gamaset.diaryboard.model.ApostaResultadoEnum;

public class ProjectUtils {

	public static String genEventDescription(EventoEntity evento) {
		return evento.getDescTimeCasa()+" vs "+evento.getDescTimeVisitante();
	}
	
	public static void calcularValoresAcompanhamento(PlanoJogoItemEntity p, ApostaResultadoEnum resultadoEntityEnum){
		if(resultadoEntityEnum.equals(ApostaResultadoEnum.AINDA_POR_ACONTECER)){
			p.setVlrFinalDia(p.getVlrFinalDia().subtract(p.getVlrBetDia()));
			p.setPercObjetivoConcluidoDia(p.getVlrFinalDia().divide(p.getVlrFinalDiaObjetivo(), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN));
		}else{
			if(resultadoEntityEnum.equals(ApostaResultadoEnum.PERDEU)){
				
			}else{
				//soma
			}
		}
//		e.setVlrLucroDia(BigDecimal.ZERO);
//		e.setPercLucroDia(percLucroDia);
//		e.setPercLucroMeta(percLucroMeta);
//		e.setVlrTotalGanhoDia(vlrTotalGanhoDia);
//		e.setVlrTotalPerdidoDia(vlrTotalPerdidoDia);
	}
	
}
