package com.pokemon.pokemongame.gui.collection;

import com.pokemon.pokemongame.gui.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Poke collection")
@Route(value = "collection", layout = MainLayout.class)
@StyleSheet("css/Style.css")
public class PokeCollection extends HorizontalLayout {

    PokeCollection(){

        add(new Text("collection"));

    }


}
