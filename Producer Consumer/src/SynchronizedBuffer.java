
public class SynchronizedBuffer implements Buffer{

	private int buffer = -1;
	private boolean flag = false;
	
	@Override
	public synchronized void set(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println("Producer Tries to write");
			displayState("Buffer Full Producer wait...");
			wait();
		}
		buffer = value;
		flag = true;
		displayState("Producer write "+buffer);
		notifyAll();
	}

	@Override
	public synchronized int get() throws InterruptedException {
		// TODO Auto-generated method stub
		while(!flag) {
			System.out.println("Consumer tries to read");
			displayState("Buffer Empty,Consumer wait...");
			wait();
		}
		flag = false;
		displayState("Consumer Read "+buffer);
		notifyAll();
		return buffer;
	}
	
	public  void displayState(String string) {
		// TODO Auto-generated method stub
		System.out.printf( "%-40s%d\t\t%b\n\n", string, buffer,flag );
		
	}
}
