package com.pokemon.pokemongame.webclient.pokemon;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pokemon.pokemongame.model.MoveDto;
import com.pokemon.pokemongame.model.PokemonDto;
import com.pokemon.pokemongame.webclient.pokemon.dto.OpenMoveDto;
import com.pokemon.pokemongame.webclient.pokemon.dto.OpenMovesDto;
import com.pokemon.pokemongame.webclient.pokemon.dto.OpenPokemonDto;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonClient {

    public static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate = new RestTemplate();

    public PokemonDto getPokemon(String id){
        String url = API_URL + id;
        String json = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
                    .build();

        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

}
