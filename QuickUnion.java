/**
 * 
 */
package algos.algo1princeton.week1;

/**
 * @author petersj
 *
 */
public class QuickUnion {

	/**
	 * @param args
	 * QuickFind class for the Algorithms 1 class on Coursera.
	 */
	
	private int id[];
	
	public int[] getId() {
		return id;
	}

	public QuickUnion(int N) {
		// Constructor for the QuickUnion class
		this.id = new int[N];
		
		for (int i = 0; i < N; i++) {
			this.id[i] = i;
		}
	}
	
	
	// Insert QuickUnion union and QuickUnion connected Methods here.
	
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
	
	public void printQU() {
		for (int i = 0; i < id.length; i++) {
			System.out.print("i = " + i + ", id[i] = " + this.id[i] + "\n");
		}
	}
	
	
	public void printQUSpace() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(this.id[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		QuickUnion myQU = new QuickUnion(N);
		
//		for (int i = 0; i < N; i++) {
//			System.out.print("i = " + i + ", id[i] = " + myQU.id[i] + "\n");
//		}
		
		//myQU.printQU();
		
		//System.out.println(myQU.connected(1,  2));
		//System.out.println(myQU.connected(1,  1));
		
//		myQU.union(5, 0);
//		myQU.union(6, 0);
//		myQU.union(2, 1);
//		myQU.union(7, 1);
//		myQU.union(3, 8);
//		myQU.union(4, 8);
//		myQU.union(9, 8);
//		
//		myQU.union(6, 1);
		
//		myQU.union(7, 1);
//		myQU.union(1, 9);
//		myQU.union(9, 5);
//		myQU.union(3, 5);
//		myQU.union(5, 2);
//		myQU.union(2, 6);
//		myQU.union(8, 0);
		
		myQU.union(4, 3);
		myQU.union(3, 8);
		myQU.union(6, 5);
		myQU.union(9, 4);
		myQU.union(2, 1);
		//myQU.union(p, q);
		
		myQU.printQUSpace();
		
		boolean connect;
//		connect = myQU.connected(3, 7);
//		System.out.println(connect);
//		
//		connect = myQU.connected(1, 2);
//		System.out.println(connect);
//		
//		connect = myQU.connected(0, 9);
//		System.out.println(connect);
		
		connect = myQU.connected(8, 9);
		System.out.println(connect);
		
		connect = myQU.connected(5, 4);
		System.out.println(connect);
		
		myQU.union(5, 0);
		myQU.union(7, 2);
		myQU.union(6, 1);
		myQU.union(7, 3);
		
		myQU.printQUSpace();
		
		
		// Exercises 1 (Union Find) Question 1:
//		myQU.union(1, 7);
//		myQU.union(5, 6);
//		myQU.union(5, 4);
//		myQU.union(5, 9);
//		myQU.union(0, 8);
//		myQU.union(1, 5);
//		
//		myQU.printQU();
		
		
		
		//System.out.println();
		//myQU.printQU();
		
//		System.out.println(myQU.connected(2, 7));
//		System.out.println(myQU.connected(2, 8));
		
	}

}
