package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

/**
 *Read the file Users.txt with FileManagerUsers
 */
public class Users {
    private ArrayList<String> users;

    /**
     * Read the file Users.txt
     */
    public Users(){
        FileManager fileManager = new FileManager();
        users = fileManager.read("src/Files/Users.txt");
    }

    /**
     * fuction return Users from ArrayList
     * @return users
     */
    public ArrayList<String> getUsers(){
        return users;
    }
}
