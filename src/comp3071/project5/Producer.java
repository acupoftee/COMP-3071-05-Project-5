package comp3071.project5;

import java.util.Random;

/**
 * Class <tt>Producer</tt> uses a run method to insert customers
 * a service queue after taking a number, and is served for 
 * a random amount of time.
 * @author Bethy Diakabana
 * @author Bilgehan Saglik
 */
public class Producer extends Thread {
	private final static Random generator = new Random();
	private final Queue sharedLocation;
	private final int customerNumber;

	/**
	 * Initializes a new Producer
	 * @param sharedLocation a common Queue
	 */
	public Producer(Queue sharedLocation, int customerNumber) {
		this.sharedLocation = sharedLocation;
		this.customerNumber = customerNumber;
	} // end constructor 
	
	/**
	 * Inserts customers into an employee queue for a random amount of time
	 * 
	 */
	@Override
	public void run() {
		//int sum = 0;
		for (int i = 1; i <= customerNumber; i++) {
			try {
				Thread.sleep(generator.nextInt(50000));
				sharedLocation.set(i);
				//sum += i;
				//System.out.printf("\t%2d\n",  sum);
				System.out.printf("Customer %d entered fish queue\n", customerNumber);
			} // end try
			catch (InterruptedException e) {
				e.printStackTrace();
			} // end catch
		} // end for
		System.out.println("No more customers to serve.");
	} // end method run
} // end class Producer
