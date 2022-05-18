package com.pokemon.pokemongame.weblogic.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PokemonDto {

    private int id;
    private String name;
    private String spriteFront;
    private String spriteBack;
    private List<MoveDto> moves;

}
