package com.besysfot.bootcampspringboot.controller;

import com.besysfot.bootcampspringboot.dominio.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
public class HolaMundoController {

    @GetMapping()
    public String holaMundo(){
        return "Hola Mundo! =D";
    }

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola, ¿como estas?";
    }

    @GetMapping("/saludar/{param}")
    public String saludarConParametros(@PathVariable(name = "param", required = false) String nombre){
        return "Hola ".
                concat(nombre).
                concat(", ¿Como estas?.");
    }

    @GetMapping("/saludar/nom-ape/{nombre}/{apellido}")
    public String saludarConNombreApellido(@PathVariable String nombre,
                                           @PathVariable String apellido) {
        /*
            Duplicar linea
            crtl + D
         */
        boolean sonLetrasNombre = nombre.matches("^[a-zA-Z]+$");
        boolean sonLetrasApellido = apellido.matches("^[a-zA-Z]+$");
        String response = "";

        if(sonLetrasNombre && sonLetrasApellido) {
            response = "Hola " +
                    nombre +
                    " " +
                    apellido +
                    ", ¿Como andas?";

        } else {
            response = "Valide el nombre y apellido ingresado. " +
                    "\nAmbos datos solamente permiten caracteres.";
        }

        return response;
    }

    @GetMapping("/saludar/objeto/{nombre}/{apellido}")
    public Persona armarObjetoPersona(@PathVariable String nombre,
                                      @PathVariable String apellido) {
        /*
            Saber parametros de metodo, constructor, fucion, etc
            crtl + P
         */
        Persona persona = new Persona(nombre, apellido);
        return persona;
    }

    @GetMapping("/saludar/request-param")
    public Persona armarObjetoPersonaRP(@RequestParam(required = false) String nombre,
                                        @RequestParam(name = "apellidos", required = false) String apellido) {
        /*if(apellido == null || apellido.isEmpty()){
            apellido = "sin apellido";
        }*/

        if(apellido == null){
            throw new RuntimeException("Debe de ingresar el apellido");
        }

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        return persona;
    }



}
