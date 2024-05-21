package com.spring.prueba.servicios;

import com.spring.prueba.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


// Esta anotacion le dice a Spring Boot que este es un servicio y que debe generar una instancia de él
// Y lo va a utilizar esa instancia en todo aquel servicio o clase que haga uso de esta clase
@Service
public class OrderService {

    // Logger
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(List<Producto> productos){
        System.out.println("Guardando en la base de datos...");
        // Iterando sobre los elementos de la lista
        productos.forEach(producto -> logger.debug("El nombre del producto: {}", producto.nombre));
    }
}
