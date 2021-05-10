package com.abelgarcia2.transformaloYo.controllers;

import com.abelgarcia2.transformaloYo.services.PokemonBDService;
import com.abelgarcia2.transformaloYo.services.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    PokemonBDService pokemonBDService;

    @RequestMapping("/pokemono/{nombrePokemon}")
    public String datosPokemon(@PathVariable String nombrePokemon, Model modelo) {
        int peso = pokemonService.getPeso(nombrePokemon) / 10;
        int altura = pokemonService.getAltura(nombrePokemon);
        String foto = pokemonService.getFoto(nombrePokemon);
        modelo.addAttribute("nombre", nombrePokemon);
        modelo.addAttribute("peso", peso);
        modelo.addAttribute("altura", altura);
        modelo.addAttribute("foto", foto);
        return "pokemon";
    }

    @RequestMapping("/formulario")
    public String formulario(){
        return "formulario";
    }
}
