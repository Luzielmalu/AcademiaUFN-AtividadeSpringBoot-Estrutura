package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jpa.model.Cliente;
import com.example.jpa.repository.ClienteRepository;

@SpringBootApplication
public class JpaApplication {

	 private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner demo(ClienteRepository repository) {
		
		return (args) -> {
			
			  repository.save(new Cliente(null, "Lavinia", "Silva"));
		      repository.save(new Cliente(null, "Vinicius", "Costa"));
		      repository.save(new Cliente(null, "Paula", "Oliveira"));
		      repository.save(new Cliente(null, "David", "Melo"));
		      repository.save(new Cliente(null, "Jucelio", "Cunha"));
		      repository.save(new Cliente(null, "Layla", "Freitas"));
		      
		      log.info("Clientes econtrados com findAll():");
		      log.info("-------------------------------");
		      repository.findAll().forEach(cliente -> {
		        log.info(cliente.toString());
		      });
		      log.info("");
		      
		      Cliente cliente = repository.findById(1L);
		      log.info("Cliente encontrado com findById(1L):");
		      log.info("--------------------------------");
		      log.info(cliente.toString());
		      log.info("");
		      
		      log.info("Cliente encontrado com findByUltimoNome('Cunha'):");
		      log.info("--------------------------------------------");
		      repository.findByUltimoNome("Cunha").forEach(cunha -> {
		        log.info(cunha.toString());
		      });
		      log.info("");
		};
		
	}

}
