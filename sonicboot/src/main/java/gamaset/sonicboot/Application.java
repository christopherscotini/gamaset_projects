package gamaset.sonicboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gamaset.sonicboot.scrapper.AcademiaDasApostasScrapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
