//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//public class SharedBufferTest2 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ExecutorService ob = Executors.newCachedThreadPool();
//		Buffer sharedLoc = new SynchronizedBuffer();
//		System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation",
//				"Buffer", "Occupied", "---------", "------\t\t--------" );
//		ob.execute(new Producer(sharedLoc));
//		ob.execute(new Consumer(sharedLoc));
//		ob.shutdown();
//	}
//}
