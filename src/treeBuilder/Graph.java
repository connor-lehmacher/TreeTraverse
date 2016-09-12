package treeBuilder;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public Graph(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void print(){
		nodes.get(0).print(0);
		for(Node n : nodes){
			n.visted = true;
		}
	}
}
