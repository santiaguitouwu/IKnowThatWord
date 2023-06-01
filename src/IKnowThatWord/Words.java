package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<String> words = new ArrayList<>();
    public Words(){
        FileManegerWords fileManegerWords = new FileManegerWords();
        words = fileManegerWords.readWords();
    }
    public String getRamdonWord(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
