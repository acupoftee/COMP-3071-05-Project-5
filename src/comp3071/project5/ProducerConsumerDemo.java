package comp3071.project5;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue buffa = new Queue(10);

		// *******************************************************
		// Create Producer and consumer objects, both attached to
		// the queue object
		// *******************************************************

		Producer produca = new Producer(buffa, 1);
		Consumer consuma = new Consumer(buffa, 1);

		produca.start(); // start producing & depositing items
		consuma.start(); // start fetching & consuming items

	}

}
