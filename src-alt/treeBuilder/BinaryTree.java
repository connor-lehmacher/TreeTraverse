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
		System.out.print("--");
		System.out.print(value);
		if(left != null){
			left.print(depth + 1);
		}
		
		
		if(right != null) {
			System.out.println();
			for(int i = 0 ; i <= depth ; i++){
				System.out.print("   ");
			}
			
			right.print(depth + 1);
		}
	}
	
	
}
