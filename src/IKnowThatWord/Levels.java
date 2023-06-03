package IKnowThatWord;

public class Levels {
    private int level = 1;

    public Levels(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    /*public void setLevel(int level){
        this.level = level;
    }*/

    public int nextLevel() {
        int currentLevel = getLevel();
        this.level = currentLevel++;
        return getLevel();
    }
}
