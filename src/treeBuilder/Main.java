package treeBuilder;

public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(
				new BinaryTree(
						new BinaryTree(2), 1, new BinaryTree(new BinaryTree(3), 2, new BinaryTree(3))
						), 0, new BinaryTree(new BinaryTree(2), 1 , new BinaryTree(
								new BinaryTree(
										new BinaryTree(4), 3 , new BinaryTree(4)
										), 2 , new BinaryTree(new BinaryTree(4), 3 , new BinaryTree(
												new BinaryTree(5), 4 , new BinaryTree(
														new BinaryTree(6), 5 , new BinaryTree(6))))))
				);
		tree.print(0);
		//new BinaryTree(),  , new BinaryTree()
	}
}
