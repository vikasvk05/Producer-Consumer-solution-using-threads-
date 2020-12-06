import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class CircularBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService ob = Executors.newCachedThreadPool();
		CircularBuffer sharedLoc = new CircularBuffer();
		sharedLoc.displayState("Initial State");
		ob.execute(new Producer(sharedLoc));
		ob.execute(new Consumer(sharedLoc));
		ob.shutdown();
	}

}
