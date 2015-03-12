/**
 * 
 */
package sorting;

//import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;
//import java.Math.*;


/**
 * @author James Peterson
 *
 */
public class Quicksort1 {

	/**
	 * @param args
	 */
	
	private int myarray[];
	private int n;
	private Scanner input;
	private String fileName;
	private int numComparisons;
	private enum PivotChoice {FIRST, LAST, MEDIAN_OF_THREE, RANDOM};
	private PivotChoice pc;
	
	public int[] getMyarray() {
		return myarray;
	}

	public void setMyarray(int[] myarray) {
		this.myarray = myarray;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public int getNumComparisons() {
		return numComparisons;
	}

//	public void setNumComparisons(int numComparisons) {
//		this.numComparisons = numComparisons;
//	}
	
	public Quicksort1(int myarr[], int N, String fname, PivotChoice pc) {
		this.myarray = myarr;
		this.n = N;
		this.fileName = fname;
		this.numComparisons = 0;
		this.pc = pc;
	}
	
	public Quicksort1(int myarr[], int N, PivotChoice pc) {
		this.myarray = myarr;
		this.n = N;
		this.fileName = null;
		this.numComparisons = 0;
		this.pc = pc;
	}
	
	public Quicksort1(int N, String fname, PivotChoice pc) {
		this.myarray = new int[N];
		this.n = N;
		this.fileName = fname;
		this.numComparisons = 0;
		this.pc = pc;
	}
	
	public Quicksort1(int N, String fname) {
		this.myarray = new int[N];
		this.n = N;
		this.fileName = fname;
		this.numComparisons = 0;
		this.pc = PivotChoice.FIRST;
	}
	
	public Quicksort1() {
		this.n = 0;
		this.fileName = null;
		this.numComparisons = 0;
	}
	
//	public void TestArray(int testArray[]) {
//		// Testing to see if this only modifies a local copy
//		// Turns out it does modify the return array
//		testArray[0] += 10;
//	}
	
	public void readArray() {
		openFile();
		readData();
		closeFile();
	}
	
	private void openFile() {
		try {
			input = new Scanner(new File(fileName));
//			scanLine = new Scanner(input);
//			while (!input.eof())
//			String line = scanLine.nextLine();
		}
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error Opening File.");
			System.exit(1);
		}
//		finally {
//			input.close();
//		}
	}
	
	private void readData() {
		int i = 0;
		
		try {
			while(input.hasNext()) {
				if (i > n)
					myarray=Arrays.copyOf(myarray, myarray.length + 1);
				myarray[i] = input.nextInt();
				i++;
			}
		}
		catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}
		catch(IllegalStateException stateException) {
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
	}
	
	
	private void closeFile() {
		if (input != null)
			input.close();
	}
	
	public void printArray(int startFlag, int shortFlag) {
		// Use shortFlag to indicate not to print the entire array.
		// If shortFlag > 0, this indicates a stopping value (index)
		// of  where to stop printing the array.
		// Otherwise, print the entire array.
		
		int startValue, stopValue;
		
		if(startFlag > 0)
			startValue = startFlag;
		else
			startValue = 0;
		
		if(shortFlag > 0)
			stopValue = shortFlag;
		else
			stopValue = myarray.length;
		
		for (int i = startValue; i < stopValue; i++) {
			System.out.print(myarray[i] + " ");
		}
		
		//System.out.println(myarray[myarray.length - 1]);
	}
	
	
	public void runQS(int n, int left, int right) {
		if (n >= 1) {
			//int pivot = myarray[left];
			int pivPos;
			
			pivPos = choosePivot(n, left, right);
			//pivot = myarray[pivPos];
			swap(myarray, left, pivPos);
			int newpivpos = partition(left, right);
			//this.printArray(left, right);
			//System.out.println(newpivpos);
			
			numComparisons += n - 1;
			
			//runQS(arr[0:(pivot - 1)]);
			int nleft = newpivpos - left;
			int nright = right - newpivpos;
			runQS(nleft, left, newpivpos - 1);
			runQS(nright, newpivpos + 1, right);
		}
			
	}
	
	private int choosePivot(int n, int left, int right) {
		int piv;
		int midIndx;
		
		if (this.pc == PivotChoice.FIRST)
			piv = left;
		else if (this.pc == PivotChoice.LAST)
			piv = right;
		else if (this.pc == PivotChoice.MEDIAN_OF_THREE) {
			//first = myarray[left];
			// Only apply if n >= 3
			if (n >= 3) {
				// if n is even, it's floor(n/2) - 1. 
				// Otherwise (if n is odd), it's floor(n/2).
				if ((n % 2) == 0)
					midIndx = ((int) Math.floorDiv(n, 2)) - 1;
				else
					midIndx = (int) Math.floorDiv(n, 2);
				//mid = myarray[midIndx];
				//last = myarray[right];
				
				int mytemparr[] = {left, midIndx, right};
				String whichOne;
				whichOne = findMedian(mytemparr);
				if (whichOne == "first")
					piv = left;
				else if (whichOne == "middle")
					piv = midIndx;
				else
					piv = right;
			}
			else // n < 3
				if (myarray[left] > myarray[right])
					piv = right;
				else
					piv = left;
		}
		else
			piv = left;
		
		return(piv);
	}
	
	//private int findMedian(int intarr[]) {
	private String findMedian(int intarr[]) {
		// Assumes an integer array of length 3 is passed.
		//int midIndex;
//		int temp;
//		String tempStr;
//		String labels[] = {"first", "middle", "last"};
		
		if (intarr[0] < intarr[1]) { // 1st element is smaller than second.
			if(intarr[0] < intarr[2]) { // 1st element is smallest
				if (intarr[1] < intarr[2])
					return("middle");
				else
					return("last");
			}
			else // Then the 1st element is smaller than the 2nd but larger than the last element.
				return("first");
		}
		else { // 1st element is larger than the middle element.
			if(intarr[0] < intarr[2])
				return("first");
			else {
				if (intarr[1] < intarr[2])
					return("last");
				else
					return("middle");
			}
		}
		
//		// Sort the input values.
//		for (int i = 1; i < (intarr.length - 1); i++) {
//			for (int j = i + 1; i < intarr.length; i++) {
//				if (intarr[i] > intarr[j]) {
//					temp = intarr[i];
//					tempStr = labels[i];
//					intarr[i] = intarr[j];
//					labels[i] = labels[j];
//					intarr[j] = temp;
//					labels[j] = tempStr;
//				}
//			}
//		}
		
//		if ((intarr.length % 2) == 0) {
//			// Then array has even length
//			midIndex = ((int) Math.floorDiv(intarr.length, 2)) - 1;
//		}
//		else {
//			midIndex = (int) Math.floorDiv(intarr.length, 2);
//		}
		
		//return(midIndex);
		//return(labels[1]);
	}


	//private void partition(int[] arr, int left, int right) {
	private int partition(int left, int right) {
		//int pivot, i, j, start, pivPos;
		int pivot, i, j, start;
		
		//pivot = myarray[left];
		
		//pivPos = choosePivot(n, left, right);
		// //pivot = myarray[pivPos];
		//swap(myarray, left, pivPos);
		pivot = myarray[left];
		
		start = left + 1;
		i = start;
		
		for (j = start; j <= right; j++) {
			if (myarray[j] < pivot) {
				// Swap myarray[i] and myarray[j]
				swap(myarray, i, j);
				i++;
			}
		}
		
		swap(myarray, left, (i-1));
		
		return(i-1);
	}
	

	private void swap(int arr[], int a, int b) {
		int temp;
		
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int test[] = {1, 3, 5, 7, 9};
		//System.out.println(test.length);
		
		String filName = "C:/Users/James User/Downloads/QuickSort.txt";
		int arraySize = 10000;

		//Quicksort1 qs1 = new Quicksort1(test, 5);
		//Quicksort1 qs2 = new Quicksort1(arraySize, filName);
		//Quicksort1 qs2 = new Quicksort1(arraySize, filName, PivotChoice.FIRST);
		//Quicksort1 qs2 = new Quicksort1(arraySize, filName, PivotChoice.LAST);
		Quicksort1 qs2 = new Quicksort1(arraySize, filName, PivotChoice.MEDIAN_OF_THREE);
		qs2.readArray();
		//qs2.printArray(0, 10);
		
		qs2.runQS(arraySize, 0, arraySize - 1);
		
		qs2.printArray(0, 100);
		System.out.println();
		qs2.printArray(arraySize - 100, arraySize);
		System.out.println();
		System.out.println(qs2.getNumComparisons());
		
//		qs1.TestArray(test);
//		
//		for (int i = 0; i < test.length; i++) {
//			System.out.print(test[i] + " ");
//		}
		
	}

}
