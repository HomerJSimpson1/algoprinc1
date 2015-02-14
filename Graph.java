package algos.algo1princeton.week1;
/**
* 
*/

//ackage mincuts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;

/**
* @author James User
*
*/

public class Graph {
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
    private int n; // graph size
    private Random rand = new Random();

    public Node[] getGraph() {
    	return graph;
    }

    public String getFileName() {
    	return fileName;
    }

    public int getN() {
    	return n;
    }

    public Graph(String fname, int graphSize) {
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
    		// scanLine = new Scanner(input);
    		// while (!input.eof())
    		// String line = scanLine.nextLine();
    	}
    	catch (FileNotFoundException fileNotFoundException) {
    		System.err.println("Error Opening File.");
    		System.exit(1);
    	}
    	// finally {
    	// input.close();
    	// }
    }

    private void readData() {
    	int i = 0;
    	String inputLine;
    	String tokens[];
    	Node newNode;
	
    	try {
    		while(input.hasNext()) {
    			if (i > n) {
    				// myarray=Arrays.copyOf(myarray, myarray.length + 1);
    				graph=Arrays.copyOf(graph, graph.length + 1);
    			}
    			// myarray[i] = input.nextInt();
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
    
    
    //@SuppressWarnings("unused")
	private int[] pickRandomEdge() {
    	// Selects an edge in the graph at random to be "contracted" (i.e. merge the 2
    	// endpoints of the edge into a single node.
    	// Returns an array of 2 elements. The first corresponds to an index in the graph array.
    	// The second return value corresponds to a randomly-chosen element of the first choice's 
    	// adjacency list.  More precisely, it is an index into that adjacency list.
    	// 
    	
    	int retvals[] = new int[2];
    	int randNode1, randNode2;
    	int adjListLength;
    	
    	randNode1 = randInt(0, graph.length);
    	adjListLength = graph[randNode1].adjlist.length;
    	randNode2 = randInt(0, adjListLength);
    	
    	retvals[0] = randNode1;
    	retvals[1] = randNode2;
    	
    	return(retvals);
    }
    
    
    /**
     * Returns a pseudo-random value between min and max, inclusive.
     * The difference between min and max can be at most:
     * <code>Integer.MAX_VALUE - 1</code>.
     * 
     * @param min Minimum value
     * @param max Maximum value
     * @return Integer between min and max, inclusive
     * @see java.util.Random#nextInt(int)
     */
    private int randInt(int min, int max) {
    	// NOTE: This (rand) is a class variable rather than a method variable
    	// so that it is not re-seeded every call.
    	int randomNum;
    	
    	randomNum = rand.nextInt((max - min) + 1) + min;
    	return(randomNum);
    }
    

    private void contractNodes(int nodesToContract[]) {
    	// Contract the 2 nodes provided in the nodesToContract input parameter (an array)
    	// into a single "super node."
    	// So we need to concatenate their adjacency lists, WITHOUT eliminating duplicates
    	// (because we're allowing parallel edges), and remove any self-loops.
    	
    	
    }
    
    private void removeSelfLoops(int edgeNodes[]) {
    	// edgeNodes is an array of 2 elements.
    	// The first is the index of a key of a node in the graph, and the second element is
    	// the index of an element of its adjacency list.  This function is called when the
    	// two nodes are being joined into a single node ("contracted").
    	
    	// Maybe this should be performed within the contractNodes() function in 
    	// order to not repeatedly copy arrays?
    	int key;
    	int adjListLength;
    	
    	key = edgeNodes[0];
    	adjListLength = graph[key].adjlist.length;
    	for (int j = 0; j < adjListLength; j++) {
    		if (graph[key].adjlist[j] == graph[key].key) {
    			// Then there is a self loop
    			// Remove the element from the adjacency list.
    			for (int k = j; k < adjListLength; k++) {
    				
    			}
    		}
    			
    	}
    	
    	
    }
    
    public void randContract() {
    	// Class method used to run the Random Contraction Algorithm.
    	
    	int nextEdge[];

    	// Pick an edge at random to eliminate from the graph.
    	nextEdge = pickRandomEdge();
    	
    	// Contract the two nodes of the randomly selected edge into a single "super node."
    	//contractNodes(nextEdge);
    	
    	// Remove self loops
    	//removeSelfLoops(nextEdge);
    	
    	// Some print statements to test out functionality.
    	System.out.println();
    	System.out.print(nextEdge[0] + " " + graph[nextEdge[0]].key + " ");
    	System.out.print(nextEdge[1] + " " + graph[nextEdge[0]].adjlist[nextEdge[1]]);
    }
    
    
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	//String filName = "C:/Users/James User/Downloads/kargerMinCut.txt";
    	String filName = "C:/Users/petersj/Downloads/kargerMinCut.txt";
    	int graphSz = 200;
    	Graph myGraph = new Graph(filName, graphSz);
    	myGraph.readGraphFromFile();
    	System.out.println(myGraph.getFileName());
    	System.out.println(myGraph.getN());
    	//System.out.print(myGraph.getGraph());
    	myGraph.printGraph();
    	
    	myGraph.randContract();
    }
}
