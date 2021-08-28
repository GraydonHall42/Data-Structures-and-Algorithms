/**
 * Node which is used to comprise a singly list.
 * @param <T> Specifies type of value to be held by node.
 */
public class Node<T> {

	/**
	 * Next Node in linked list
	 * */
	private Node next;
	/**
	 * value held by node, of generic type T.
	 */
	private T value;

	/**
	 * Constructor to create node, with value and next node specified
	 * @param value value that node will hold
	 * @param n next node
	 */
	public Node (T value, Node n) {
		setValue(value);
		setNext(n);
	}

	/**
	 * Constructor to create node, with value of node specified.
	 * @param value value that node will hold
	 */
	public Node (T value) {
		setValue(value);
	}

	/**
	 * getter function for value of node.
	 * @return value of node.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * setter function for value of node.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * setter function for setting next node this node is linked to.
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * getter function for next node this node is linked to.
	 * @return next node that this node links to.
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @return value of node as a string.
	 */
	@Override
	public String toString() {
		return ""+value;
	}
}