import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * this class reads student info from text file into binary search tree.
 */
public class ReadTextFileToTree {

    /**
     * file name we will read from
     */
    private String fileName;

    /**
     * binary search tree with student information
     */
    private Tree studentTree;


    /**
     * reads student information from textfile and creates BST with it.
     * @param fileName specifies input text file
     * @throws FileNotFoundException
     */
    public ReadTextFileToTree(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.studentTree = new Tree();

        String line, opCode="", sNumber="", lName="", dptmnt="", prgrm="", year="";
        Scanner s = null;
        s = new Scanner( new File(fileName));  // read in the CSV file
        StudentNode student;

        while(s.hasNextLine()) {  // while there's more lines to read
            line = s.nextLine();  // read next line
            if(!line.isEmpty()){
                // variables for student info
                opCode = line.substring(0,1);
                sNumber = line.substring(1,8);
                lName = line.substring(8,33).trim();
                dptmnt = line.substring(33,37);
                prgrm = line.substring(37,41).trim();
                year = line.substring(41,42);

                // create student node
                student = new StudentNode(sNumber, lName, dptmnt, prgrm, year);
                studentTree.insert(student);  // add student to BST
            }
        }

    }

    /**
     * Returns the BST we create with the student information
     * @return BST with student information
     */
    public Tree getStudentTree() {
        return studentTree;
    }



}
