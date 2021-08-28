import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Takes a text file with one word per line, and creates an array based on the words in the file.
 */
public class ReadTextFile {


    /**
     * file name we will read from
     */
    private String fileName;
    /**
     * will hold our words from our CSV
     */
    private ArrayList<String> wordList;

    /**
     * Reads list of word from input text file, and populates arraylist with them.
     * @param fileName specifies input text file
     * @throws FileNotFoundException
     */
    public ReadTextFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        wordList = new ArrayList<String>();

        String line;
        Scanner s = null;
        s = new Scanner( new File(fileName));  // read in the CSV file

        while(s.hasNextLine()) {  // while there's more lines to read
            line = s.nextLine();  // read next line
            String[] rowAsString;
            rowAsString = line.split(",");  // split row into array of strings

            String word = rowAsString[0];
            wordList.add(word);
        }

    }


    /**
     * getter function to return ArrayList of words found in input text fie.
     * @return wordList which contains words from input file as an ArrayList.
     */
    public ArrayList<String> getWordList() {
        return wordList;
    }


    /**
     * Used to test/demonstrate functionality of the class.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // used to test out the class
        var x = new ReadTextFile("input.txt");
        System.out.println(x.getWordList());
    }
}
