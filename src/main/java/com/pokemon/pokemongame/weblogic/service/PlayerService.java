package com.pokemon.pokemongame.weblogic.service;

import com.pokemon.pokemongame.dblogic.player.Player;
import com.pokemon.pokemongame.dblogic.repository.PlayerRepository;
import com.pokemon.pokemongame.weblogic.model.PlayerDto;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PokemonApiService pokemonApiService;


    public PlayerDto getPlayer(long id){
        Player p = playerRepository.getById(id);

        List<PokemonDto> pokemonsOwned = new ArrayList<>();
        List<PokemonDto> pokemonsSeen = new ArrayList<>();

        p.getPokemons().forEach(pokemon -> {
            try {
                if(pokemon.isOwned())
                    pokemonsOwned.add(pokemonApiService.getPokemon( Integer.toString( pokemon.getPokemon_ID()) ));
                if(pokemon.isSeen())
                    pokemonsSeen.add(pokemonApiService.getPokemon( Integer.toString(pokemon.getPokemon_ID()) ));
            }catch (Exception e){
                System.out.println(e);
            }
        });

        return PlayerDto.builder()
                .id(p.getId())
                .playerName(p.getPlayer_Name())
                .playerPassword(p.getPlayer_Password())
                .exp(p.getExp())
                .lvl(p.getLvl())
                .pokemonsOwned(pokemonsOwned)
                .pokemonsSeen(pokemonsSeen)
                .build();
    }


}
