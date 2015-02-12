/**
 *
 * @author Warosaurus
 */


public class Stack_ar {

	private int size;
	private Object[] stack;
	private Object head;
	private Object tail;

	// Default constructor
	public Stack_ar() {
		this.size = 0;
		this.head = null;
		this.tail = null;
		this.stack = new Object[0];
	}

	// Parametrized constructor
	public Stack_ar(Object[] ar) {
		if (ar.length != 0) {
			this.stack = ar;
			this.size = ar.length;
			updateStack();
		}
	}

	// Support method to avoid redundant code
	private void updateStack() {
		this.head = this.stack[0];
		this.tail = this.stack[this.size -1];
	}

	// Returns a boolean whether the stack is empty
	public boolean isEmpty() {
		return (this.getSize() == 0);
	}

	// Returns an int of the size of the stack
	public int getSize() {
		return this.size;
	}

	// Returns null if stack is empty
	public Object getHead() {
		return this.head;
	}

	// Returns null if stack is empty
	public Object getTail() {
		return this.tail;
	}

	// Returns null if stack is empty
	public Object getN(int n) {
		if (0 <= n && n < this.size) //Boundary check
			return this.stack[n];
		else
			return null;
	}

	// Remove element at specific a position in the stack
	public void removeN(int n) {
		if (0 <= n && n < this.size) { //Boundary check
			int y = 0;
			Object[] ar = new Object[this.size -1];
			for (int i = 0; i < this.size - 1; i++) {
				if (i == n)
					y++;
				ar[i] = this.stack[y];
				y++;
			}
			this.stack = ar;
			this.size--;
			updateStack();
		}
	}

	// Remove head element from stack
	public void removeHead() {
		this.removeN(0);
	}

	// Remove tail element from stack
	public void removeTail() {
		this.removeN(this.size - 1);
	}

	// Remove head, pull everything else up
	public Object pop() {
		Object ret = this.head;
		this.removeN(0);
		return ret;
	}

	// Replace head, push everything else down
	public void push(Object o) {
		Object[] ar = new Object[this.size + 1];
		ar[0] = o;
		if (!isEmpty()) // If the stack is not empty copy the contents
			System.arraycopy(this.stack, 0, ar, 1, this.size);
		this.stack = ar;
		this.size++;
		updateStack();
	}

	// Print the stack in an easy-to-read fashion
	public void print_stack() {
		for (int i = 0; i < this.size; i++)
			System.out.println("pos: " + i + "\tobject: " + this.stack[i]);
	}
}