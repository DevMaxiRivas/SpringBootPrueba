package com.spring.prueba;

import com.spring.prueba.models.Libro;
import com.spring.prueba.models.Producto;
import com.spring.prueba.models.UserData;
import com.spring.prueba.myBeans.MiBean;
import com.spring.prueba.myBeans.MiComponente;
import com.spring.prueba.servicios.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class Rutas {

//    Servicios (De esta manera se genera una dependencia dura)
//    private OrderService orderService = new OrderService();

//    Servicios (aplicando dependencia dinamcia)
    private OrderService orderService;
//    hacemos uso del bean que creamos
    private MiBean miBean;
//    hacemos uso del componente que cramos
//    inyeccion de dependencia por atributo con la anotacion
    @Autowired
    private MiComponente miComponente;

//    inyeccion de depencia clasica por constructor (forma prefente)
    public Rutas(OrderService orderService, MiBean miBean){
        this.orderService = orderService;
        this.miBean = miBean;
    }

    // Logger
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

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar){
        if (lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, oveja");
        } else {
            if (lugar.equals("selva")){
                return ResponseEntity.status(HttpStatus.OK).body("Mono, Gorila, Puma");
            } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar Invalido");
        }
    }

    // Ejemplo generando una excepcion (error) en la parte del servidor, que muestra al cliene datos que no deberia

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero){
        throw new NullPointerException("La clave del es usuario user123, password 123 y no deberia poder leerse en el postman");
    }

    // Enviar JSONs
    @GetMapping("/userData")
    public ResponseEntity<String> getUserData(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type","aplication/json")
                .body("{\"name\" = \"marie\" }");
    }

    // Ventaja no es necesario definir los headers
    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2(){
        return Map.of("user",Map.of("name","marry", "age", 25));
    }

    // Definiendo una estructura de datos
    @GetMapping("/userData/v3")
    public UserData getUserDataV3(){
        return new UserData("mary", 25, "Av Decididos 123");
    }

    @PostMapping("/order")
    public String crearOrden(@RequestBody List<Producto> products){
        orderService.saveOrder(products);
        return "Prouctos guardados";
    }

    @GetMapping("/mibean")
    public String saludarDesdeBean(){
        miBean.saludar();
        return "Completado";
    }

    @GetMapping("/micomponente")
    public String saludarDesdeComponente(){
        miComponente.saludarDesdeComponente();
        return "Completado";
    }


}

