// ******** Taken from class code ************** //
// this version of teh class is implemented so it can take any generic type though.
public class MyStackGeneric<T> {
	/**
	 * Max size of stack
	 */
	private int maxSize;

	/**
	 * Array to hold values of stack
	 */
	private T[] stackValues;

	/**
	 * Integer to keep track of top value in stack
	 */
	private int top;


	/**
	 * Constructor for basic stack object
	 * @param s size of stack
	 */
	public MyStackGeneric(int s) {
		maxSize = s;
		stackValues = (T[])new Object[maxSize];
		top = -1;
	}

	/**
	 * push item to top of stack
	 * @param j item to place at top of stack
	 */
	public void push(T j) {
		if (isFull()) 
			System.out.println("Stack is full. ");
		
		
		stackValues[++top] = j;  //++top is using pre-increment operator, top++ is post increment op.
	}

	/**
	 * removes and returns top item on stack
	 * @return top item of stack
	 */
	public T pop() {
		if (isEmpty()) { 
			System.out.println("Stack is Empty. ");
			return null;
		}
		
		return stackValues[top--];
	}

	/**
	 * returns but does NOT remove top item of stack
	 * @return top item of stack
	 */
	public T peek() {
		return stackValues[top];
	}

	/**
	 * Checks if stack is empty
	 * @return boolean True if stack is empty
	 */
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * Checks if stack is full
	 * @return boolean True if stack is full
	 */
	public boolean isFull() {
		return (top == maxSize - 1);
	}

}