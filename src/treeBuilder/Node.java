package treeBuilder;

import java.util.ArrayList;

public class Node {
	int value;
	boolean visted = false;
	double distance;
	int level;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	public Node(int v){
		value = v;
	}
	
	public void connect(Node n, int length) {
		Edge tmp = new Edge(length, this, n);
		edges.add(tmp);
		n.edges.add(tmp);
	}
	
	public void c(Node n) {
		connect(n, 1);
	}
	
	public void c(int n) {
		c(new Node(n));
	}
	
	public ArrayList<Node> evaluateNeighboors(ArrayList<Node> processing) {
		for(Edge e : edges) {
			if(!e.getOtherNode(this).visted) {
				double newDistance = e.length + distance;
				if(newDistance < e.getOtherNode(this).distance) {
					e.getOtherNode(this).distance = newDistance;
					processing.add(e.getOtherNode(this));
				}
			}
		}
		return processing;
	}
	
	public void print(int depth) {
		if(visted == false) {
			visted = true;
			System.out.print(" - ");
			System.out.print(value);
			ArrayList<Integer> goodValues = new ArrayList<Integer>(); 
			for(int i  = 0 ; i < edges.size() ; i++) {
				if(edges.get(i).getOtherNode(this).visted == false) {
					goodValues.add(i);
				}
			}
			if(goodValues.size() != 0){
				edges.get(goodValues.get(0)).getOtherNode(this).print(depth + 1);
			}
			if(goodValues.size() > 1) {
				for(int i  = 1 ; i < goodValues.size() ; i++) {
					System.out.println();
					for(int j = -1 ; j < depth ; j += 1) {
						System.out.print("    ");
					}
					edges.get(goodValues.get(i)).getOtherNode(this).print(depth + 1);
				}
			}
		}
	}
}
