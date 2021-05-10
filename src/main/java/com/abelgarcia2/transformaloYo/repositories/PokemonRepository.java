package com.abelgarcia2.transformaloYo.repositories;

import com.abelgarcia2.transformaloYo.models.PokemonModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<PokemonModel, Long> {
    
}
