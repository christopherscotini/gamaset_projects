import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class Teste {

	public static void main(String[] args) {
		BigDecimal d1 = new BigDecimal("1000.00").divide(new BigDecimal("1300.00"), MathContext.DECIMAL128).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_EVEN);

		System.out.println(d1);
	}

}
