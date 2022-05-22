package com.pokemon.pokemongame.gui.profile;


import com.pokemon.pokemongame.gui.MainLayout;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.service.PokemonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Pokedex")
@Route(value = "pokedex", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@StyleSheet("css/Style.css")
public class Pokedex extends HorizontalLayout {

    @Autowired
    private PokemonService pokemonService;

    public Pokedex() {

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

        TextField idInpuTextField = new TextField("Pokemon ID");
        Button getPokemonButton = new Button("Find Pokemon");
        getPokemonButton.addClickListener(e -> {
            try {
                String id = idInpuTextField.getValue();
                PokemonDto pokemon = pokemonService.getPokemon(id);

                imageFront.setSrc(pokemon.getSpriteFront());
                imageBack.setSrc(pokemon.getSpriteBack());
                pokemonId.setValue(Integer.toString(pokemon.getId()));
                pokemonName.setValue(pokemon.getName());
                pokemonWeight.setValue(Integer.toString(pokemon.getWeight()));
                pokemonHeight.setValue(Integer.toString(pokemon.getHeight()));


            }catch (Exception exception){
                Notification.show("Invalid ID number!");
            }

        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, idInpuTextField, getPokemonButton);

        add( formLayout, idInpuTextField, getPokemonButton);
    }

}
