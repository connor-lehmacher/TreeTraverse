package treeBuilder;

import java.util.ArrayList;

public class Node {
	int value;
	boolean visted = false;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	public Node(int v){
		value = v;
	}
	
	public void connect(Node n, int length) {
		Edge tmp = new Edge(length, this, n);
		edges.add(tmp);
		n.edges.add(tmp);
	}
	
	public void print(int depth) {
		if(visted == false) {
			visted = true;
			System.out.print(value);
			if(edges.size() != 0){
				System.out.print("  -");
				edges.get(0).getOtherNode(this).print(depth + 1);
			}
			if(edges.size() > 1){
				for(int i  = 1 ; i < edges.size() ; i++) {
					System.out.println();
					for(int j = -1 ; j < depth ; j += 1) {
						System.out.print("   ");
					}
					edges.get(i).getOtherNode(this).print(depth + 1);
				}
			}
		}
	}
}
