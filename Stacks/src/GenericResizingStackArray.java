/**
 * @author Warosaurus
 */
public class GenericResizingStackArray<Item> {
	private Item[] s;
	private int n = 0;

	public GenericResizingStackArray() {
		s = (Item[]) new Object[1];
	}

	public boolean isEmpty(){
		return n == 0;
	}

	public void push(Item item) {
		if (n == s.length) resizeStack(2 * n);
		s[n++] = item;
	}

	private void resizeStack(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		System.arraycopy(s, 0, temp, 0, n);
		s = temp;
	}

	public Item pop() {
		return s[--n];
	}
}
