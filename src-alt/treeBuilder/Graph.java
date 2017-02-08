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
	
	public static void dijkstra() {
		ArrayList<Node> finished = new ArrayList<Node>();
		ArrayList<Node> processing = new ArrayList<Node>();
		for(Node n : allNodes){
			n.visted = false;
			n.distance = 1.0 / 0.0;
		}
		final Node baseNode = allNodes.get(0);
		baseNode.distance = 0;
		baseNode.level = 0;
		processing.add(baseNode);
		while (processing.size() > 0) {
			final Node evaluationNode = closestNode(processing);
			processing.remove(evaluationNode);
			finished.add(evaluationNode);
			processing = evaluationNode.evaluateNeighboors(processing);
		}
		
	}
	
	public static Node closestNode(ArrayList<Node> group) {
		double tmpdist = Double.POSITIVE_INFINITY;
		int tmpcall = 0;
		for(int i = 0 ; i < group.size() ; i++){
			if(group.get(i).distance <= tmpdist){
				tmpdist = group.get(i).distance;
				tmpcall = i;
			}
		}
		return group.get(tmpcall);
	}
}
