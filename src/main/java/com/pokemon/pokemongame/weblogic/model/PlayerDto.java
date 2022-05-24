package com.pokemon.pokemongame.weblogic.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerDto {

    private long id;
    private String playerName;
    private String playerPassword;
    private Integer lvl;
    private Integer exp;

}
