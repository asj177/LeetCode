package com.tree;

public  class TreeHelper {

	
	public static void printTree(TreeNode n){
		if(n==null) {
			return;
		}
		
		System.out.print(n.val+" ");
	 
		printTree(n.left);
		printTree(n.right);
	}
}
