// Java program for Prim's MST for 
// adjacency list representation of graph 
import java.util.LinkedList; 
import java.util.TreeSet; 
import java.util.Comparator; 

@SuppressWarnings({"deprecation","unchecked","rawtypes"})
public class prim 
{ 
	class node
	{ 

		// Stores destination vertex in adjacency list 
		int dest; 

		// Stores weight of a vertex in the adjacency list 
		int weight; 

		// Constructor 
		node(int a, int b) 
		{ 
			dest = a;
			weight = b;
		} 
	} 
	static class Graph 
	{ 

		// Number of vertices in the graph 
		int V; 

		// List of adjacent nodes of a given vertex 
		LinkedList<node>[] adj; 

		// Constructor 
		Graph(int e) 
		{ 
			V = e; 
			adj = new LinkedList[V]; 
			for (int o = 0; o < V; o++) 
				adj[o] = new LinkedList<>(); 
		} 
	} 

	// class to represent a node in PriorityQueue 
	// Stores a vertex and its corresponding 
	// key value 
	class element 
	{ 
		int vertex; 
		int key; 
	} 

	// Comparator class created for PriorityQueue 
	// returns 1 if node0.key > node1.key 
	// returns 0 if node0.key < node1.key and 
	// returns -1 otherwise 
	class comparator implements Comparator<element> 
	{ 

		@Override
		public int compare(element e0, element e1) 
		{ 
			return e0.key - e1.key; 
		} 
	} 

	// method to add an edge 
	// between two vertices 
	void addEdge(Graph graph, int src, int dest, int weight) 
	{ 

		node node0 = new node(dest, weight); 
		node node1 = new node(src, weight); 
		graph.adj[src].addLast(node0); 
		graph.adj[dest].addLast(node1); 
	} 

	// method used to find the mst 
	void prims_mst(Graph graph) 
	{ 

		// Whether a vertex is in PriorityQueue or not 
		Boolean[] mstset = new Boolean[graph.V];

		element[] e = new element[graph.V]; 

		// Stores the parents of a vertex 
		int[] parent = new int[graph.V]; 

		for (int o = 0; o < graph.V; o++) 
			e[o] = new element(); 

		for (int o = 0; o < graph.V; o++) 
		{ 

			// Initialize to false 
			mstset[o] = false; 

			// Initialize key values to infinity 
			e[o].key = Integer.MAX_VALUE;
			e[o].vertex = o;
			parent[o] = -1;
		} 

		// Include the source vertex in mstset
		mstset[0] = true; 

		// Set key value to 0 
		// so that it is extracted first 
		// out of PriorityQueue 
		e[0].key = 0; 

		// Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java. 
		TreeSet<element> set = new TreeSet<element>(new comparator()); 

		for (int o = 0; o < graph.V; o++) 
			set.add(e[o]); 

		// Loops until the queue is not empty 
		while (!set.isEmpty()) 
		{ 

			// Extracts a node with min key value 
			element node0 = set.pollFirst(); 

			// Include that node into mstset 
			mstset[node0.vertex] = true; 

			// For all adjacent vertex of the extracted vertex V 
			for (node iterator : graph.adj[node0.vertex]) 
			{
				// If V is in queue 
				if (mstset[iterator.dest] == false) 
				{ 
					// If the key value of the adjacent vertex is 
					// more than the extracted key 
					// update the key value of adjacent vertex 
					// to update first remove and add the updated vertex 
					if (e[iterator.dest].key > iterator.weight) 
					{ 
						set.remove(e[iterator.dest]); 
						e[iterator.dest].key = iterator.weight; 
						set.add(e[iterator.dest]); 
						parent[iterator.dest] = node0.vertex;
					} 
				} 
			} 
		} 

		// Prints the vertex pair of mst 
		for (int o = 1; o < graph.V; o++) 
			System.out.println(parent[o] + "----->"+ o);
	}

	public static void main(String[] args) 
	{ 
		int V = 9; 

		Graph graph = new Graph(V); 

		prim e = new prim(); 

		e.addEdge(graph, 0, 1, 4); 
		e.addEdge(graph, 0, 7, 8); 
		e.addEdge(graph, 1, 2, 8); 
		e.addEdge(graph, 1, 7, 11); 
		e.addEdge(graph, 2, 3, 7); 
		e.addEdge(graph, 2, 8, 2); 
		e.addEdge(graph, 2, 5, 4); 
		e.addEdge(graph, 3, 4, 9); 
		e.addEdge(graph, 3, 5, 14); 
		e.addEdge(graph, 4, 5, 10); 
		e.addEdge(graph, 5, 6, 2); 
		e.addEdge(graph, 6, 7, 1); 
		e.addEdge(graph, 6, 8, 6); 
		e.addEdge(graph, 7, 8, 7); 

		e.prims_mst(graph); 
	}
}
