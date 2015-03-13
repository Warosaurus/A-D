/**
 * @author Warosaurus
 */
public class GenericFixedCapacityStackArray<Item> {

	private Item[] s;
	private int n = 0;

	public GenericFixedCapacityStackArray(int capacity) {
		s = (Item[]) new Object[capacity]; // Type casting from Object array to Item array will most likely cause a warning since, type Item cannot be determined at compile time.
	}

	public boolean isEmpty(){
		return n == 0;
	}

	public void push(Item item) {
		s[n++] = item;
	}

	public Item pop() {
		return s[--n];
	}
}
