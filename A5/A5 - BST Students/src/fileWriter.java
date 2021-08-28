import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class takes an araryList of strings, and writes it to an output text file.
 */
public class fileWriter {


    /**
     * @param title title to insert in text file
     * @param fileName  fileName to write to
     * @param outputList  Arraylist to write to output file
     */
    public void writeListToFile(String title, String fileName, ArrayList<String> outputList){

        String header = "| Student Number |       Last Name         | Home Department | Program | Year |\n" +
                "+----------------+-------------------------+-----------------+---------+------+";

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
            pr.println("+----------------+-------------------------+-----------------+---------+------+");
            pr.println(title);
            pr.println("+----------------+-------------------------+-----------------+---------+------+");
            pr.println(header);
            for (String str : outputList) {
                pr.println(str);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }
}
