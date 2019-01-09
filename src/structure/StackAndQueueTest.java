package structure;

public class StackAndQueueTest {
	private Integer[] arrays = new Integer[20];
	private Stack<Integer> stack = new Stack<Integer>();
	private StackForQueue<Integer> queue = new StackForQueue<Integer>();
	
	
	public void start() {
		for (int i = 0; i < 20; i++)
			arrays[i] = i;
		System.out.println("Start test");
	}
	

	public void testStack() {
		System.out.print("Test stack: ");
		for (Integer i : arrays)
			stack.push(i);
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
	}
	

	public void testQueue() {
		System.out.print("Test queue: ");
		for (Integer i : arrays)
			queue.enQueue(i);
		while (!queue.isEmpty())
			System.out.print(queue.deQueue() + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		StackAndQueueTest test = new StackAndQueueTest();
		test.start();
		test.testStack();
		test.testQueue();
	}
	
}
