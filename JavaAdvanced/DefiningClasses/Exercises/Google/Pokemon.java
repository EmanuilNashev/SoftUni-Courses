package DefiningClasses.Exercises.Google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String name, String type) {
        this.pokemonName = name;
        this.pokemonType = type;
    }

    public String getPokemonName(){
        return this.pokemonName;
    }
    public String getPokemonType(){
        return this.pokemonType;
    }

}
