package IKnowThatWord;

import java.io.*;
import java.util.ArrayList;

public class FileManagerUsers {
    private static final String fileUsers = "src/Files/Users.txt";
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public ArrayList<String> read(){
        ArrayList<String> ArrayUsers = new ArrayList<>();

        try{
            fileReader = new FileReader(fileUsers);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null){
                ArrayUsers.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ArrayUsers;
    }
}
