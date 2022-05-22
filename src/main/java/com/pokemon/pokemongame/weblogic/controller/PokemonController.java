package com.pokemon.pokemongame.weblogic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.service.PokemonService;
import com.vaadin.flow.component.notification.Notification;
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
        try{
            return pokemonService.getPokemon(id);
        }catch (JsonProcessingException e){
            return null;
        }

    }



}
