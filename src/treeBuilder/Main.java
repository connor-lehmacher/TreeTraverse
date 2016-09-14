package treeBuilder;

public class Main {
	public static void main(String[] args) {
		//ArrayList<Node> nodes = new ArrayList<Node>();
		Node a = new Node(0);
		a.c(1);
		a.c(1);
		a.c(1);
		Node b = new  Node(1);
		a.c(b);
		b.c(2);
		Node c = new Node(1);
		b.c(c);
		c.c(a);
		c.c(2);
		b.c(2);
		a.print(0);
	}
}
