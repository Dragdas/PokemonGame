package com.pokemon.pokemongame.weblogic.webclient.pokemon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.pokemongame.weblogic.model.MoveDto;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.webclient.pokemon.models.OpenMovesDto;
import com.pokemon.pokemongame.weblogic.webclient.pokemon.models.OpenPokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonClient {

    @Autowired
    ObjectMapper objectMapper;

    public static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate = new RestTemplate();

    public PokemonDto getPokemon(String id){
        String url = API_URL + id;
        String json = restTemplate.getForObject(url, String.class);

        try{
            OpenPokemonDto response = objectMapper.readValue(json, OpenPokemonDto.class);

            List<MoveDto> moves = response.getMoves().stream()
                    .map(OpenMovesDto::getMove)
                    .map(move -> new MoveDto(move.getName(), move.getUrl()))
                    .collect(Collectors.toList());


            return PokemonDto.builder()
                    .id(response.getId())
                    .name(response.getName())
                    .spriteBack(response.getSprites().getBack_default())
                    .spriteFront(response.getSprites().getFront_default())
                    .moves(moves)
                    .base_experience(response.getBase_experience())
                    .height(response.getHeight())
                    .weight(response.getWeight())
                    .build();

        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

}
