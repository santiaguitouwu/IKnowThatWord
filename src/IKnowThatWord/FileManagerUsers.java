package IKnowThatWord;

import java.io.*;
import java.util.ArrayList;

/**
 * Read the file Users.txt, add the user and their level to ArrayList
 * @author Santiago Jiménez - Sarah Cardinaux
 * @version v.1.0 date 26/05/2023
 */
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
