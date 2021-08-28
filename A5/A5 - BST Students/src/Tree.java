//Binary Search Tree adapted from class code

import java.util.ArrayList;

/**
 * Binary Search tree that holds student nodes
 */
public class Tree{

	/**
	 * Root node of tree
	 */
	private StudentNode root;

	/**
	 * size of tree
	 */
	private int size = 0;

	/**
	 * constructor for tree, starting with null root node
	 */
	public Tree () {
		setRoot(null);
	}


	/**
	 * insert node into BST
	 * @param st student node to add to tree
	 */
	public void insert(StudentNode st) {
		if (st == null)
			return;
		size+=1;
		st.setLeft(null);
		st.setRight(null);

		if (isEmpty()) {
			root = st;
		}
		else {
			// Start with the root and look for spot to insert
			//i.e. traverse the tree look for the proper spot to insert node
			StudentNode cursor = root;
			while(true) {
				StudentNode parent = cursor;
				//question: insert left or  right?
				// go left if st.compareTo(cursor) <= 0 (ex student = al, cursor = bob)
				if (st.compareTo(cursor) <= 0) {
					cursor = cursor.getLeft();
					// if the left child has no children, insert
					if (cursor == null) {
						parent.setLeft(st);
						return;
					}
				}// end of if
				else if (st.compareTo(cursor) > 0) {
					cursor = cursor.getRight();
					// if the right child has no children, insert
					if (cursor == null) {
						parent.setRight(st);
						return;
					}
				}// end of else if
			}// end of while

		} // end of else

	}

	/**
	 * set root of tree
	 * @param root new root of tree
	 */
	private void setRoot(StudentNode root) {
		this.root = root;
	}

	/**
	 * get root of tree
	 * @param root root of tree
	 */
	StudentNode getRoot() {
		return root;
	}

	/**
	 * check if tree is empty
	 * @return boolean if tree is empty
	 */
	public boolean isEmpty() {
		return getRoot() == null;
	}


	/**
	 * return size of tree as integer
	 * @return size of tree as integer
	 */
	public int getSize() {
		return size;
	}


	/**
	 * print tree outputs to terminal using In Order traversal
	 * @param cursor beginning search cursor
	 */
	public void printInOrderTraverse(StudentNode cursor) {

		if (cursor != null) {
			printInOrderTraverse(cursor.getLeft());
			System.out.println(cursor);
			printInOrderTraverse(cursor.getRight());
		}
	}


	/**
	 * traverse tree using in order traversal, storing results in array list.
	 * @param cursor initial starting node for search
	 * @param list empty list to be populated with tree contents
	 * @return tree contents after in order traversal
	 */
	public ArrayList<String> inOrderTraverseToArrayList(StudentNode cursor, ArrayList<String> list) {
		if (cursor != null) {
			inOrderTraverseToArrayList(cursor.getLeft(), list);
			list.add(cursor.toString());
			inOrderTraverseToArrayList(cursor.getRight(), list);
		}
		return list;
	}

	/**
	 * print tree outputs to terminal using pre Order traversal
	 * @param cursor beginning search cursor
	 */
	public void printPreOrderTraverse(StudentNode cursor) {

		if (cursor != null) {
			System.out.println(cursor);
			printPreOrderTraverse(cursor.getLeft());
			printPreOrderTraverse(cursor.getRight());
		}
	}

	/**
	 * print tree outputs to terminal using post Order traversal
	 * @param cursor beginning search cursor
	 */
	public void printPostOrderTraverse(StudentNode cursor) {
		if (cursor != null) {
			System.out.println(cursor);
			printPostOrderTraverse(cursor.getLeft());
			printPostOrderTraverse(cursor.getRight());
		}
	}


	/**
	 * Traverse tree using breadth first traversal, and store result in array list
	 * @return ArrayList with results of breadth first traversal of tree
	 */
	public ArrayList<String> breadthFirstSearchToArrayList(){
		ArrayList<String> outputList = new ArrayList<String>();
		MyQueueArray<StudentNode> queue = new MyQueueArray<StudentNode>(this.size);

		var currentNode = this.root;  // starting node
		queue.enqueue(currentNode);  // add first node to queue
		while(!queue.isEmpty()){   // while queue not empty
			currentNode = queue.dequeue();  // take first node from queue
			outputList.add(currentNode.toString());  // add to output list
			if(currentNode.getLeft() != null){  // add left child to queue
				queue.enqueue(currentNode.getLeft());
			}
			if(currentNode.getRight() != null){  // add right child to queue
				queue.enqueue(currentNode.getRight());
			}
		}
		return outputList;
	}

}