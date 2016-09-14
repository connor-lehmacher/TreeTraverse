package treeBuilder;

public class Main {
	public static void main(String[] args) {
		//ArrayList<Node> nodes = new ArrayList<Node>();
		Node a = new Node(0);
		Node b = new  Node(1);
		Node c = new Node(1);
		Node d = new Node(2);
		a.c(b);
		a.c(c);
		b.c(d);
		c.c(d);
		a.print(0);

	}
}
