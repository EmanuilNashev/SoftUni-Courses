package DefiningClasses.Exercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.numberOfBadges = 0;
    }

    public List<Pokemon> getPokemons(){
        return this.pokemons;
    }

    public void increaseBadge(){
        this.numberOfBadges++;
    }

    public int getNumberOfBadges(){
        return this.numberOfBadges;
    }
}
