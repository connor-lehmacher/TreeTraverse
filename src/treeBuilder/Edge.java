package treeBuilder;

public class Edge {
	int length;
	Node node1;
	Node node2;
	
	public Edge(int l, Node a, Node b) {
		length = l;
		node1 = a;
		node2 = b;
	}
}
