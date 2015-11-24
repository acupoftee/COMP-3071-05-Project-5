package comp3071.project5;

import java.util.Random;

/**
 * uses a run method to reads the values 1 through 10 in buffer
 * @author Bethy Diakabana
 *
 */
public class Consumer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;
	private final int customerNumber;
	
	/**
	 * Initializes a new Consumer
	 * @param sharedLocation a common buffer
	 */
	public Consumer(Buffer sharedLocation, int customerNumber) {
		this.sharedLocation = sharedLocation;
		this.customerNumber = customerNumber;
	} // end constructor

	/**
	 * Inserts customers into an employee queue for a random amount of time
	 * 
	 */
	@Override
	public void run() {
		int sum = 0;
		
		for(int i = 1; i <= customerNumber; i++) {
			try {
				Thread.sleep(generator.nextInt(50000));
				sum += sharedLocation.get();
				//System.out.printf("\t\t\t%2d\n", sum);
				System.out.printf("Customer %d entered fish queue\n", customerNumber);
			} // end try
			catch (InterruptedException e) {
				e.printStackTrace();
			} // end catch
		} // end for
		System.out.printf("\n%s %d\n%s\n", 
				"Consumer read values totaling", sum , "Terminating Consumer");
	} // end method run
} // end class Consumer
