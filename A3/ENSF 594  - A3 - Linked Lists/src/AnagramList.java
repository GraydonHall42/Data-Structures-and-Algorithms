import java.util.ArrayList;
import java.util.Locale;

/**
 * Class used to hold a list of anagrams. Only words which are anagrams with the word used to construct this class
 * can be added to the list.
 */
public class AnagramList {


    private String sortedAnagram;  // alphabetically sorted anagram used for comparison purposes
    private ArrayList<String> wordList;  // will hold our words from our CSV

    /**
     * Constructor to create an Anagram List, based on the specified word.
     * @param word word to create anagram list for
     */
    public AnagramList(String word) {
        this.sortedAnagram = sortString(word).toLowerCase(Locale.ROOT);
        wordList = new ArrayList<String>();
        wordList.add(word);
    }

    /**
     * @param word word we want to know if is an anagram that fits in this list.
     * @return boolean true if word is an anagram that belongs in the list.
     */
    public boolean matches(String word){
        // returns true if word belongs in our anagram list
        // sorts word, and compares it to this.sortedAnagram
        String sortedLowerWord = sortString(word).toLowerCase(Locale.ROOT);
        return sortedAnagram.equals(sortedLowerWord);

    }

    /**
     * adds word to anagram list. KEY: matches() should be run first to verify word is an anagram.
     * if word is not an anagram it will not be added.
     * @param word word to add to list.
     * @return boolean true if word was added. false if word was not an anagram and can't be added.
     */
    public boolean add(String word){
        // add word to our anagram list
        if (matches(word)){
            wordList.add(word);
            return true;
        }
        return false;  // word was not added
    }

    /**
     * takes a string, and sorts it in alphabetical order.
     * @param inputString string to be sorted in alphabetical order
     * @return sorted string in alphabetical order.
     */
    private String sortString(String inputString)
    {
        // convert input string to char array
        char[] tempArray = inputString.toCharArray();

        // sort tempArray
        insertionSort(tempArray);  // sort our array of chars using insertion sort.

        // return new sorted string
        return new String(tempArray);
    }

    /**
     * implementation of insertion sort used to sort array of chars.
     * @param arr sorted array of chars
     */
    private void insertionSort(char[] arr) {
        // https://www.geeksforgeeks.org/insertion-sort/
        // accessed: 2021-07-12
        // author: Rajat Mishra
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            char key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * @return string list of anagrams in the list.
     */
    @Override
    public String toString() {
        // print wordlist in form: "word1 word2 word3"
        String listStr = "";
        for (String word: wordList){
            listStr += word + " ";
        }
        return listStr;
    }

    /**
     * Used to test/demonstrate functionality of the class.
     * @param args
     */
    public static void main(String[] args) {
        // used to test out the anagram list maker.
        var x = new AnagramList("rac");
        var words = new String[]{"car", "mega", "bed", "stop", "game", "pots", "arc", "tops"};
        for(String word:words){
            if(x.matches(word)){
                x.add(word);
            }
        }
        System.out.println(x);
    }

}
