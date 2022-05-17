package com.pokemon.pokemongame.controller;


import com.pokemon.pokemongame.model.PokemonDto;
import com.pokemon.pokemongame.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/pokemon/{id}")
    public PokemonDto getPokemon(@PathVariable(value="id")String id){

        return pokemonService.getPokemon(id);
    }



}
