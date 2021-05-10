package com.abelgarcia2.transformaloYo.controllers;

import com.abelgarcia2.transformaloYo.services.FotoFakeService;
import com.abelgarcia2.transformaloYo.services.FotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @Autowired
    FotoService fotoService;

    @Autowired
    FotoFakeService fotoFakeService;

    @GetMapping("/")
    public String bienvenida() {
        return "EL SERVIDOR ESTÁ EN FUNCIONAMIENTO";
    }

    @GetMapping("/saluda")
    public String saluda() {
        return "Hola, como estás?";
    }

    @GetMapping("/saludame/{nombre}")
    public String saludame(@PathVariable String nombre) {
        return "Hola que tal " + nombre;
    }

    @GetMapping("/dameFoto")
    public String dameFoto() {
        String foto = fotoService.getFoto();
        return "<img src='" + foto + "'/>";
    }

    @GetMapping("/dameFakeFoto")
    public String dameFakeFoto() {
        String foto = fotoFakeService.getFotoFake();
        return "<img src='" + foto + "'/>";
    }

}
