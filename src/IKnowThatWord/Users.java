package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

/**
 *Read the file Users.txt with FileManagerUsers
 */
public class Users {
    private ArrayList<String> users = new ArrayList<String>();

    /**
     * Read the file Users.txt
     */
    public Users(){
        FileManagerUsers fileManagerUsers = new FileManagerUsers();
        users = fileManagerUsers.read();
    }

    /**
     * fuction return Users from ArrayList
     * @return users
     */
    public ArrayList<String> getUsers(){
        return users;
    }
}
