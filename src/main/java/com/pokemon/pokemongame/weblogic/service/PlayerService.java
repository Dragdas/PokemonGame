package com.pokemon.pokemongame.weblogic.service;

import com.pokemon.pokemongame.dblogic.player.Player;
import com.pokemon.pokemongame.dblogic.repository.PlayerRepository;
import com.pokemon.pokemongame.weblogic.model.PlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerDto getPlayer(long id){
        Player p = playerRepository.getById(id);

        return PlayerDto.builder()
                .id(p.getId())
                .playerName(p.getPlayer_Name())
                .playerPassword(p.getPlayer_Password())
                .exp(p.getExp())
                .lvl(p.getLvl())
                .build();
    }


}
