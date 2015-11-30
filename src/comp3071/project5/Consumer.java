package comp3071.project5.v2;

import java.util.Random;

/**
 * uses a run method to reads the values 1 through 10 in buffer
 * @author Bethy Diakabana
 * @author Bilgehan Saglik
 *
 */
public class Consumer extends Thread {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;
	private final int numberOfCustomers;
	
	/**
	 * Initializes a new Consumer
	 * @param sharedLocation a common buffer
	 */
	public Consumer(Buffer sharedLocation, int numberOfCustomers) {
		this.sharedLocation = sharedLocation;
		this.numberOfCustomers = numberOfCustomers;
	} // end constructor

	@Override
	public synchronized void run() {
	
		for(int i = 1; i <= numberOfCustomers; i++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.get();
				// System.out.printf("\t\t\t%2d\n", sum);
				System.out.printf("Customer %d left the fish queue\n", i);
			} // end try
			catch (InterruptedException e) {
				e.printStackTrace();
			} // end catch
		} // end for
		System.out.printf("\n%s %d\n%s\n", 
				"Employees have seen a total of", numberOfCustomers , "customers. Terminating Consumer");
	} // end method run
} // end class Consumer
