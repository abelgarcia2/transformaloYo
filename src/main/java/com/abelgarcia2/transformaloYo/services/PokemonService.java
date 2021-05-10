package com.abelgarcia2.transformaloYo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class Sprite {
    public String front_shiny;
    public String back_default;
    public String front_default;
}

class Pokemon {
    public int height;
    public Sprite sprites;
    public int weight;
}

@Service
public class PokemonService {

    @Autowired
    RestTemplate restTemplate;

    public int getPeso(String nombrePokemon) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;
        Pokemon json = restTemplate.getForObject(url, Pokemon.class);
        return json.weight;
    }

    public int getAltura(String nombrePokemon) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;
        Pokemon json = restTemplate.getForObject(url, Pokemon.class);
        return json.height;
    }

    public String getFoto(String nombrePokemon) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;
        Pokemon json = restTemplate.getForObject(url, Pokemon.class);
        return json.sprites.front_shiny;
    }
}