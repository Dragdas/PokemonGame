package com.pokemon.pokemongame.weblogic.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlayerDto {

    private long id;
    private String playerName;
    private String playerPassword;
    private Integer lvl;
    private Integer exp;

    private List<PokemonDto> pokemonsOwned;
    private List<PokemonDto> pokemonsSeen;

}
