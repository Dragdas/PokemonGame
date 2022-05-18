package com.pokemon.pokemongame.weblogic.webclient.pokemon.models;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenPokemonDto {

    private int id;
    private String name;
    private OpenSpritesDto sprites;
    private List<OpenMovesDto> moves;




}
