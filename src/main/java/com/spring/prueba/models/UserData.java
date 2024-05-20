package com.spring.prueba.models;

import com.fasterxml.jackson.annotation.*;
import org.apache.catalina.User;

public class UserData {
    public String name;

    // anotacion para que el atributo no se envie en el JSON
    @JsonIgnore
    public int age;

    // Anotacion para cambiar de key en el JSON
    @JsonProperty("real_address")
    public String address;

    // Anotacion que hace que se reemplacen todas las propiedades al momento de serializar la estructura a JSON
    // @JsonValue

    // Anotacion qeu permite definir un nuevo elemento en el JSON
    @JsonGetter("information")
    public String info(){
        return "Username is " + this.name + " and age is " + this.age;
    }

    public UserData(String name, int age){
        this.name = name;
        this.age = age;
    }
    public UserData(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
