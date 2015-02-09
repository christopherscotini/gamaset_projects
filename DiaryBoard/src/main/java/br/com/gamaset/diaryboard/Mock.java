package br.com.gamaset.diaryboard;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import br.com.gamaset.diaryboard.model.CategoriaMovimentacaoEntity;
import br.com.gamaset.diaryboard.model.MovimentacaoEntity;
import br.com.gamaset.diaryboard.model.TipoMovimentacaoEntity;

public class Mock {
	
	public static TipoMovimentacaoEntity gerarTipoMovimentacao(){
		TipoMovimentacaoEntity ent = new TipoMovimentacaoEntity();
		ent.setId(Long.valueOf(generateRandomNumber()));
		if(ent.getId() %2 ==0){
			ent.setDescricao("Crédito");
		}else{
			ent.setDescricao("Débito");
		}
		return ent;
	}
	
	public static CategoriaMovimentacaoEntity gerarCategoriaEntity(){
		CategoriaMovimentacaoEntity ent = new CategoriaMovimentacaoEntity();
		ent.setId(Long.valueOf(generateRandomNumber()));
		if(ent.getId() %2 ==0){
			ent.setDescricao("Pessoal");
		}else{
			ent.setDescricao("Viagens");
		}
		return ent;
		
	}
	
	
	public static MovimentacaoEntity gerarMovimentacao(){
		return new MovimentacaoEntity(Long.valueOf(generateRandomNumber()),
				"Posto Halluck", new Date(), new BigDecimal("1524.00"),
				gerarTipoMovimentacao(), gerarCategoriaEntity());
	}
	
	
	private static Integer generateRandomNumber(){
		return new Random().nextInt(1001);
	}

}
