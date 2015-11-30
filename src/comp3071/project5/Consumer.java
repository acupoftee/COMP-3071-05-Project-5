package comp3071.project5;

import java.util.Random;

/**
 * uses a run method to reads the values 1 through 10 in Queue
 * @author Bethy Diakabana
 * @author Bilgehan Saglik
 *
 */
public class Consumer extends Thread {
	private final static Random generator = new Random();
	private final Queue sharedLocation;
	private final int customerNumber;
	
	/**
	 * Initializes a new Consumer
	 * @param sharedLocation a common Queue
	 */
	public Consumer(Queue sharedLocation, int customerNumber) {
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
				System.out.printf("Customer %d left the fish queue\n", i);
			} // end try
			catch (InterruptedException e) {
				e.printStackTrace();
			} // end catch
		} // end for
		System.out.printf("\n%s %d\n%s\n", 
				"Consumer read values totaling", sum , "Terminating Consumer");
	} // end method run
} // end class Consumer
