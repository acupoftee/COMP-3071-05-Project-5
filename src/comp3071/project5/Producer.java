package comp3071.project5.v2;

import java.util.Random;

/**
 * uses a run method to insert the values 1 through 10 in buffer
 * @author Bethy Diakabana
 * @author Bilgehan Saglik
 *
 */
public class Producer extends Thread {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;
	private final int numberOfCustomers;
	
	/**
	 * Initializes a new Producer
	 * @param sharedLocation a common buffer
	 */
	public Producer(Buffer sharedLocation, int numberOfCustomers) {
		this.sharedLocation = sharedLocation;
		this.numberOfCustomers = numberOfCustomers;
	} // end constructor 
	
	@Override
	public synchronized void run() {
		for (int i = 1; i <= numberOfCustomers; i++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.set(i);
				System.out.printf("Customer %d endtered fish queue\n",  i);
			} // end try
			catch (InterruptedException e) {
				e.printStackTrace();
			} // end catch
		} // end for
		System.out.println("Producer done producing\nTerminating Producer");
	} // end method run
} // end class Producer
