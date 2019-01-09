package design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingleTest {
	private long start, times;
	private int threadNums = 32;
	private ExecutorService exec = new ThreadPoolExecutor(threadNums, threadNums, 2, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

	@BeforeEach
	public void startEach() {
		start = System.currentTimeMillis();
	}

	@Test
	public void testSingle0() {
		System.out.print("Single0 ");
		for (int i = 0; i < threadNums; i++) {
			exec.execute(new Runnable() {
				public void run() {
					Single0 instance = Single0.getInstance();
					instance.show();
				}
			});
		}
	}
	
	@Test
	public void testSingle1() {
		System.out.print("Single1 ");
		for (int i = 0; i < threadNums; i++) {
			exec.execute(new Runnable() {
				public void run() {
					Single1 instance = Single1.getInstance();
					instance.show();
				}
			});
		}
	}
	
	@Test
	public void testSingle2() {
		System.out.print("Single2 ");
		for (int i = 0; i < threadNums; i++) {
			exec.execute(new Runnable() {
				public void run() {
					Single2 instance = Single2.getInstance();
					instance.show();
				}
			});
		}
	}
	
	@Test
	public void testSingle3() {
		System.out.print("Single3 ");
		for (int i = 0; i < threadNums; i++) {
			exec.execute(new Runnable() {
				public void run() {
					Single3 instance = Single3.getInstance();
					instance.show();
				}
			});
		}
	}
	
	@AfterEach
	public void finishEachTest() throws InterruptedException {
		exec.awaitTermination(1, TimeUnit.SECONDS);
		times = System.currentTimeMillis() - start - 1000;
		System.out.printf("Finish test, using %d milliseconds\n\n", times);
	}
}