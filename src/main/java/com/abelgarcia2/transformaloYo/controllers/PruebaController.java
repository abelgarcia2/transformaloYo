package com.abelgarcia2.transformaloYo.controllers;

import java.util.Map;

import com.abelgarcia2.transformaloYo.models.PokemonModel;
import com.abelgarcia2.transformaloYo.services.FotoFakeService;
import com.abelgarcia2.transformaloYo.services.FotoService;
import com.abelgarcia2.transformaloYo.services.PokemonBDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @Autowired
    FotoService fotoService;

    @Autowired
    FotoFakeService fotoFakeService;

    @Autowired
    PokemonBDService pokemonBDService;

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

    @GetMapping("/pokemons")
    public String todosPokemons() {
        return pokemonBDService.obtenerTodosLosPokemons().toString();
    }

    @PostMapping("/insertarPokemon")
    public String insertaPokemon(@RequestParam Map<String, String> body) {
        System.out.println(body.get("nombre"));
        PokemonModel pokemon = new PokemonModel();
        pokemon.setNombre(body.get("nombre"));
        pokemon.setPeso(Integer.parseInt(body.get("peso")));
        pokemon.setAltura(Integer.parseInt(body.get("peso")));
        pokemonBDService.guardarPokemon(pokemon);
        return "Pokemon guardado";
    }

}
