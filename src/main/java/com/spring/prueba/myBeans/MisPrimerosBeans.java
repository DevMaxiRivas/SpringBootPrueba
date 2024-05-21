package com.spring.prueba.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Con esta anotacion declaramos que esta va a ser una clase que contiene declaraciones de beans
@Configuration
public class MisPrimerosBeans {

//    Con esta anotacion Spring Boot sabe que tiene que ejecutar este metodo al momento del startup
//    y el objeto se encapsulara como otro bean
    @Bean
    MiBean crearMiBean(){
        return new MiBean();
    }

}
