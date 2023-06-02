package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<String> words;
    public Words(){
        FileManager fileManager = new FileManager();
        words = fileManager.read("src/Files/Words.txt");
    }
    public String getRamdonWord(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
