package com.java_concepts.graphs;

import java.io.*;
import java.util.*;

public class Graph
{
	private int noOfVertices; // No. of vertices
	private LinkedList<Integer> adjVertices[]; // Adjacency Lists

	Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjVertices = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adjVertices[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adjVertices[v].add(w);
	}
	
	void printAllVertices(){
		for(int i = 0; i < adjVertices.length; i++){
			Iterator<Integer> iterator = adjVertices[i].listIterator();
			System.out.println("");
			while (iterator.hasNext()) {
				System.out.print(" " + iterator.next());
			}
		}
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[noOfVertices];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adjVertices[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {
		Graph graph = new Graph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		graph.BFS(2);
		graph.printAllVertices();
	}
}
