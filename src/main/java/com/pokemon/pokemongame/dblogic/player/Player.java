package com.pokemon.pokemongame.dblogic.player;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    //TODO hash and salt https://stackoverflow.com/questions/1054022/best-way-to-store-password-in-database
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer experience;



}
