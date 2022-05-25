package com.pokemon.pokemongame.gui.collection;

import com.pokemon.pokemongame.gui.MainLayout;
import com.pokemon.pokemongame.weblogic.model.PlayerDto;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.service.PlayerService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@PageTitle("Poke collection")
@Route(value = "collection", layout = MainLayout.class)
@StyleSheet("css/Style.css")
public class PokeCollection extends VerticalLayout {


    PokeCollection(@Autowired PlayerService playerService){

        Grid<PokemonDto> grid = new Grid<>(PokemonDto.class, false);
        grid.addColumn(PokemonDto::getId).setHeader("ID").setAutoWidth(true);
        grid.addColumn(PokemonDto::getName).setHeader("Name").setAutoWidth(true);
        grid.addColumn(PokemonDto::getBase_experience).setHeader("Base exp").setAutoWidth(true);
        grid.addColumn(PokemonDto::getHeight).setHeader("Height").setAutoWidth(true);
        grid.addColumn(PokemonDto::getWeight).setHeader("Weight").setAutoWidth(true);

        PlayerDto player = playerService.getPlayer(1);

        grid.setItems(player.getPokemonsOwned());

        add(grid);

    }


}
