package br.com.gamaset.tradeline.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;

public class TradelineUtils {

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
	
	public static void authProxy() {
//		final String authUser = "christopher.rozario";
//		final String authPassword = "#ctr376704";
//
//		Authenticator.setDefault(new Authenticator() {
//			public PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(authUser, authPassword
//						.toCharArray());
//			}
//		});
//
//		System.setProperty("http.proxyHost", "10.100.10.11");
//		System.setProperty("http.proxyPort", "8080");
	}
	
	public static BigDecimal dividirBigDecimal(BigDecimal divisor, BigDecimal dividendo) {
		BigDecimal ret = BigDecimal.ZERO;
		try{
			ret = divisor.divide(dividendo, MathContext.DECIMAL128);
		}catch(ArithmeticException a){
			
		}
		return ret;
	}
    
	
}
