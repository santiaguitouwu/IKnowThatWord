package IKnowThatWord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Model {
    private Users user;
    private Words words;
    private int points, currentLevel, wordsLevel, hitPercentage;
    private boolean verifyUser;
    private ArrayList<String> memorizeWords;
    private ArrayList<String> totalWords;
    private ArrayList<String> allWords;
    private ArrayList<String> users;

    public Model() {
        words = new Words();
        user = new Users();
        wordsLevel = 10;
        memorizeWords.add(words.getRamdonWord());
        allWords = words.getWords();
        currentLevel = 1;
        hitPercentage = 14;
        users = user.getUsers();
    }
    /**
    *That function verify if the username is in user`s array
     */
    public void userVerify(String name){
        for(int i=0; i<users.size();i++){
            int index = users.indexOf(name);

            if(index==-1){
                verifyUser = false;
            } else{
                verifyUser = true;
                currentLevel = Integer.parseInt(users.get(index+1));
            }
        }
    }
/**
Set up the number of words depending on the level
 */
    public void verifyLevel(){
        switch (currentLevel){
            case 1:
                wordsLevel = 10;
                hitPercentage = 14;
                break;
            case 2:
                wordsLevel = 20;
                hitPercentage = 28;
                break;
            case 3:
                wordsLevel = 25;
                hitPercentage = 38;
                break;
            case 4:
                wordsLevel = 30;
                hitPercentage = 48;
                break;
            case 5:
                wordsLevel = 35;
                hitPercentage = 56;
                break;
            case 6:
                wordsLevel = 40;
                hitPercentage = 68;
                break;
            case 7:
                wordsLevel = 50;
                hitPercentage = 90;
                break;
            case 8:
                wordsLevel = 60;
                hitPercentage = 108;
                break;
            case 9:
                wordsLevel = 70;
                hitPercentage = 133;
                break;
            case 10:
                wordsLevel = 100;
                hitPercentage = 200;
                break;
        }
    }

    /**
     * increase the level in 1, pass to the next level
     */
    public void nextLevel(){
        currentLevel++;
    }
    /**
    * Select the words to show to the user for be memorized
     * @return a arrayList with the words for memorize
     */
    public ArrayList<String> memorizeWords(){
        for (int i=0; i<wordsLevel-1;i++){
            String localWord = words.getRamdonWord();
            int index = memorizeWords.indexOf(localWord);

            if(index == -1){
                memorizeWords.add(i,localWord);
            } else {
                localWord = words.getRamdonWord();
                i--;
            }
        }
        return memorizeWords;
    }

    /**
     * Select the incorrect words and add the correct and incorrect words to ArrayList allWords
     * @return arrayList allWords
     */
    public ArrayList<String> completeWords(){
        allWords.addAll(memorizeWords);

        for (int i=0; i<wordsLevel-1;i++){
            String localWord = words.getRamdonWord();
            int index = memorizeWords.indexOf(localWord);

            if(index == -1){
                memorizeWords.add(i,localWord);
            } else {
                i--;
            }
        }
        Collections.shuffle(allWords);
        return memorizeWords;
    }

    /**
     * clean the arrays
     */
    public void clearArrays(){
        memorizeWords.clear();
        memorizeWords.add(words.getRamdonWord());
        allWords.clear();
        allWords.add(words.getRamdonWord());
    }

    /**
     * Increase the points
     */
    public void countScore(){
        points++;
    }

    public int getPoints() {
        return points;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getWordsLevel() {
        return wordsLevel;
    }

    public boolean isVerifyUser() {
        return verifyUser;
    }

    public ArrayList<String> getMemorizeWords() {
        return memorizeWords;
    }

    public ArrayList<String> getTotalWords() {
        return totalWords;
    }

    public ArrayList<String> getAllWords() {
        return allWords;
    }

    public ArrayList<String> getUsers() {
        return users;
    }
}

