package treeBuilder;

import java.util.ArrayList;

public class Node {
	int value;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	public Node(int v){
		value = v;
	}
	
	public void connect(Node n, int length) {
		Edge tmp = new Edge(length, this, n);
		edges.add(tmp);
		n.edges.add(tmp);
	}
}
