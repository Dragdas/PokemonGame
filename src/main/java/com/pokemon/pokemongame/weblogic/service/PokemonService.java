package com.pokemon.pokemongame.weblogic.service;

import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.webclient.pokemon.PokemonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonDto getPokemon(String id) {
        return pokemonClient.getPokemon(id);
    }
}
