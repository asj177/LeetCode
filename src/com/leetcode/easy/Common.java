package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.tree.TreeNode;
import com.tree.TreeHelper;

public class Common {

	static void reverseString(String words){
		String [] listOfWords=words.split(" ");
		String common="";
		int i=0;
		for(String one:listOfWords){
			if(i!=listOfWords.length-1){
				common=common+reverse(one)+" ";
			}else{
				common=common+reverse(one);
			}
			i++;
		}
		System.out.println(common);
	}
	
   static String reverse(String word){
	   String common="";
	   for(int i=word.length()-1;i>=0;i--){
		   common=common+word.charAt(i);
	   }
	   return common;
   }
   
   static void longestUncommonSubsequence(String a,String b) {
	   int alen=0;
	   int blen=0;
	   int maxlen=0;
	   int intialSize=0;
	   while(blen<b.length()) {
		   if(b.charAt(blen)!=a.charAt(alen)) {
			   blen++;
			   intialSize++;
		   }else{
			   maxlen=intialSize>maxlen?intialSize:maxlen;
			   blen=common(a,b,blen);
			   
			   intialSize=0;
			   
			  
		   }
	   }
	   maxlen=intialSize>maxlen?intialSize:maxlen;
	   System.out.println("max len is "+maxlen);
   }
   
   static int common(String a,String b,int stopofblen) {
	   int alen=0;
	   while(alen<a.length() && stopofblen<b.length()) {
		   if(a.charAt(alen)==b.charAt(stopofblen)) {
			   alen++;
			   stopofblen++;
		   }else{
			   break;
		   }
	   }
	   return stopofblen;
   }
   
   public static int findMaxConsecutiveOnes(int[] nums) {
	   
	   int maxcon=0;
	   int concec=0;
	   boolean wasprev=nums[0]==1?true:false;
	   for(int i=0;i<nums.length;i++) {
		  if(nums[i]==1){
			  if(wasprev) {
				  concec++;
			  }else{
				  concec=1;
			  }
			  wasprev=true;
		  }else{
			  wasprev=false;
		  }
		  maxcon=concec>maxcon?concec:maxcon;
	   }
	   
	   return maxcon;
       
   }
   
   public static int maxDepthOfTree(TreeNode root ){
	   if(root==null) {
		   return 0;
	   }
	   
	   return Math.max(maxDepthOfTree(root.left)+1, maxDepthOfTree(root.right)+1);
   }
   
   public static boolean detectCapitalUse(String word) {
       char []ch=word.toCharArray();
       boolean second=true;
       boolean rest=true;
       boolean first=(ch[0]>=65 && ch[0]<=90)?true:false;
       if(ch.length>1){
       	   
       second=(ch[1]>=65 && ch[1]<=90)?true:false;
       
       if(!first && second) {
    	   return false;
       }
       
       for(int i=2;i<ch.length;i++) {
    	   if(first & second) {
    		   if(ch[i] <=90 && ch[i] >=65) {
    			   rest=true;
    		   }else{
    			   rest=false;
    			   break;
    		   }
    	   }
    	   
    	   if(!second && first || !first && !second) {
    		   if(ch[i] >=97) {
    			   rest=true;
    		   }else{
    			   rest=false;
    			   break;
    		   }
    	   }
    	   
    	  
       }
       
      
       }else{
    	   return rest;
       }
       return rest;
   }
   
   
   public static void findDisappearedNumbers(int[] nums) {
       List<Integer> ret = new ArrayList<Integer>();
       
       for(int i = 0; i < nums.length; i++) {
           int val = Math.abs(nums[i]) - 1;
           if(nums[val] > 0) {
               nums[val] = -nums[val];
           }
       }
       
       for(int i = 0; i < nums.length; i++) {
           if(nums[i] > 0) {
               ret.add(i+1);
           }
       }
      for(int a:ret){
    	  System.out.println(a);
      }
   }
   
   public static TreeNode invertBinaryTree(TreeNode root) {
	   if(root==null) {
		   return root;
	   }
	   
	   TreeNode n=root.left;
	    root.left=root.right;
	   root.right=n;
	   
	   root.left=invertBinaryTree(root.left);
	   root.right=invertBinaryTree(root.right);
	   return root;
	   
	   
   }
   static int sum=0;
   public static void converToGreaterTree(TreeNode root) {
	   if(root==null){
		   return ;
	   }
	   
	   
	   converToGreaterTree(root.right);
	   root.val=root.val+sum;
	   sum=root.val;
	   
	   
	   converToGreaterTree(root.left);
	   
	   
   }
   
   public static boolean twoNodeHelper(TreeNode root,int difference){
	   
	   if(root==null) {
		   return false;
	   }
	   
	   if(root.val==difference) {
		   return true;
	   }
	   
	   if(root.val>difference) {
		   return twoNodeHelper(root.left,difference);
	   }
	   
	   return twoNodeHelper(root.right,difference);
   }
   
   public static boolean towSumBinaryTree(TreeNode root,TreeNode mainRoot,int target) {
	   if(root==null) {
		   return false;
	   }
	   
	  
	   
	  /* boolean val=twoNodeHelper(mainRoot,Math.abs(root.val-target));
	   
	   if(val) {
		   return true;
	   }*/
	   
	   return twoNodeHelper(root.left,Math.abs(root.val-target)) || twoNodeHelper(root.right,Math.abs(root.val-target));
	   
	   
	   
   }
   
   public TreeNode convertBST(TreeNode root) {
	   converToGreaterTree(root);
       return root;
   }
   
   public void convert(TreeNode cur) {
       if (cur == null) return;
       convert(cur.right);
       cur.val += sum;
       sum = cur.val;
       convert(cur.left);
   }
   
   
  public static char findLetterDifference(String s,String t) {
	  char []charCompare=new char[256];
	  
	  for(int i=0;i<s.length();i++){
		  charCompare[s.charAt(i)]=1;
	  }
	  
	  for(int i=0;i<t.length();i++){
		  
		  if(charCompare[t.charAt(i)]==1){
			  
		  }
		  if(charCompare[t.charAt(i)]==0){
			  return t.charAt(i);
		  }
	  }
	  
	  return 0;
	  
  }
  
  public static void moveZeroes(int []nums){
	  int i=0;
	  int j=1;
	  System.out.println("Length is "+nums.length);
	  while(j<nums.length) {
		  System.out.println("Current value of i is "+i);
		  System.out.println("Current value of j is "+j);
		  if(nums[i]!=0){
			  j++;
			  i++;
			  continue;
		  }
		  
		  if(nums[i]==0 && nums[j]==0){
			  j++;
			  continue;
		  }
		  
		  
		  
		  if(nums[j]!=0 && nums[i]==0) {
			  int temp=nums[j];
			  nums[j]=nums[i];
			  nums[i]=temp;
			  i++;
			  j++;
			  continue;
		  }
		  
		  
	  }
	  
	  
	  for(int a:nums){
		  System.out.print(a+" ");
	  }
	  
	  
  }
  
  public static void maxCount(int m, int n, int[][] ops) {
      int max=0;
      
      
      int [][]M=new int[m][n];
      int count=m*n;
      for(int x=0;x<ops.length;x++){
    	  int a=ops[x][0];
    	  int b=ops[x][1];
    	  
    	  for(int i=0;i<a;i++) {
    		  for(int j=0;j<b;j++){
    			  M[i][j]=M[i][j]+1;
    			  if(M[i][j] >max){
    				  count=1;
    				  max=M[i][j];
    			  }else{
    				  if(M[i][j]==max){
    					  count++;
    				  }
    			  }
    			  
    			  
    		  }
    	  }
      }
      
      System.out.println("count is "+count+" for max number"+max);
  }
   public static void main(String[] args) {
	
	   TreeNode root=new TreeNode(1);
	  // root.left=new TreeNode(1);
	  // root.left.left=new TreeNode(2);
	  // root.left.right=new TreeNode(4);
	   
	 //  root.right=new TreeNode(3);
	  // root.right.left=new TreeNode(7);
	  // root.right.right=new TreeNode(10);
	  // int []nums={-959151711,623836953,209446690,-1950418142,1339915067,-733626417,481171539,-2125997010,-1225423476,1462109565,147434687,-1800073781,-1431212205,-450443973,50097298,753533734,-747189404,-2070885638,0,-1484353894,-340296594,-2133744570,619639811,-1626162038,669689561,0,112220218,502447212,-787793179,0,-726846372,-1611013491,204107194,1605165582,-566891128,2082852116,0,532995238,-1502590712,0,2136989777,-2031153343,371398938,-1907397429,342796391,609166045,-2007448660,-1096076344,-323570318,0,-2082980371,2129956379,-243553361,-1549960929,1502383415,0,-1394618779,694799815,78595689,-1439173023,-1416578800,685225786,-333502212,-1181308536,-380569313,772035354,0,-915266376,663709718,1443496021,-777017729,-883300731,-387828385,1907473488,-725483724,-972961871,-1255712537,383120918,1383877998,1722751914,0,-1156050682,1952527902,-560244497,1304305692,1173974542,-1313227247,-201476579,-298899493,-1828496581,-1724396350,1933643204,1531804925,1728655262,-955565449,0,-69843702,-461760848,268336768,1446130876};
	  int[]a={};
	  int[] b={};
	  
	  int[][]ops={a,b};
	  
	  maxCount(4000,4000,ops);
	   
}
}
 