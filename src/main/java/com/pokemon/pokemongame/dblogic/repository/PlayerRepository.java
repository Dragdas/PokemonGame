package com.pokemon.pokemongame.dblogic.repository;


import com.pokemon.pokemongame.dblogic.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
