package comp3071.project5;
/**
 * Buffer implementation
 * @author Bethy Diakabana
 * @author Bilgehan Saglik
 *
 */
public class Queue implements Buffer {
	
	private int[] que;
	private int nextIn, nextOut, filled, queSize;

	public Queue(int size) {
		que = new int[size];
		filled = 0;
		nextIn = nextOut = 0;
		queSize = size;
	}
	
	public boolean empty() {
		return (filled == 0);
	}
	
	public boolean full() {
		return (filled == queSize);
	}
	
	@Override
	public void set(int value) throws InterruptedException {
		try {
			while (full()){
				System.out.println("FULL");
				wait();
				
			}
			que[nextIn] = value;
			nextIn = (nextIn + 1) % queSize;
			filled++;

			notifyAll();
		} catch (InterruptedException e) {
		}

	}

	@Override
	public int get() throws InterruptedException {
		int item = 0;
		try {
			// nothing in queue
			while (empty()){
				System.out.println("EMPTY");
				wait();
			}
			item = que[nextOut];
			nextOut = (nextOut + 1) % queSize;
			filled--;

			notifyAll();
		} catch (InterruptedException e) {
		}

		return item;
	}

}
