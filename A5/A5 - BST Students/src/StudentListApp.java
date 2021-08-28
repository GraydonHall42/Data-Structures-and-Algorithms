import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Main class to run this assignment. A textfile with student information is read,
 * a binary search tree is created, and then output textfiles with the results of
 * in order and breadth-first traversal are created.
 */
public class StudentListApp {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // read input text file into tree
        var inputReader = new ReadTextFileToTree("input.txt");
        var tree = inputReader.getStudentTree();


        // print inOrder list to text file
        String inOrderTitle = "|                           RESULTS OF IN ORDER TRAVERSAL                     |";
        var inOrderList = new ArrayList<String>();
        inOrderList = tree.inOrderTraverseToArrayList(tree.getRoot(), inOrderList);
        var writerInOrder = new fileWriter();
        writerInOrder.writeListToFile(inOrderTitle, "output1.txt", inOrderList);


        // print BFS list to text file
        String bfsTitle = "|                      RESULTS OF BREADTH FIRST TRAVERSAL                     |";
        var bfsList = tree.breadthFirstSearchToArrayList();
        var writerBFS = new fileWriter();
        writerBFS.writeListToFile(bfsTitle, "output2.txt", bfsList);
    }
}
