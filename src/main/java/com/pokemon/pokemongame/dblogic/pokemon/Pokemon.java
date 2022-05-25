package com.pokemon.pokemongame.dblogic.pokemon;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Pokemon {

    @Id
    private long id;
    private long player_ID;
    private int pokemon_ID;
    private boolean owned;
    private boolean seen;

}
