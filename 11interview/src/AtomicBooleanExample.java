import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author olena.viliuzhanina
 *
 */
public class AtomicBooleanExample {
	
	private static AtomicBoolean state = new AtomicBoolean(); 
	
	public static void main(String...args) {
		WorkerFirst wf = new WorkerFirst();
		WorkerSecond ws = new WorkerSecond();
		
		wf.start();
		ws.start();
	}
	
	private static class WorkerFirst extends Thread{
		@Override
		public void run() {
			while(true) {
				System.out.println("WorkerFist wating to someone set state to true. Current value: " + state.get());
				
				if(state.compareAndSet(true, false)) {
					System.out.println("Break loop");
					break;
				} else {
					System.out.println("+++++++"); 
				}
			}
			
		}
	}
	
	private static class WorkerSecond extends Thread{
		@Override
		public void run() {
			System.out.println("Current state " + state.get()); 
			System.out.println("Set new state: ");
			state.set(true);
			System.out.println("New state is: " + state.get()); 
		}
	}

}
