import java.util.Locale;
import java.util.Objects;

/**
 * Node that represents a student
 */
public class StudentNode implements Comparable{
	/**
	 * variables that hold information of student
	 */
	private String sNumber, lName, dptmnt, prgrm, year;
	private StudentNode left, right;

	/**
	 * @param sNumber student number
	 * @param lName last name of student
	 * @param dptmnt department the student is in
	 * @param prgrm program the student is in
	 * @param year year the student is in
	 */
	public StudentNode(String sNumber, String lName,
					   String dptmnt, String prgrm, String year) {
		this.sNumber = sNumber;
		this.lName = lName;
		this.dptmnt = dptmnt;
		this.prgrm = prgrm;
		this.year = year;

		setLeft(null);
		setRight(null);
	}

	/**
	 * set left node of student
	 * @param left left node of student
	 */
	public void setLeft(StudentNode left) {
		this.left = left;
	}

	/**
	 * get left node of student
	 * @return left node of student
	 */
	public StudentNode getLeft() {
		return left;
	}

	/**
	 * set right node of student
	 * @param right left node of student
	 */
	public void setRight(StudentNode right) {
		this.right = right;
	}

	/**
	 * get right node of student
	 * @return right node of student
	 */
	public StudentNode getRight() {
		return right;
	}

	/**
	 * Returns formatted string of student information
	 * String is formatted in such a way that it can be printed to ouptut file in
	 * a clean fashion with even columns.
	 * @return String of student informaton
	 */
	@Override
	public String toString() {
		String output;
		output = "|"+sNumber + " ".repeat(9)+"|"
				+lName+" ".repeat(25-lName.length())+"|"
				+dptmnt+" ".repeat(13)+"|"
				+prgrm+" ".repeat(9-prgrm.length())+"|"
				+year+" ".repeat(5)+"|";
		return output;
	}


	/**
	 * Comapres two students based on their last names. The values returned are:
	 * 	 0 if the string is equal to the other string.
	 * 	 < 0 if the string is lexicographically less than the other string
	 * 	 > 0 if the string is lexicographically greater than the other string
	 * @param o student to compare
	 * @return returns integer representing larger student based on last name
	 */
	@Override
	public int compareTo(Object o) {
		StudentNode that = (StudentNode) o;
		// returns:

		return this.lName.compareToIgnoreCase(that.lName);
	}

}