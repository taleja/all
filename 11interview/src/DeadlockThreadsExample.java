
/**
 * @author olena.viliuzhanina
 *
 */
public class DeadlockThreadsExample {
	
	private static String lock1 = "lock_1";
	private static String lock2 = "lock_2";
	
	public static void main(String[] args) {
		WorkerFirst wf = new WorkerFirst();
		WorkerSecond ws = new WorkerSecond();
		
		wf.start();
		ws.start();
	}

	private static class WorkerFirst extends Thread{
		
		public WorkerFirst() {};
		
		@Override
		public void run(){
			synchronized (lock1) {
				System.out.println("WorkerFirst uses lock_1"); 
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException exp) {
					
				}
				synchronized (lock2) {
					System.out.println("Waiting for WorkerSecond"); 
				}
			}			
		}
	}
	
	private static class WorkerSecond extends Thread{
		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println("WorkerSecond uses lock_2");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException exp) {
					
				}
				synchronized (lock1) {
					System.out.println("Waiting for WorkerOne"); 
				}
			}			
		}
	}	
}
