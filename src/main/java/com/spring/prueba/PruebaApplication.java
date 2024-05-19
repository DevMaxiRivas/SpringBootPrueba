package com.spring.prueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {

	private static Logger logger = LoggerFactory.getLogger(PruebaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);

		logger.debug("Mi mensaje debug");	// Por defecto es invisible para la consola por ello se modifica aplicacion.yml
		logger.error("Mi mensaje Error");
	}

}
