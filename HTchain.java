/**
 * 
 */
package hashtables;

/**
 * @author James User
 *
 */
public class HTchain {

	/**
	 * @param args
	 */
	
	private NodeArray ht[];
	private int a1, a2, a3, a4; // randomly selected coefficients for hashing
	private int capacity;
	private int size;
	private static final double MAX_LOAD = 0.7;
	//private double load;  // use a function to calculate it instead
	
	
	private class Node {
		int key;
		// Add other Node elements
		
		Node(int key) {
			this.key = key;
		}
	}
	
	private class NodeArray {
		// Using chaining Hash Table Implementation
		// array of keys to hold multiple elements to handle collisions
		int Nodes[];
		int size;
		
		NodeArray() {
			this.size = 0;
			
		}
	}
	
	public HTchain(int size) {
		// constructor
		this.size = size;
		// Need to implement a function to find the largest prime
		// greater than 2*size
		capacity = 2*size;  
		this.ht = new NodeArray[capacity];
	}
	
	
	public HTchain(HTchain otherHT) {
		// copy constructor
		
	}
	
	
	public double getLoad() {
		return(size/capacity);
	}
	
	private void checkLoad() {
		if (getLoad() >= MAX_LOAD) {
			capacity = 2 * capacity;
			//for(int i = 0; i < )
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
