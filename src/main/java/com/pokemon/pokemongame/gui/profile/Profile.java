package com.pokemon.pokemongame.gui.profile;


import com.pokemon.pokemongame.gui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


@PageTitle("Profile")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@StyleSheet("css/Style.css")
public class Profile extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public Profile() {

        Image imageFront = new Image("https://www.shareicon.net/data/128x128/2016/08/01/640216_go_512x512.png", "pokeball");
        Image imageBack = new Image("https://www.shareicon.net/data/128x128/2016/08/01/640216_go_512x512.png", "pokeball");
        TextField pokemonId = new TextField("Pokemon ID", "ID");
        pokemonId.setReadOnly(true);
        TextField pokemonName = new TextField("Pokemon name", "Name");
        pokemonName.setReadOnly(true);
        TextField pokemonWeight = new TextField("Pokemon weight", "Weight");
        pokemonWeight.setReadOnly(true);
        TextField pokemonHeight = new TextField("Pokemon height", "Height");
        pokemonHeight.setReadOnly(true);

        FormLayout formLayout = new FormLayout();
        formLayout.add(imageFront, imageBack,
                pokemonId, pokemonName,
                pokemonWeight, pokemonHeight);
        formLayout.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("100px", 2)
        );














        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            imageFront.setSrc("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png");
            imageBack.setSrc("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/15.png");
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);




        add( formLayout, name, sayHello);
    }

}
