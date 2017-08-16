package com.tree;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data){
		this.val=data;
	}
	
	public TreeNode(TreeNode left,TreeNode right){
		this.right=right;
		this.left=left;
	}
	
	
}
