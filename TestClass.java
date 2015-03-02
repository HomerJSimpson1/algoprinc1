/**
 * 
 */
package mincuts;

/**
 * @author James User
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myText = "1	37	79	164	155	32	87	39	113	15	";
		String results[];
		
		results = myText.split("\t");
		
		//int myList[] = new int[results.length];
		for (String s : results) {
//			int i = 0;
			System.out.println(s);
//			myList[i] = Integer.parseInt(s);
//			System.out.println("i=" + i + " myList[i]= " + myList[i] + " ");
//			i++;
		}
		
		System.out.println(results.length);
		
//		for (int j = 0; j < myList.length; j++)
//			System.out.print(myList[j] + " ");
	}

}
