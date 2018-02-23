import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author olena.viliuzhanina
 *
 */
public class UnsynchronizedCounterTest {

	static Counter counter;
	static int numberOfinctements;
	
	public static class Counter{
		int count = 0;
		
		public void inc() {
			count = count + 1;
		}
		
		public int getCount() {
			return count;
		}
	} 
	
	public static class Worker extends Thread{
		
		@Override
		public void run() {
			for(int i = 0; i < numberOfinctements; i++){
				counter.inc();				
			}
		}
	} 
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		while(true) {
			System.out.println("How many threads do you want?");
			int numberOfThreads = in.nextInt();
			if(numberOfThreads < 0) {
				break;
			}
			
			System.out.println("How many number of increment do you want?"); 
			numberOfinctements = in.nextInt();
			if(numberOfinctements < 0) {
				break;
			}
			
			System.out.println("Working..."); 
			
			Worker[] workers = new Worker[numberOfThreads];
			counter = new Counter();
			
			for(int i = 0; i < numberOfThreads; i++) {
				workers[i] = new Worker();
			}
			
			for(int i = 0; i < numberOfThreads; i++) {
				workers[i].start();
			}
			
			for(int i = 0; i < numberOfThreads; i++) {
				try {
					workers[i].join();
				} catch (InterruptedException e) {}
			}
			
			System.out.println("Result: " + "\n" + "Counter: " + counter.getCount() + ", Increments: " + numberOfinctements); 
		}
		
	}

}
