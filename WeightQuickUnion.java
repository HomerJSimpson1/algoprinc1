/**
 * 
 */
package algos.algo1princeton.week1;

/**
 * @author petersj
 *
 */
public class WeightQuickUnion {

	/**
	 * @param args
	 * QuickFind class for the Algorithms 1 class on Coursera.
	 */
	
	private int id[];
	
	public int[] getId() {
		return id;
	}

	public WeightQuickUnion(int N) {
		// Constructor for the WeightQuickUnion class
		this.id = new int[N];
		
		for (int i = 0; i < N; i++) {
			this.id[i] = i;
		}
	}
	
	
	// Insert WeightQuickUnion union and WeightQuickUnion connected Methods here.
	
	public boolean connected(int p, int q) {
		// Not sure what the difference is between quickFind and connected (which is
		// why their implementation here is the same.
		//return(this.id[p] == this.id[q]);
		return(findRoot(p) == findRoot(q));
	}
	
	private int findRoot(int p) {
		int i = p;
		int numIters = 0;
		
		// if p is outside the boundaries of the array, return -1 as an error flag.
		if ((p < 0) || (p > id.length))
			return(-1);
		
		while ((i > 0) && (i < id.length) && (id[i] != i) && (numIters < id.length) ) {
			// add i < id.length to ensure
			i = id[i];
			numIters++;
		}
		
		return(i);
	}
	
	
	
	public void union(int p, int q) {
		// Quick Find union operation.  For each entry in the array, if the id of the
		// element equals the id[p], set it equal to the id of q.
		//id[p] = id[q];
		//id[p] = findRoot(id[q]);
		int idp = findRoot(p);
		int idq = findRoot(q);
		id[idp] = idq;
	}
	
	public void printWQU() {
		for (int i = 0; i < id.length; i++) {
			System.out.print("i = " + i + ", id[i] = " + this.id[i] + "\n");
		}
	}
	
	
	public void printWQUSpace() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(this.id[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		WeightQuickUnion myWQU = new WeightQuickUnion(N);
		
//		for (int i = 0; i < N; i++) {
//			System.out.print("i = " + i + ", id[i] = " + myWQU.id[i] + "\n");
//		}
		
		//myWQU.printWQU();
		
		//System.out.println(myWQU.connected(1,  2));
		//System.out.println(myWQU.connected(1,  1));
		
//		myWQU.union(5, 0);
//		myWQU.union(6, 0);
//		myWQU.union(2, 1);
//		myWQU.union(7, 1);
//		myWQU.union(3, 8);
//		myWQU.union(4, 8);
//		myWQU.union(9, 8);
//		
//		myWQU.union(6, 1);
		
		myWQU.union(7, 1);
		myWQU.union(1, 9);
		myWQU.union(9, 5);
		myWQU.union(3, 5);
		myWQU.union(5, 2);
		myWQU.union(2, 6);
		myWQU.union(8, 0);
		
		
		myWQU.printWQUSpace();
		
		boolean connect = myWQU.connected(3, 7);
		System.out.println(connect);
		
		connect = myWQU.connected(1, 2);
		System.out.println(connect);
		
		connect = myWQU.connected(0, 9);
		System.out.println(connect);
		
		// Exercises 1 (Union Find) Question 1:
//		myWQU.union(1, 7);
//		myWQU.union(5, 6);
//		myWQU.union(5, 4);
//		myWQU.union(5, 9);
//		myWQU.union(0, 8);
//		myWQU.union(1, 5);
//		
//		myWQU.printWQU();
		
		
		
		//System.out.println();
		//myWQU.printWQU();
		
//		System.out.println(myWQU.connected(2, 7));
//		System.out.println(myWQU.connected(2, 8));
		
	}

}

