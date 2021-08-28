import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Allowing reading from standard in through a BufferedReader.
 * 
 * As explained in Section 4.3 of Java, Java, Java 3e
 * 
 * @author Morelli and Walde
 *
 * taken from ENSF 593 Classwork with Dr. Yves Pauchard
 */
public class KeyboardReader {

	private BufferedReader reader;
	
	public KeyboardReader() {
		reader = new BufferedReader(
					new InputStreamReader(System.in));
				
	}

	/**
	 * Get input from user as a string
	 * @return String user input
	 */
	public String getKeyboardInput(){
		return readKeyboard(); 
	}

	/**
	 * Get input from user as integer
	 * @return Integer user input
	 */
	public int getKeyboardInteger(){
		return Integer.parseInt(readKeyboard()); 
	}

	/**
	 * Get input from user as double
	 * @return double user input
	 */
	public double getKeyboardDouble(){ 
		return Double.parseDouble(readKeyboard()); 
	}

	/**
	 * Prompt user for input
	 * @param s String to show to user
	 */
	public void prompt(String s){
		System.out.print(s);
	}

	/**
	 * base internal method for obtaining user input as string.
	 * @return String from user input
	 */
	private String readKeyboard(){
		String line = "";
		try{ 
			line = reader.readLine(); 
		} catch (IOException e){ 
			e.printStackTrace();
		}
		return line; 
	}
}

