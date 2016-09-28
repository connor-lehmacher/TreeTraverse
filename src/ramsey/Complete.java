package ramsey;

import java.util.ArrayList;

import treeBuilder.Node;

public class Complete {
	
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public Complete(int size) {
		for(int i = 0 ; i < size ; i++) {
			nodes.add(new Node());
		}
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size; j++) {
				if(i != j) {
					nodes.get(i).c(j);
				}
			}
		}
	}
}
