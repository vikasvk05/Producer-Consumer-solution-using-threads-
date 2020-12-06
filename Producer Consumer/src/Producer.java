import java.util.Random;
public class Producer implements Runnable{

	private final static Random time = new Random();
	private final Buffer sharedLoc ;
	public Producer(Buffer ob) {
		sharedLoc = ob;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum =0;
		for(int i =1;i<=10;i++) {
			try {
				Thread.sleep(time.nextInt(5000));
				sharedLoc.set(i);
				sum += i;
				//System.out.printf("\t%2d\n",sum);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total Produced Value:"+sum);
		System.out.println("Producer done producing and Turminated ....");
	}
	
}
