package structure;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	
	public Stack() {}
	
	public void push(T val) {
		storage.addFirst(val);
	}
	
	public T pop() {
		return storage.removeFirst();
	}
	
	public T peek() {
		return storage.getFirst();
	}
	
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	
	public String toString() {
		return storage.toString();
	}
}
