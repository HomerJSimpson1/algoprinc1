/**
 * 
 */
package dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

//import mincuts.Graph.Node;

/**
 * @author James
 *
 */
public class HeapDijkstra {

	/**
	 * @param args
	 */
	
	private class Node {
		int nodeNum;
		//int edgeWeight;
		//int adjList[];
		Edge adjList[];
		boolean visited;
		
		
		// CONSTRUCTORS:
		
		// Default constructor
		Node() {
			this.visited=false;
		}
		
		// Other constructors
		Node(int nodeNum) {
			this.nodeNum = nodeNum;
			//this.edgeWeight = 1;
			this.visited = false;
		}
		
		Node(int nodeNum, int edgeWeight) {
			this.nodeNum = nodeNum;
			//this.edgeWeight = edgeWeight;
			this.visited = false;
		}
		
		Node(int nodeNum, int edgeWeight, Edge adjList[]) {
			this.nodeNum = nodeNum;
			//this.edgeWeight = edgeWeight;
			this.adjList = adjList;
			this.visited = false;
		}
		
    	public void printNode() {
    		//System.out.print("Key=" + nodeNum + " with weight = " + edgeWeight);
    		System.out.print("Key=" + nodeNum);
    		System.out.print(" Visited = " + visited + ": ");
    		for (int i = 0; i < adjList.length; i++)
    			//System.out.print("destNodeNum = " + adjList[i].destNodeNum + " with weight " + adjList[i].edgeWeight + " ");
    			adjList[i].printEdge();
    		System.out.println();
    	}
	} // end class Node definition
	
	
	
	//private class Edge implements Comparable<Edge>{
	private class Edge {
		private int destNodeNum;
		private int edgeWeight;
		//private Integer edgeWeight;
		
		public Edge() {
			destNodeNum = -1;
			edgeWeight = 1;
		}
		
		public Edge(int destNodeNum, int edgeWeight) {
			this.destNodeNum = destNodeNum;
			this.edgeWeight = edgeWeight;
		}
		
//		@Override
//		public int compareTo(Edge other) {
////			int retVal;
//			
////			if (this.edgeWeight < other.edgeWeight)
////				retVal = -1;
////			else if (this.edgeWeight == other.edgeWeight)
////				retVal = 0;
////			else
////				retVal = 1;
////			
////			return(retVal);
//			
//			return(this.edgeWeight.compareTo(other.edgeWeight));
//			
//		}
		
		public void printEdge() {
			System.out.print("destNodeNum = " + this.destNodeNum + " with edge weight = " + this.edgeWeight + " ");
		}
		
	}
	
    private Node graph[];
    private String fileName;
    private Scanner input;
    private int n; // graph size
    // heap of edges, used for finding next vertex to mark as visited.
    private Edge dheap[];
    
    
    
    public Node[] getGraph() {
    	return graph;
    }

    public String getFileName() {
    	return fileName;
    }

    public int getN() {
    	return n;
    }

    public HeapDijkstra(String fname, int graphSize) {
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
    	String token[];
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
    			newNode.nodeNum = Integer.parseInt(tokens[0]);
    			newNode.adjList = new Edge[tokens.length - 1];
    			for (int j = 1; j < tokens.length; j++) {
    				token = tokens[j].split(",");
    				Edge myEdge = new Edge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
    				newNode.adjList[j - 1] = myEdge;
    				//newNode.adjList[j - 1] = Integer.parseInt(tokens[j]);
    				//newNode.adjList[j - 1].destNodeNum = Integer.parseInt(token[0]);
    				//newNode.adjList[j - 1].edgeWeight = Integer.parseInt(token[1]);
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
    	//for (int i = 0; i < graph.length / 2; i++) {
    		if (graph[i] != null)
    			graph[i].printNode();
    	}
    	
    	Edge anEdge = new Edge(2, 25);
    	Edge anotherEdge = new Edge(3, 15);
    	
    	System.out.println(anEdge.edgeWeight > anotherEdge.edgeWeight);
    }
    
    ///*
    private void bubbleup(int indx) {
    	int parent;
    	Edge temp;
    	
    	parent = (int) Math.floorDiv((indx - 1), 2);
    	
    	while(dheap[parent].edgeWeight > dheap[indx].edgeWeight) {
    		temp = dheap[indx];
    		dheap[indx] = dheap[parent];
    		dheap[parent] = temp;
    		
    		indx = parent;
    		parent = (int) Math.floorDiv((indx - 1), 2);
    	}
    }
    //*/
    
    
    private void bubbledown(int indx) {
    	// Still need to implement
    	// Used when getting the min node (at the root).
    	// Used to maintain invariants after removing the root node.
    	int child1, child2, toSwap;
    	Edge temp;
    	
    	child1 = 2*indx + 1;
    	child2 = 2*indx + 2;
    	
    	// NEED TO ADD CODE TO CHECK TO SEE IF THE CHILDREN ARE 
    	// OUTSIDE THE BOUNDS OF THE HEAP ARRAY!!!!!!!
    	
    	while((dheap[child1].edgeWeight < dheap[indx].edgeWeight) || (dheap[child2].edgeWeight < dheap[indx].edgeWeight)) {
    		if (dheap[child1].edgeWeight <= dheap[child2].edgeWeight) {
    			// swap the smaller child with the parent (given by indx)
    			toSwap = child1;
    		}
    		else
    			toSwap = child2;
    		
    		temp = dheap[indx];
    		dheap[indx] = dheap[toSwap];
    		dheap[toSwap] = temp;
    		
    		indx = toSwap;
        	child1 = 2*indx + 1;
        	child2 = 2*indx + 2;
    	} // end while loop
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filName = "C:/Users/James User/Downloads/dijkstraData.txt";
		int graphSz = 200;
		
		HeapDijkstra hdijk = new HeapDijkstra(filName, graphSz);
		hdijk.readGraphFromFile();
		System.out.println(hdijk.getFileName());
    	System.out.println(hdijk.getN());
    	hdijk.printGraph();
    	
//    	System.out.println((int) Math.floor(1));
//    	System.out.println((int) Math.floor(1.5));
//    	System.out.println(Math.floorDiv(9, 2));
    	
    	//Edge anEdge = new Edge(2, 25);
    	//Edge anotherEdge = new Edge(3, 15);
    	
	}

}
