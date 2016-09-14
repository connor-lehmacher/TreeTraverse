package treeBuilder;

import java.util.ArrayList;

public class Graph {
	public static ArrayList<Node> allNodes = new ArrayList<Node>();
	
	public static void print(){
		allNodes.get(0).print(0);
		for(Node n : allNodes){
			n.visted = true;
		}
	}
	
	public static void dijkstraSetUp() {
		for(Node n : allNodes){
			n.visted = true;
			n.distance = 1.0 / 0.0;
		}
		allNodes.get(0).distance = 0;
		//allNodes.get(0).dijkstra();
	}
}
