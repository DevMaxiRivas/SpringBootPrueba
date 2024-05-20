package com.spring.prueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Clase Manejadora de Errores de Rutas
@RestControllerAdvice
public class RutasHandller {

    private final Logger logger = LoggerFactory.getLogger(RutasHandller.class);


    // Todo requesta que genere un INTERNAL_SERVER_ERROR la enviara al cliente en el body "Internal Error, Contact Support."
    // Y mostrara el origen de la excepcion por los logs de consola
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNullPointer(NullPointerException exception){
        logger.debug(exception.getMessage());
        return "Internal Error, Contact Support.";
    }

}
