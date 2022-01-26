import java.util.EmptyStackException;

/**
 * A Linked List based stack.
 * @author David Martin
 * Ready to be put on GitHub
 */

public class LinkedListStack<Athlete> implements StackInterface<Athlete> {

	//======================================================== Inner Node Class
	private class Node {
		Athlete data = null;
		Node next = null;

		public Node(Athlete data) {
			this(data, null);
		}

		public Node(Athlete data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//=========================================================================

	// private member variable to keep track of the number of nodes
	private int size;
	private Node head;

	/*
	 * For the following implementations, refer to the StackInterface for 
	 * documentation on how to handle edge cases
	 * 
	 */
	@Override
	public void push(Athlete item) {
		//		Node a = new Node(item);
		//		a.next = head;
		//		head = a;

		head = new Node(item, head);
		size++;
	}

	@Override
	public Athlete pop() {
		Athlete ret = peek();
		head = head.next;
		size--;
		return ret;
	}

	@Override
	public Athlete peek() {	
		if(isEmpty()) throw new EmptyStackException();		
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	// Returns (without removing) the Athlete as the index position
	// throws IndexOutOfBoundsException if index is invalid 
	public Athlete get(int index) {
		if (index >= size || index < 0) return null; //throw new IndexOutOfBoundsException();
		Node tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		return tmp.data;
	}

	// Reverses the stack
	public void reverseStack() {
//		Node tmp;
//		for (int i = 0; i < size; i++) {
//			
//		}
		Node last = null;
		Node tmp = this.head;
		Node next;
		while(tmp != null) {
			next = tmp.next;
			tmp.next = last;
			last = tmp;
			tmp = next;
		}
		this.head = last;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while(tmp != null) {
			sb.append(tmp.data.toString());
			sb.append("\n");
			tmp = tmp.next;
		}

		return sb.toString();
	}

}
