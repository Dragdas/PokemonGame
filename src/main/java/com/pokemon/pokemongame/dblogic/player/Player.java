package com.pokemon.pokemongame.dblogic.player;

import com.pokemon.pokemongame.dblogic.pokemon.Pokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Player {

    @Id
    private long id;
    private String player_Name;
    //TODO hash and salt https://stackoverflow.com/questions/1054022/best-way-to-store-password-in-database
    private String player_Password;
    private Integer lvl;
    private Integer exp;

    @OneToMany
    @JoinColumn(name = "PLAYER_ID")
    private List<Pokemon> pokemons;



}
