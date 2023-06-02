package IKnowThatWord;

import java.io.*;
import java.util.ArrayList;

/**
 * Read the file Users.txt, add the user and their level to ArrayList
 * @author Santiago Jiménez - Sarah Cardinaux
 * @version v.1.0 date 26/05/2023
 */
public class FileManager {
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public ArrayList<String> read(String filePath){
        ArrayList<String> ArrayUsers = new ArrayList<>();

        try{
            fileReader = new FileReader(filePath);
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

    public void saveUser(String line){
        try{
            fileWriter = new FileWriter("src/Files/Users.txt", false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
