package IKnowThatWord;

import java.io.*;

/**
 * Write the file with the Users (Users.txt), save the users and their level
 * @author Santiago Jiménez - Sarah Cardinaux
 * @version v.1.0 date 26/05/2023
 */
public class FileManagerWriterUsers {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

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
