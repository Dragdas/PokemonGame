package com.pokemon.pokemongame.dblogic.repository;


import com.pokemon.pokemongame.dblogic.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.pokemons WHERE p.id = ?1 ")
    public Player findPlayerByID(long id);


}
