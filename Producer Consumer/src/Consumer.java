import java.util.Random;
public class Consumer implements Runnable {

	private final static Random time = new Random();
	private final Buffer sharedLoc ;
	public Consumer(Buffer ob) {
		sharedLoc = ob;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum =0;
		for(int i =1;i<=10;i++) {
			try {
				Thread.sleep(time.nextInt(2000));
				sum += sharedLoc.get();
				//System.out.printf("\t%2d\n",sum);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.printf( "\n%s %d\n%s\n","Consumer read values totaling", sum, "Terminating Consumer...." );
	}
}
