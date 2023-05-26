package IKnowThatWord;

import java.io.*;
import java.util.ArrayList;

/*
*This class read the file Words
 */
public class FileManegerWords {
    public static final String words = "src/Files/Words.txt";
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    /**
    * Read the file of the words(Words.txt) and add the Words to arrayWords
    * @author Santiago Jiménez - Sarah Cardinaux
     *@version v.1.0 date 26/05/2023
     */

    public ArrayList<String> readWords(){
        ArrayList<String> arrayWords = new ArrayList<>();

        try{
            fileReader = new FileReader(words);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null){
                arrayWords.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayWords;
    }
}
