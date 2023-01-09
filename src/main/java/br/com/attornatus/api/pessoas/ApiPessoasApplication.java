package br.com.attornatus.api.pessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPessoasApplication.class, args);
	}
}
