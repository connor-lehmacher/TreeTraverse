package treeBuilder;

public class Main {
	public static void main(String[] args) {
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node();
		Node g = new Node();
		Node h = new Node();
		Node i = new Node();
		Node j = new Node();
		Node k = new Node();
		Node l = new Node();
		Node m = new Node();
		
		a.c(b);
		b.c(d);
		a.c(c);
		c.c(d);
		
		Graph.dijkstra();
		System.out.println(a.distance + " " +
				b.distance + " " +
				c.distance + " " +
				d.distance);
	}
}
