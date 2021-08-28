import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class used to create a list of anagrams, based on an input text file, and then write the output to a text file.
 */
public class AnagramListCreator {
    /**
     * arraylist containing the words we will study from the text file.
     */
    private ArrayList<String> wordList;

    /**
     * linked list, which holds the lists of anagrams.
     */
    private SinglyLinkedList<AnagramList> masterList;


    /**
     * filename of the input text file.
     */
    private String inputFileName;

    /**
     * Takes word list from input file, and creates a list of anagrams from them.
     * @param inputFileName the file containing list of strings to be analyzed
     * @throws FileNotFoundException
     */
    public AnagramListCreator(String inputFileName) throws FileNotFoundException {
        this.inputFileName = inputFileName;  // get input word list
        listCreator();  // create anagram list
    }

    /**
     * Generates list of Anagrams based on input word list
     * @throws FileNotFoundException
     */
    public void listCreator() throws FileNotFoundException {

        // obtain our list of words as an ArrayList.
        ReadTextFile reader = new ReadTextFile(inputFileName);
        wordList = reader.getWordList();

        // linked list, each node holds list of anagrams.
        masterList = new SinglyLinkedList<AnagramList>();


        // iterate through each word in wordlist
        for(String word:wordList){
            boolean match = false;  // turns true if anagram exists in list for that word

            // traverse through masterList, to see if any anagrams match
            var node = masterList.getHead();
            while(node != null) {  // traverse till no more nodes.
                if (node.getValue().matches(word)) {  // if word matches with anagram list at that node.
                    node.getValue().add(word);  // add word to anagrams
                    match = true;  // so we know we found a match
                    break;  // exit while loop, no more traversal required.
                }
                node = node.getNext();  // move to next ndoe.
            }

            // no match found, create new anagram list and add to end of our linked list
            if(match == false){
                var a = new AnagramList(word);  // create new AnagramList using that word
                masterList.addLast(a);  // add our list as a new node to end of list.
            }
        }
    }


    /**
     * This method writes the output of our linked list, which holds lists of anagrams, to an output file.
     * @param fileName output file name to write to.
     */
    public void writeOutputToFile(String fileName){

        // create output file or verify existence
        try {
            File myObj = new File(fileName);
            var created = myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // write to file
        try
        {
            PrintWriter pr = new PrintWriter(fileName);

            var node = masterList.getHead();  // first node in linked list
            // traverse list till at last node.
            do{
                pr.println(node.getValue());
                node = node.getNext();
            } while(node != null);
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }


    /**
     * Main method used to run entire assignment. Running this will create an anagram list based on the
     * input text file, and write it to an output file.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        var x = new AnagramListCreator("input.txt");
        x.writeOutputToFile("output.txt");
    }
}
