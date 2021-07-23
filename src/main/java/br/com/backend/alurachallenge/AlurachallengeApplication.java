package br.com.backend.alurachallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.backend.alurachallenge.database.Db;

@SpringBootApplication
@EnableSpringDataWebSupport
public class AlurachallengeApplication {

	public static void main(String[] args) {
		
		Db db = new Db();
		
		db.getConnection();
		
		SpringApplication.run(AlurachallengeApplication.class, args);
	}

}
