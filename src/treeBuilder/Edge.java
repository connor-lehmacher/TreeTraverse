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
	
	public Node getOtherNode(Node t){
		if(t == node1) {
			return node2;
		}
		return node1;
	}
}
