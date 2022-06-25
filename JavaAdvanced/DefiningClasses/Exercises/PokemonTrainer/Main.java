package DefiningClasses.Exercises.PokemonTrainer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] data = line.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("End")){
            String element = line;

            checkForPokemonElement(trainers,element);

            line= scanner.nextLine();
        }
        trainers.entrySet().stream().sorted((v1,v2) -> {
            if (v1.getValue().getNumberOfBadges()> v2.getValue().getNumberOfBadges()){
                return -1;
            }else if (v1.getValue().getNumberOfBadges()== v2.getValue().getNumberOfBadges()){
                return 0;
            }
            return 1;
        }).forEach(e -> System.out.printf("%s %d %d%n", e.getKey(), e.getValue().getNumberOfBadges(), e.getValue().getPokemons().size()));
    }

    private static void checkForPokemonElement(Map<String, Trainer> trainers, String element) {
        for (var trainerSet : trainers.entrySet()) {
            boolean flag = false;
            for (Pokemon pokemon : trainerSet.getValue().getPokemons()) {
                if (pokemon.getElement().equals(element)){
                    trainerSet.getValue().increaseBadge();
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (int i = 0; i < trainerSet.getValue().getPokemons().size(); i++) {
                    trainerSet.getValue().getPokemons().get(i).decreaseHealth();
                    if (trainerSet.getValue().getPokemons().get(i).getHealth() <=0){
                        trainerSet.getValue().getPokemons().remove(i);
                        i--;
                    }
                }
            }
        }
    }
}
