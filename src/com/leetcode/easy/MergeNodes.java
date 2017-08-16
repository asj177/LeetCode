package com.leetcode.easy;

import com.tree.TreeHelper;
import com.tree.TreeNode;

public class MergeNodes {

	public static TreeNode mergeTrees(TreeNode t1,TreeNode t2){
		if(t1==null && t2==null){
			return null;
		}
		TreeNode node=null;
		
		if(t1!=null && t2!=null) {
			node=new TreeNode(t1.val+t2.val);
			node.left=mergeTrees(t1.left,t2.left);
			node.right=mergeTrees(t1.right,t2.right);
		}
		
		if(t1==null && t2 !=null) {
			node=new TreeNode(t2.val);
			node.left=mergeTrees(null,t2.left);
			node.right=mergeTrees(null,t2.right);
		}
		
		if(t1!=null && t2==null) {
			node = new TreeNode(t1.val);
			node.left=mergeTrees(t1.left,null);
			node.right=mergeTrees(t1.right,null);
		}
		
		
		return node;
		
	}
	
	public static void main(String[] args) {
		TreeNode first=new TreeNode(1);
		TreeNode second=new TreeNode(2);
		first.left=new TreeNode(3);
		first.left.left=new TreeNode(5);
		first.right=new TreeNode(2);
		
		second.left=new TreeNode(1);
		second.left.right=new TreeNode(4);
		second.right=new TreeNode(3);
		second.right.right=new TreeNode(7);
		
		TreeHelper.printTree(first);
		System.out.println(" ");
		TreeHelper.printTree(second);
		System.out.println(" ");
		TreeNode mergeTree=mergeTrees(first,second);
		TreeHelper.printTree(mergeTree);
	}
}
