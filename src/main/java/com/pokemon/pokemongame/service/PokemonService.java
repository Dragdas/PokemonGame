package com.pokemon.pokemongame.service;

import com.pokemon.pokemongame.model.PokemonDto;
import com.pokemon.pokemongame.webclient.pokemon.PokemonClient;
import com.pokemon.pokemongame.webclient.pokemon.dto.OpenPokemonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonDto getPokemon(String id) {
        return pokemonClient.getPokemon(id);
    }
}
