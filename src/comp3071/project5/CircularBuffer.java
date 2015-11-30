package comp3071.project5;

public class CircularBuffer implements Buffer {
	private final int[] sharedBuffer = {-1, -1, -1};
	private int occupiedBufferCells = 0;
	private int elementToBeWritten = 0; 
	private int elementToBeRead = 0;

	@Override
	public synchronized void set(int value) throws InterruptedException {
		/* wait until buffer has space available, then write value.
		 * while no empty locations, place thread in blocked state.
		 */
		while (occupiedBufferCells == sharedBuffer.length) {
			System.out.printf("Employee windoes are taken. customers must wait.\n");
			wait(); // wait until buffer cell is free
		}
		
		sharedBuffer[elementToBeWritten] = value; // new buffer value
		
		// update circular index of element to be written
		elementToBeWritten = (elementToBeWritten + 1) % sharedBuffer.length;
		
		++occupiedBufferCells; // one more buffer cell is full
		displayState("Customer no. " + value + " lines up.");
		notifyAll(); // notify threads waiting to read from buffer
	}

	@Override
	public synchronized int get() throws InterruptedException {
		/* wait until buffer has data, then read value.
		 * while no data to read, place thread in waiting state.
		 */
		while (occupiedBufferCells == 0) {
			System.out.printf("Customers aren'tbeing served. Employees wait.\n");
			wait(); // wait until a buffer cell is filled
		}
		
		int readValue = sharedBuffer[elementToBeRead]; // value read from buffer
		
		// update circular index of elements to be read
		elementToBeRead = (elementToBeRead + 1) % sharedBuffer.length;
		
		--occupiedBufferCells; 
		displayState("Now serving, customer no. " + readValue);
		notifyAll();
		
		return readValue;
	}
	
	public void displayState(String operation) {
		System.out.printf("%s%s%d)\n%s", operation, 
				" (employee windows occupied: ", occupiedBufferCells, "windoes remainng: ");
		
		for (int i = 1; i <= sharedBuffer.length; i++)
			System.out.printf("#%d ", i);

		System.out.print("\n               ");
		
		for (int i = 0; i < sharedBuffer.length; i++)
			System.out.print("---- ");

		System.out.print("\n               ");
		
		for (int value : sharedBuffer)
			System.out.printf(" %2d ", value); // output values in buffer
		
		System.out.print("\n               ");
		
		for (int i = 0; i < sharedBuffer.length; i++)
			System.out.print("---- ");
		
		System.out.print("\n               ");
		
		for (int i = 0; i < sharedBuffer.length; i++) {
			if (i == elementToBeWritten && i == elementToBeRead)
				System.out.print(" TBS"); // both write and read index
			else if (i == elementToBeWritten)
				System.out.print(" EQ   "); // just write index
			else if (i == elementToBeRead)
				System.out.print("  S  "); // just read index
			else
				System.out.print("     ");  // neither
		}
		
		System.out.println("\n");
	}
}
