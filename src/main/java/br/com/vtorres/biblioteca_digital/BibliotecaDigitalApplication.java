package br.com.vtorres.biblioteca_digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.vtorres.biblioteca_digital.repositories")
@EntityScan("br.com.vtorres.biblioteca_digital.entities")
public class BibliotecaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaDigitalApplication.class, args);
	}

}
