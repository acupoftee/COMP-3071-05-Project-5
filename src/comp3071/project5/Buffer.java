package comp3071.project5;

public interface Buffer {
	
	/**
	 * Places an <tt>int</tt> value into <tt>Buffer</tt>
	 * @param value an integer
	 * @throws InterruptedException
	 */
	public void set(int value) throws InterruptedException;
	
	/**
	 * retrieves an <tt>int</tt> value from <tt>Buffer</tt>
	 * @return an integer from buffer
	 * @throws InterruptedException
	 */
	public int get() throws InterruptedException;
} // end interface Buffer
