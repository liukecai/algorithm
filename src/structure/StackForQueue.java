package structure;

import java.util.NoSuchElementException;

public class StackForQueue<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public StackForQueue() {}
	
	public T getHead() {
		if (!stack2.isEmpty())
			return stack2.peek();
		else {
			stack1to2();
			return stack2.peek();
		}
	}
	
	public T deQueue() {
		if (!stack2.isEmpty())
			return stack2.pop();
		else {
			if (stack1.isEmpty())
				throw new NoSuchElementException("Queue is empty.");
			stack1to2();
			return stack2.pop();
		}
	}
	
	public void enQueue(T val) {
		stack1.push(val);
	}
	
	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty())
			return true;
		else
			return false;
	}
	
	private void stack1to2() {
		while (!stack1.isEmpty()) 
			stack2.push(stack1.pop());
	}
}
