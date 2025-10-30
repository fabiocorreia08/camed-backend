package br.com.camed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.camed")
public class CamedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamedApplication.class, args);
	}

}
