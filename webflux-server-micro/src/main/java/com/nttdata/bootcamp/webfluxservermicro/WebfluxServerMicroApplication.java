package com.nttdata.bootcamp.webfluxservermicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class WebfluxServerMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxServerMicroApplication.class, args);
	}

}
