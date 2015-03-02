/**
 * 
 */
package mincuts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author James User
 *
 */
public class Graph0 {

	/**
	 * @param args
	 */
	
	private class Node {
		int key;
		int adjlist[];
		
		public void printNode() {
			System.out.print("Key=" + key + " ");
			for (int i = 0; i < adjlist.length; i++)
				System.out.print(adjlist[i] + " ");
			System.out.println();
		}
	}
	
	private Node graph[];
	private String fileName;
	private Scanner input;
	private int n;  // graph size
	
	public Node[] getGraph() {
		return graph;
	}

	public String getFileName() {
		return fileName;
	}

	public int getN() {
		return n;
	}

	public Graph0(String fname, int graphSize) {
		this.fileName = fname;
		this.n = graphSize;
		this.graph = new Node[graphSize];
	}
	
	public void readGraphFromFile() {
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
		String inputLine;
		String tokens[];
		
		Node newNode;
		
		try {
			while(input.hasNext()) {
				if (i > n) {
//					myarray=Arrays.copyOf(myarray, myarray.length + 1);
					graph=Arrays.copyOf(graph, graph.length + 1);
				}
//				myarray[i] = input.nextInt();
				newNode = new Node();
				inputLine = input.nextLine();
				tokens = inputLine.split("\t");
				
				newNode.key = Integer.parseInt(tokens[0]);
				newNode.adjlist = new int[tokens.length - 1];
				for (int j = 1; j < tokens.length; j++) {
					newNode.adjlist[j - 1] = Integer.parseInt(tokens[j]);
				}
				
				graph[i] = newNode;
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
	
	public void printGraph() {
		for (int i = 0; i < graph.length; i++) {
			graph[i].printNode();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filName = "C:/Users/James User/Downloads/kargerMinCut.txt";
		int graphSz = 200;
		Graph0 myGraph = new Graph0(filName, graphSz);
		
		myGraph.readGraphFromFile();
		System.out.println(myGraph.getFileName());
		System.out.println(myGraph.getN());
		//System.out.print(myGraph.getGraph());
		myGraph.printGraph();
	}

}
