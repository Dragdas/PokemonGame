package com.pokemon.pokemongame.dblogic.player;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class PlayerDB {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(nullable = false)
    private String playerName;

    //TODO hash and salt https://stackoverflow.com/questions/1054022/best-way-to-store-password-in-database
    @Column(nullable = false)
    private String playerPassword;

    private Integer lvl;

    private Integer exp;



}
