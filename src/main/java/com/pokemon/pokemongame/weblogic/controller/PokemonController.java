package com.pokemon.pokemongame.weblogic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.service.PokemonApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonApiService pokemonAPIService;

    @GetMapping("/pokemon/{id}")
    public Object getPokemon(@PathVariable(value="id")String id){
        try{
            return pokemonAPIService.getPokemon(id);
        }catch (JsonProcessingException e){
            return CustomErrorController.handleError(e);
        }

    }



}
