package comp3071.project5;

//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

public class CircularBufferTest {
	public static void main(String[] args) {
//		// creates thread pool with two threads
//		ExecutorService application = Executors.newCachedThreadPool();
//		
//		// creates CircularBuffer to store integers
//		CircularBuffer sharedLocation = new CircularBuffer();
//		
//		// display the initial state of the CircularBuffer
//		sharedLocation.displayState("Initial State");
//		
//		// execute the Producer and Consumer tasks
//		application.execute(new Producer(sharedLocation, 30));
//		application.execute(new Consumer(sharedLocation, 30));
//		
//		application.shutdown();
		CircularBuffer buffer = new CircularBuffer();
		
		System.out.println("Simulation Key");
		System.out.println("----------------------");
		System.out.println("EQ\t Entered Queue");
		System.out.println("TBS\t To Be Served");
		System.out.println("S\t Served");
		System.out.println();
		
		Producer produca = new Producer(buffer, 30);
		Consumer consuma = new Consumer(buffer, 30);
		
		produca.start();
		consuma.start();
		
	} // end main
} // end class CircularBufferTest
