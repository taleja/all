import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author olena.viliuzhanina
 *
 */
public class AtomicIntegerExample {

	private static AtomicInteger atmInt = new AtomicInteger(0);

	public static void main(String... args) {
		Thread tr1 = new Thread(new MyRunnuble());
		Thread tr2 = new Thread(new MyRunnuble());
		tr1.start();
		tr2.start();
	}

	public static class MyRunnuble implements Runnable {

		private int counter;
		private int previousCounter;
		private int counterPlusFife;
		private boolean isNine;

		@Override
		public void run() {
			counter = atmInt.incrementAndGet();
			System.out.println("Thread " + Thread.currentThread().getId() + ", Counter: " + counter);
			previousCounter = atmInt.getAndIncrement();
			System.out.println("Thread " + Thread.currentThread().getId() + ", Previous Counter: " + previousCounter);
			counterPlusFife = atmInt.addAndGet(5);
			System.out.println("Thread " + Thread.currentThread().getId() + ", Counter plus five: " + counterPlusFife);
			isNine = atmInt.compareAndSet(9, 3);
			if (isNine) {
				System.out.println("Thread " + Thread.currentThread().getId() + ", isNine true " + atmInt.intValue());
			} else {
				System.out.println("Not true");
			}

		}

	}
}
