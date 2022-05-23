package com.pokemon.pokemongame.weblogic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokemon.pokemongame.weblogic.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/pokemon/{id}")
    public Object getPokemon(@PathVariable(value="id")String id){
        try{
            return Optional.ofNullable(pokemonService.getPokemon(id));
        }catch (JsonProcessingException e){
            return CustomErrorController.handleError(e);
        }

    }



}
