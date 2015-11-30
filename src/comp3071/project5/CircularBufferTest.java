package comp3071.project5;

public class CircularBufferTest {
	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer();
		
		System.out.println("Simulation Key");
		System.out.println("----------------------");
		System.out.println("EQ\t Entered Queue");
		System.out.println("TBS\t To Be Served");
		System.out.println("S\t Served");
		System.out.println();
		
		Producer produca = new Producer(buffer, 30);
		Consumer consuma = new Consumer(buffer, 5);
		
		produca.start();
		consuma.start();
		
	}
}
