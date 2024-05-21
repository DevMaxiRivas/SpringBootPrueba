package com.spring.prueba.myBeans;

import org.springframework.stereotype.Component;

@Component
public class MiComponente {
    public void saludarDesdeComponente(){
        System.out.println("Saludando desde mi primer componente");
    }
}
