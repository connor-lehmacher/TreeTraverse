package treeBuilder;

public class Main {
	public static void main(String[] args) {
		//ArrayList<Node> nodes = new ArrayList<Node>();
		Node a = new Node(0);
		a.connect(new Node(1), 1);
		a.print(0);
	}
}
