/**
 * 
 */
package algos.algo1princeton.week1;

/**
 * @author petersj
 *
 */
public class QuickFind {

	/**
	 * @param args
	 * QuickFind class for the Algorithms 1 class on Coursera.
	 */
	
	private int id[];
	//private int N;
	
	public int[] getId() {
		return id;
	}

//	public int getN() {
//		return N;
//	}

	public QuickFind(int N) {
		// Constructor for the QuickFind class
		//this.N = N;
		this.id = new int[N];
		
		for (int i = 0; i < N; i++) {
			this.id[i] = i;
		}
	}
	
	
	// Insert Quick Find union and Quick Find connected Methods here.
	
	public boolean connected(int p, int q) {
		// Not sure what the difference is between quickFind and connected (which is
		// why their implementation here is the same.
		return(this.id[p] == this.id[q]);
	}
	
	public void union(int p, int q) {
		// Quick Find union operation.  For each entry in the array, if the id of the
		// element equals the id[p], set it equal to the id of q.
		int idp = id[p];
		int idq = id[q];
		
		for (int i = 0; i < id.length; i ++) {
			if (id[i] == idp)
				id[i] = idq;
		}
	}
	
	public void printQF() {
		for (int i = 0; i < id.length; i++) {
			System.out.print("i = " + i + ", id[i] = " + this.id[i] + "\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		WeightQuickUnion myQF = new WeightQuickUnion(N);
		
//		for (int i = 0; i < N; i++) {
//			System.out.print("i = " + i + ", id[i] = " + myQUF.id[i] + "\n");
//		}
		
		//myQF.printQF();
		
		//System.out.println(myQF.connected(1,  2));
		//System.out.println(myQF.connected(1,  1));
		
//		myQF.union(5, 0);
//		myQF.union(6, 0);
//		myQF.uUnion(2, 1);
//		myQF.union(7, 1);
//		myQF.union(3, 8);
//		myQF.union(4, 8);
//		myQF.union(9, 8);
//		
//		myQF.union(6, 1);
		
		// Exercises 1 (Union Find) Question 1:
		myQF.union(1, 7);
		myQF.union(5, 6);
		myQF.union(5, 4);
		myQF.union(5, 9);
		myQF.union(0, 8);
		myQF.union(1, 5);
		
		myQF.printWQU();
		
		
		
		//System.out.println();
		//myQF.printQF();
		
//		System.out.println(myQF.connected(2, 7));
//		System.out.println(myQF.connected(2, 8));
		
	}

}
