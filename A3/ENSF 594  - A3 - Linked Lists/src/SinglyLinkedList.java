/**
 * Implementation of a singly linked list, adapted from class notes (ENSF 594 at University of Calgary)
 * @param <T> Specifies type of data to be held by node.
 */
public class SinglyLinkedList<T>{
	// *** adapted from code written in class ***

	/**
	 * Head node of list
	 */
	private Node<T> head;


	/**
	 * tail node of linked list
	 */
	private Node<T> tail;


	/**
	 * size of linked list, initially  when list is empty.
	 */
	private int size = 0;

	public SinglyLinkedList() {
		// Create an empty linked list
	}

	/**
	 * Used to check if linked list is empty.
	 * @return boolean of whether list is empty or not
	 */
	public boolean isEmpty() {
		// true if size == 0;
		return size == 0;
	}

	/**
	 * get first node in linked list.
	 * @return first node in list
	 */
	public Node<T> getHead() {
		return head;
	}


	/**
	 * adds node to beginning of linked list
	 * @param n node to add to list
	 */
	public void addFirst(T n) {
		// method to add to beginning of linked list
		// head = newNode, and NewNode.next = old head.
		head = new Node<T>(n, head);

		// if empty, tail = head.
		if (size == 0)
			tail = head;

		size++;
	}


	/**
	 * add node to end of linked list
	 * @param n node to add
	 */
	public void addLast(T n) {
		Node<T> newest = new Node<T>(n,null);

		if (isEmpty()) {
			head = newest;
		}

		else
			tail.setNext(newest);

		tail = newest;

		size++;
	}


	/**
	 * Remove the first node (id) from the list
	 * @return boolean to show if node was removed.
	 */
	public boolean remFirst() {
		if (isEmpty())
			return false;
		var answer = head.getValue();
		head = head.getNext();
		size--;

		if (size == 0)
			tail = null;

		return true;
	}

	/**
	 * @return String form of list, with words separated by single space.
	 */
	public String toString() {
		// prints list in form: "node1, node2, node3"
		String strList = "";
		Node<T> node = head;  // first node in list.

		// traverse through list.
		while (node.getNext() != null) {
			strList += node.getValue() + ", ";
			node = node.getNext();
		}
		strList += node.getValue();
		return strList;
	}

	/**
	 * getter function to return size of linked list
	 * @return int size of linked list
	 */
	public int size() {
		return size;
	}


}