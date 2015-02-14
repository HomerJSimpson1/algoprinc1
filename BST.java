/**
 * 
 */
package algos.algo1princeton.week1;

/**
 * @author petersj
 *
 */
public class BST {

	/**
	 * Binary Search Algorithm
	 * 
	 * @param args
	 */
	
	private int low;
	private int high;
	private int myarray[];
	
	
	public BST(int lo, int hi, int myarr[]) {
		low = lo;
		high = hi;
		
		myarray = myarr;
	}
	
	
	public void bstInsert(int key, int value) {
		// Enter the insert code here.
	}
	
	
	public void bstDelete(int key) {
		// Enter the delete code here.
		 
		
	}
	
	public int bstSearch(int key) {
		low = 0;
		high = myarray.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < myarray[mid]) {
				high = mid - 1;
			}
			else if (key > myarray[mid]) {
				low = mid + 1;
			}
			else
				return(mid);
		}
		
		return(-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myarry[] = {0, 3, 14, 23, 35};
		BST myBST = new BST(0, 5, myarry);
		
		int result;
		result = myBST.bstSearch(14);
		System.out.println(result);
		
		result = myBST.bstSearch(35);
		System.out.println(result);
		
		result = myBST.bstSearch(0);
		System.out.println(result);
		
		result = myBST.bstSearch(13);
		System.out.println(result);
	}

}
