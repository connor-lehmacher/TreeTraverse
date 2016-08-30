package treeBuilder;

public class BinaryTree {
	//--------------Fields-----------\\
	BinaryTree left;
	BinaryTree right;
	int value;
	boolean end;
	
	//------------Methods-----------------\\
	public BinaryTree(){
		end = true;
	}
	
	public BinaryTree(int a){
		this();
		value = a;
	}
	
	public BinaryTree(BinaryTree left, int value, BinaryTree right) {
		this(value);
		this.left = left;
		this.right = right;
	}
	
	public BinaryTree(String s) {
		if(s.equals("big")){
			//10 deep full tree
		}
		else{
			end = true;
		}
	}
	
	
	public void print(int depth) {
		if(left != null){
			left.print(depth + 1);
		}
		for(int i = 0 ; i < depth ; i++){
			System.out.print(" ");
		}
		System.out.println(value);
		if(right != null) {
			right.print(depth + 1);
		}
	}
	
	
}
