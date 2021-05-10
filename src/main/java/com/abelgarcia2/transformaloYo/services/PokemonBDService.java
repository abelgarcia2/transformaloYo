package com.abelgarcia2.transformaloYo.services;

import java.util.ArrayList;

import com.abelgarcia2.transformaloYo.models.PokemonModel;
import com.abelgarcia2.transformaloYo.repositories.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonBDService {

    @Autowired
    PokemonRepository pokemonRepository;

    public ArrayList<PokemonModel> obtenerTodosLosPokemons() {
        return (ArrayList<PokemonModel>) pokemonRepository.findAll();
    }

    public PokemonModel guardarPokemon(PokemonModel pokemon) {
        return pokemonRepository.save(pokemon);
    }
}
