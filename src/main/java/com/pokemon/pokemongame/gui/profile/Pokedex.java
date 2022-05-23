package com.pokemon.pokemongame.gui.profile;


import com.pokemon.pokemongame.gui.MainLayout;
import com.pokemon.pokemongame.weblogic.model.PokemonDto;
import com.pokemon.pokemongame.weblogic.service.PokemonService;
import com.vaadin.flow.component.Key;
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

    private Image imageFront;
    private Image imageBack;
    private TextField pokemonId;
    private TextField pokemonName;
    private TextField pokemonWeight;
    private TextField pokemonHeight;
    private FormLayout formLayout;
    private TextField idInputTextField;
    private Button getPokemonButton;

    public Pokedex() {

        initializeFormLayout();

        initializeUserInputComponents();

        add( formLayout, idInputTextField, getPokemonButton);
    }

    private void initializeFormLayout() {
        imageFront = new Image("https://www.shareicon.net/data/128x128/2016/08/01/640216_go_512x512.png", "pokeball");
        imageBack = new Image("https://www.shareicon.net/data/128x128/2016/08/01/640216_go_512x512.png", "pokeball");
        pokemonId = new TextField("Pokemon ID", "ID");
        pokemonId.setReadOnly(true);
        pokemonName = new TextField("Pokemon name", "Name");
        pokemonName.setReadOnly(true);
        pokemonWeight = new TextField("Pokemon weight", "Weight");
        pokemonWeight.setReadOnly(true);
        pokemonHeight = new TextField("Pokemon height", "Height");
        pokemonHeight.setReadOnly(true);

        formLayout = new FormLayout();

        formLayout.add(imageFront, imageBack,
                pokemonId, pokemonName,
                pokemonWeight, pokemonHeight);

        formLayout.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("100px", 2)
        );
    }

    private void initializeUserInputComponents() {
        idInputTextField = new TextField("Pokemon ID");
        getPokemonButton = new Button("Find Pokemon");

        getPokemonButton.addClickListener(e -> executeGetPokemonButton() );
        getPokemonButton.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, idInputTextField, getPokemonButton);

    }

    private void executeGetPokemonButton() {
        try {
            String id = idInputTextField.getValue();
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
    }

}
