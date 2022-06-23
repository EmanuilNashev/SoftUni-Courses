package StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class CountCharacterTypes {
    public static void main(String[] args) {

        try(FileReader reader = new FileReader("src/Resources/input.txt");
            PrintWriter writer = new PrintWriter("src/Resources/output.txt")){

            int vowels = 0;
            int consonant = 0;
            int punctuation = 0;

            int asci = reader.read();
            while (asci != -1){
                if (asci == 'a' || asci == 'e' || asci == 'i' || asci == 'o' || asci =='u'){
                    vowels++;
                }else if (asci == '!' || asci ==',' || asci =='.' || asci =='?'){
                    punctuation++;
                }else if (!Character.isWhitespace(asci)){
                    consonant++;
                }
                asci = reader.read();
            }

            writer.println("Vowels: " + vowels);
            writer.println("Consonants: " + consonant);
            writer.println("Punctuation: " + punctuation);
        }catch (IOException e){

        }
    }
}
