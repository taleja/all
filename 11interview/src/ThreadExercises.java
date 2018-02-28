/**
 * @author olena.viliuzhanina
 *
 */
public class ThreadExercises {

	private static String message;

	private static class MyThread extends Thread {
		@Override
		public void run() {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			message = "First message";
		}
	}

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			MyThread myThread = new MyThread();
			myThread.start();
			//myThread.join();
			message = "Second message";
			Thread.sleep(1000);
			System.out.println(message);
		}

	}

}
