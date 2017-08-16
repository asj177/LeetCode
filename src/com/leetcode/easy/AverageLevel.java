package com.leetcode.easy;

import java.util.*;

import com.tree.TreeNode;

public class AverageLevel {

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> average=new ArrayList<Double>();
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		double count=0;
		int valuesAdded=0;
		while(!q.isEmpty()) {
			TreeNode n=q.remove();
			if(n!=null){
				count=count+n.val;
				valuesAdded=valuesAdded+1;
				if(n.left!=null){
					q.add(n.left);
				}
				if(n.right!=null){
					q.add(n.right);
				}
				
				//q.add(null);
			}
			if(n==null){
				
				if(q.peek()!=null){
					average.add(count/valuesAdded);
					count=0;
					valuesAdded=0;
					q.add(null);
				}
				
			}
		}
		average.add(count/valuesAdded);
		return average;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(2);
		root.right=new TreeNode(5);
		//root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(4);
		List<Double>results=averageOfLevels(root);
		System.out.println(results);
		
		
	}
}
