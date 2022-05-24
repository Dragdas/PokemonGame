package com.pokemon.pokemongame.weblogic.controller;


import com.pokemon.pokemongame.dblogic.player.Player;
import com.pokemon.pokemongame.weblogic.model.PlayerDto;
import com.pokemon.pokemongame.weblogic.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/player/{id}")
    public PlayerDto getPlayerName(@PathVariable(value="id")String id){

            //TODO przegadac dlaczego nie mogę zwrócić po prostu Playera zwracanego z DB??

            return playerService.getPlayer(Long.parseLong(id));
    }

}
