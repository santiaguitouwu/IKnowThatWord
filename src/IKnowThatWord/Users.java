package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

public class Users {
    private ArrayList<String> users = new ArrayList<String>();

    public Users(){
        FileManagerUsers fileManagerUsers = new FileManagerUsers();
        users = fileManagerUsers.read();
    }

    public String getUser(){
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    public ArrayList<String> getUsers(){
        return users;
    }
}
