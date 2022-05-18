package com.pokemon.pokemongame.weblogic.model;


import lombok.Getter;

@Getter
public class MoveDto {

    private String moveName;
    private String url;

    public MoveDto(String moveName, String url) {
        this.moveName = moveName;
        this.url = url;
    }
}
