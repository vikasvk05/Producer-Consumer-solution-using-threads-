
public class CircularBuffer implements Buffer{
	private final int[] buffer = {-1,-1,-1};
	private int bufferFill = 0;
	private int writeIndex = 0;
	private int readIndex = 0;
	
	public synchronized void set(int value) throws InterruptedException {
		if(bufferFill == buffer.length) {
			System.out.println("Buffer Full,Producere waiting....");
			wait();
		}
		buffer[writeIndex] = value;
		writeIndex = (writeIndex + 1)% buffer.length;
		bufferFill++;
		displayState("Producer Write "+value);
		notifyAll();
	}
	@Override
	public synchronized int get() throws InterruptedException {
		if(bufferFill == 0) {
			System.out.println("Buffer Empty, Consumer waiting....");
			wait();
		}
		int valueRead = buffer[readIndex];
		readIndex = (readIndex + 1)%buffer.length;
		bufferFill--;
		displayState("Consumer Read "+valueRead);
		notifyAll();
		return valueRead;
	}
	void displayState(String str) {
		System.out.println(str+" (buffer cell occupied "+bufferFill+" buffer cells )");
		for(int v:buffer) {
			System.out.printf("%2d\t",v);
		}
		System.out.print( "\n" );
		for ( int i = 0; i < buffer.length; i++ )
			System.out.print( "----\t" );
		System.out.print( "\n" );
		for ( int i = 0; i < buffer.length; i++ )
		{
			if ( i == writeIndex && i == readIndex )
			System.out.print( " WR \t" ); // both write and read index
			else if ( i == writeIndex )
			System.out.print( "  W  \t" ); // just write index
			else if ( i == readIndex )
			System.out.print("  R  \t" ); // just read index
			else
			System.out.print("     \t" ); // neither index
		} // end for
		System.out.println( "\n" );
	}
}
