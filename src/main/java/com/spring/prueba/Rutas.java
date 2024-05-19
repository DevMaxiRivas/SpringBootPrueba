package com.spring.prueba;

import com.spring.prueba.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {
    private static Logger logger = LoggerFactory.getLogger(PruebaApplication.class);

    @GetMapping("/")
    String miPrimeraRuta(){
        return "Hola mundo desde Spring Controller";
    }
    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibros(@PathVariable int id, @PathVariable String editorial){
        return "Leyendo el id: "+ id + " con editorial " + editorial;
    }
    @GetMapping("/libro/{id}")
    String leerLibros2(@PathVariable int id, @RequestParam String editorial){
        return "Leyendo el id: "+ id + " con editorial " + editorial;
    }

//    Mapeando con Map = Diccionario
//    @PostMapping("/libro")
//    String guardarLibro(@RequestBody Map<String,Object> libro){
//        libro.keySet().forEach(key -> {
//            logger.debug("Llave: " + key + " Valor: " + libro.get(key));
//        });
//        return "Libro Guardado";
//    }

 // Mapeando definiendo una clase
    @PostMapping("/libro")
    String guardarLibro(@RequestBody Libro libro){
        logger.debug("Llave: " + libro.nombre  + " Valor: " + libro.editorial);
        return "Libro Guardado";
    }

    // Responder cambiando status https
    @GetMapping("/saludar")
    // Ver en Postman el archivo json que entrega al intentar acceder a la ruta
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY,reason = "Ruta movida a la versión 2 de la API")
    String miSegundaRutaconStatus(){
        return "Aprendiendo statuses http en Spring Boot ";
    }

}
