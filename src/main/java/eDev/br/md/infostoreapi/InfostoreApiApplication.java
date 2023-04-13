package eDev.br.md.infostoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;

@SpringBootApplication
public class InfostoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfostoreApiApplication.class, args);
	}

}
