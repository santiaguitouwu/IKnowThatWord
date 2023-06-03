package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<String> words;
    public Words(){
        //FileManager fileManager = new FileManager();
        //words = fileManager.read("src/Files/Words.txt");
    }
    public String getRamdonWord(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public String[] getWords(int level) {
        String[] words;
        switch (level){
            case 1:
                words = new String[] {"hola","como","pero","cosa","televisor","casa","carro","moto","piso","pedo"} ;
                break;
            default:
                words = new String[0]; // Valor por defecto si no se cumple ninguno de los casos
                break;
        }
        return words;
    }
}
