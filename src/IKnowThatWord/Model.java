package IKnowThatWord;

import java.util.ArrayList;

public class Model {
    private Users user;
    private Words words;
    private int score, currentLevel, wordsLevel, hitPercentage;
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
    * Select the words to show to the user for be memorized
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

}

