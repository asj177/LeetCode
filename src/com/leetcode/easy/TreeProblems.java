package com.leetcode.easy;

import com.tree.TreeHelper;
import com.tree.TreeNode;
import java.util.*;

public class TreeProblems {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
        	return true;
        }
        
        if((p!=null && q==null) || (p==null && q!=null)) {
        	return false;
        }
        
       if(p.val!=q.val) {
    	   return false;
       }
        
        return (isSameTree(p.left,q.right) && isSameTree(p.right,q.left));
	  
    }
  
  
  public static boolean isSymmetric(TreeNode p) {
      if(p==null) {
      	return true;
      }
      return (isSameTree(p.left,p.right));
	  
  }
  
  
  
  public static Integer maxVal=Integer.MIN_VALUE;
  
 
  public static int maxDepth(TreeNode root) {
	  if(root==null) {
		  return 0;
	  }

	  
	  
	  return Integer.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
  }
  
  
  static int max=Integer.MAX_VALUE;
  public static int minDepth(TreeNode root) {
     
	  calculate(new ArrayList<Integer>(),root);
      
    return max;
  }
  
  
  public static void calculate(ArrayList<Integer> val,TreeNode node) {
	  if(node==null) {
	  
	   return ;
	  }
	  
	  
	  if(node.left==null && node.right==null) {
		  val.add(node.val);
		  max=Integer.min(val.size(), max);
	  }else {
		  val.add(node.val);
	  }
	  
	  calculate(val,node.left);
	  calculate(val,node.right);
	  val.remove(val.size()-1);
	  
  }
  
  
  public static void levelOrderBottom(TreeNode root) {
      
	  if(root==null) {
		  return ;
	  }
	  
	  Queue<TreeNode>q=new LinkedList<TreeNode>();
	  List<List<Integer>> arr=new ArrayList<List<Integer>>();
	  
	  q.add(root);
	  q.add(null);
	  
	  List<Integer> subset=new ArrayList<Integer>();
	  
	  while(!q.isEmpty()) {
		  TreeNode n=q.poll();
		  
		  if(n==null) {
			  arr.add(subset);
			  subset=new ArrayList<Integer>();
			  if(q.peek()!=null) {
				  q.add(null);
			  }
			  
		  }else {
			  subset.add(n.val);
			  if(n.left!=null) {
				  q.add(n.left);
			  }
			  
			  if(n.right!=null) {
				  q.add(n.right);
			  }
		  }
	  }
	  
	  List<List<Integer>> result=new ArrayList<List<Integer>>();
	  
	  for(int i=arr.size()-1;i>=0;i--) {
		  result.add(arr.get(i));
	  }
	  
	  for(int i=0;i<result.size();i++) {
		  System.out.println("*****************************");
		  System.out.println(result.get(i));
		  System.out.println("*****************************");
	  }
	  
  }
  
  public static TreeNode sortedArrayToBST(int[] nums) {
      
	  return getTree(nums,0,nums.length-1);
  }
  
  
  public static TreeNode getTree(int[]nums,int left,int right) {
	  if(left>right) {
		  return null;
	  }
	  int mid=left+((right-left)/2);
	  TreeNode node=new TreeNode(nums[mid]);
	  node.left=getTree(nums,left,mid-1);
	  node.right=getTree(nums,mid+1,right);
	  return node;
}
  
  
  public static boolean isBalanced(TreeNode root) {
      
	  if(root==null) {
		  return true;
	  }
	  
	  
	  
	  int leftHeight=maxDepth(root.left);
	  int rightHeight=maxDepth(root.right);
	  
	  
	  
	  return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);

  }
  
  public static int geTotal(int []arr) {
	  int result=0;
	  
	  for(int i=0;i<arr.length;i++) {
		  result=result+arr[i];
	  }
  
  return result;
  }
  
  static boolean result=false;
 
  public static boolean hasPathSum(TreeNode root, int sum) {
	  getResult(new ArrayList<Integer>(),root,sum);
	  return result;
  }
  
  
  public static int getTotal(ArrayList<Integer>arr) {
	  int result=0;
	  for(int i:arr) {
		  result=result+i;
	  }
	  return result;
  }
  
  public static void getResult(ArrayList<Integer>arr,TreeNode root,int sum) {
	  if(root==null) {
		  return ;
	  }
	  
	  if(root.left==null && root.right==null) {
		  arr.add(root.val);
		  if(getTotal(arr)==sum) {
			  result=true;
		  }
	  }else {
		  arr.add(root.val);
	  }
	  
	  getResult(arr,root.left,sum);
	  getResult(arr,root.right,sum);
	  arr.remove(arr.size()-1);
  }
  
  public static boolean check(TreeNode root,TreeNode checkNode) {
	  if(root==null) {
		  return false;
	  }
	  
	  if(root.val==checkNode.val) {
		  return true;
	  }
	  
	  return check(root.left,checkNode)||check(root.right,checkNode);
  }
  
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null) {
    	  return null;
      }
      
      boolean left_p=check(root.left,p);
      boolean left_q=check(root.left,q);
      boolean right_p=check(root.right,p);
     boolean right_q=check(root.right,q);
      
      
     if(left_p==left_q && !right_p && !right_q) {
    	 return lowestCommonAncestor(root.left,p,q);
     }
     
     if(right_p==right_q && !left_p && !left_q) {
    	 return lowestCommonAncestor(root.right,p,q);
     }
     
     return root;
	  
  }
  
  public static List<String> pathResult=new ArrayList<String>();
  
  
  public static void addResult(TreeNode root,String s) {
	  
	  if(root.left==null && root.right==null) {
		  s=s+root.val;
		  pathResult.add(s);
	  }
	  
	  
	  s=s+root.val+"->";
	  
	  if(root.left!=null) {
		  addResult(root.left,s);
	  }
	  
	  if(root.right!=null) {
		  addResult(root.right,s);
	  }
  }
  
  
  public static List<String> binaryTreePaths(TreeNode root) {
      if(root==null) {
    	  return pathResult;
      }
      
      addResult(root,"");
      
      return pathResult;
  }
  
  static int sum=0;
  public static int sumOfLeftLeaves(TreeNode root) {
     
	  helper(root);
      
      return sum;
  }
  
  
  public static void helper(TreeNode root) {
	  if(root==null) {
		  return ;
	  }
	  
	  
	  if(root.left!=null) {
		  if(root.left.left==null && root.left.right==null) {
			  sum=sum+root.left.val;
		  }
	  }
	  
	  helper(root.left);
	  helper(root.right);
	 
	 
  }
  
  
  public static int pathSums=0;
  
  public static int pathSum(TreeNode root, int sum) {
	  pathSumHelper(root,sum,new ArrayList<Integer>());
	  return pathSums;
  }
  
 // public static ArrayList<Integer> tempStorage=new ArrayList<Integer>();
  
  
  public static void pathSumHelper(TreeNode root,int sum,ArrayList<Integer>tempStorage) {
	  if(root==null) {
		  helpSum(sum,tempStorage);
		  return;
	  }
	  
	  tempStorage.add(root.val);
	 // print(tempStorage);
	  
	  pathSumHelper(root.left,sum,tempStorage);
	  tempStorage.remove(0);
	//  print(tempStorage);
	  pathSumHelper(root.right,sum,tempStorage);
	 // tempStorage.remove(tempStorage.size()-1);
	//  print(tempStorage);
  }
  
  public static void helpSum(int sum,ArrayList<Integer>tempStorage) {
	  int check=0;
	  ArrayList<Integer> b=new ArrayList<Integer>();
	  for(Integer a:tempStorage) {
		  if(check==sum) {
			  pathSums++;
			  print(b);
		  }
		  b.add(a);
		  
		  check=check+a;
	  }
	  
	  //tempStorage=new ArrayList<Integer>();
  }
  
  
  public static void print(ArrayList<Integer> b) {
	  
	  for(int a:b) {
		  System.out.print(a+" ");
	  }
	  System.out.println(" ");
  }
  
  static  ArrayList<Integer> arr=new ArrayList<Integer>();
  static int currentMaxValue=0;
  static int currentMaxNumber=-1;
  static public ArrayList<Integer> findMode(TreeNode root) {
     
      
      getMode(root,0,0);
      
      return arr;
  }
  

 static public void getMode(TreeNode root,int count,int maxCount) {
	  if(root==null) {
		  return ;
	  }
	  
	  if(root.left!=null) {
		  if(root.val==root.left.val) {
			  count++;
			  if(count>maxCount) {
				  maxCount=count;
				  if(arr.size()>0) {
					  arr.clear();
					  arr.add(root.val);
				  }else {
					  arr.add(root.val);
				  }
			  }
		  }else {
			  count=0;
		  }
	  }
	  
	  if(root.right!=null) {
		  if(root.val==root.right.val) {
			  count++;
			  if(count>maxCount) {
				  maxCount=count;
				  if(arr.size()>0) {
					  arr.clear();
					  arr.add(root.val);
				  }else {
					  arr.add(root.val);
				  }
			  }
		  }else {
			  count=0;
		  }
	  }
	  
	  getMode(root.left,count,maxCount);
	  getMode(root.right,count,maxCount);
  }
  
  
 static int minDiff=Integer.MAX_VALUE;
 public static int getMinimumDifference(TreeNode root) {
    
	 
	 return minDiff;
 }
 
 public static void getMinHelper(TreeNode root) {
	 if(root==null) {
		 return;
	 }
	 
	 if(root.left!=null) {
		 if(Math.abs(root.val-root.left.val)<minDiff) {
			 minDiff=Math.abs(root.val-root.left.val);
		 }
	 }
	 
	 if(root.right!=null) {
		 if(Math.abs(root.val-root.right.val)<minDiff) {
			 minDiff=Math.abs(root.val-root.right.val);
		 }
	 }
	 
	 getMinHelper(root.left);
	 getMinHelper(root.right);
 }
 
 public static TreeNode convertBST(TreeNode root) {
     
	 bstHelper(root);
	 
	 return root;
 }
 static int val=0;
 public static void bstHelper(TreeNode root) {
	 if(root==null) {
		 return ;
	 }
	 
	  bstHelper(root.right);
	 
	 root.val=root.val+val;
	 val=root.val;
	 bstHelper(root.left);
	 
	 
 }
 
 static int maxDistance=0;
 public static int diameterOfBinaryTree(TreeNode root) {
	 maxLength(root);
	 return maxDistance;
 }
 
 static int distance=0;
 public static void maxLength(TreeNode root) {
	 if(root==null) {
		 return;
	 }
	 
	 if(root.right==null && root.left==null) {
		 return;
	 }
	 
	 System.out.println("Node at "+root.val+" is "+ distance);
	 
	 if(distance>maxDistance) {
		 maxDistance=distance;
	 }
	 
	 if(root.left!=null) {
		 maxLength(root.left);
	 }
	 
	 System.out.println("Node at "+root.val+" is "+ distance);
	 distance=distance+1;
	 if(root.right!=null) {
		 maxLength(root.right);
		 distance=distance-1;
	 }
	 
	
 }
 
 
 public static boolean isSubtree(TreeNode s, TreeNode t) {
     
	 if(s==null) {
		 return false;
	 }
	 
	 if(s.val==t.val) {
		 boolean val=isSubtreeHelper(s,t);
		 return val;
	 }
	 
	 return isSubtree(s.left,t) || isSubtree(s.right,t);
 }
 
 public static boolean isSubtreeHelper(TreeNode s, TreeNode t) {
	 
	 if(s==null && t==null) {
		 return true;
	 }
    
	 if((s==null && t!=null) || (s!=null && t==null)) {
		 return false;
	 }
	 
	 if(s.val!=t.val) {
		 return false;
	 }
	 
	 return isSubtreeHelper(s.left,t.left) && isSubtreeHelper(s.right,t.right);
     
     
     
 }
 
 
 public static String tree2str(TreeNode t) {
     String s="";
     
   
     
     return helperString(t,s);
 }
 
 
 public static String helperString(TreeNode t,String s) {
	 
	 if(t==null) {
		 return s;
	 }
	 if(t.right==null && t.left==null) {
		 return s+t.val;
	 }
	 
	 if(t.right!=null) {
		 s=s+t.val+"("+helperString(t.left,s)+")"+"("+helperString(t.right,s)+")";
	 }else {
		 s=s+t.val+"("+helperString(t.left,s)+")";
	 }
	 System.out.println(s);
	 return s;
 }
 
 
  public static void main(String[] args) {
	 TreeNode node=new TreeNode(1);
	 node.left=new TreeNode(2);
	 node.right=new TreeNode(3);
	 node.left.left=new TreeNode(4);
	 System.out.println(tree2str(node));
	
	
}
}
