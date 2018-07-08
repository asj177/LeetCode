package com.leetcode.hard;

import java.util.*;

import com.leetcode.easy.main;
import com.linklist.Helper;
import com.linklist.ListNode;

public class Commons {

   public static void findMedianSortedArrays(int[] nums1, int[] nums2) {
       int len=nums1.length;
       int len2=nums2.length;
       int total=len+len2;
       
       int mid=total/2;
       
       int i=0;
       int j=0;
       
       int count=0;
       
       while(count<=mid) {
    	   int l1=nums1[i];
    	   int l2=nums2[j];
    	   
    	   if(l1>l2) {
    		   if(i<len) {
    			   i++;
    		   }
    	   }else {
    		   if(j<len2) {
    			   j++;
    		   }
    	   }
       }
       
    }
   
   public static boolean isMatch(String s, String p) {
       
	   boolean match=true;
	   
	  int i=0,j=0;
	  
	  while(j<p.length() && i<s.length()) {
		  char pattern=p.charAt(j);
		  
		  switch(pattern) {
		  case '*':
			  return true;
		  case '?':
			    i++;
			    j++;
			    break;
		   default:
			   if(pattern!=s.charAt(i)) {
				   return false;
			   }else {
				   i++;
				   j++;
			   }
			   
			  
	   		  
			  
		  }
	  }
	   
	  if(j>=p.length() && i<s.length() || i>=s.length() && j<p.length()) {
		  match=false;
	  }
	   
	   
	   return match;
   }
   
   public static ListNode combineList(ListNode first,ListNode second) {
	   ListNode head=null;
	   if(first==null && second==null) {
		   return head;
	   }
	   
	   if(first==null) {
		   return second;
	   }
	   
	   if(second==null) {
		   return first;
	   }
	   
	   ListNode a=first;
	   ListNode b=second;
	   ListNode follow=head;
	   ListNode trail=follow;
	   while(a!=null && b!=null) {
		   if(a.data<b.data) {
			   if(follow==null) {
				   follow=a;
			   }else {
				   follow.next=a;
				   follow=follow.next;
			   }
			   
			   a=a.next;
		   }else {
			   if(follow==null) {
				   follow=b;
			   }else {
				   follow.next=b;
				   follow=follow.next;
			   }
			   b=b.next;
		   }
		   if(head==null) {
			   head=follow;
		   }
	   }
	   
	   if(a!=null) {
		   follow.next=a;
		   
	   }
	   
	   if(b!=null) {
		   follow.next=b;
	   }
	   
	   return head;
   }
   
   public static ListNode mergeKLists(ListNode[] lists) {
       
	   return combine(lists,0,lists.length-1);
   }
   
   public static ListNode combine(ListNode[] lists,int start,int end) {
	   if(start>=end) {
		   return lists[start];
	   }
	   
	   int mid=(start+end)/2;
	   ListNode first=combine(lists,start,mid);
	   ListNode second=combine(lists,mid+1,end);
	   ListNode results=combineList(first,second);
	   return results;
   }
   
   public static ListNode reverseLinkedList(ListNode node) {
	   ListNode c=null;
	   ListNode b=node;
	   ListNode a=node.next;
	   ListNode head=null;
	   ListNode toCheck=node;
	   while(a!=null) {
		   b.next=c;
		   c=b;
		   b=a;
		   head=a;
		   a=a.next;
	   }
	   if(head!=null) {
		   head.next=c;
	   }
	  
	   return toCheck;
	   
   }
   
   public static ListNode reverseKGroup(ListNode head, int k) {
      
      ListNode follow=head;
      ListNode first=null;
      
      ListNode trail=follow;
      ListNode backUp=null;
      while(follow!=null) {
    	  int i=1;
    	  while(i<k && follow.next!=null) {
    		  follow=follow.next;
    		  i++;
    	  }
    	  
    	  
    	 
    		  if(first==null) {

           		  first=follow;
        	     }
        	 
        	 
        		  ListNode a=follow.next;
            	  follow.next=null;
            	  ListNode reverse=reverseLinkedList(trail);
            	  if(backUp!=null) {
            		 
            		  backUp.next=follow;
            	  }
            	  backUp=reverse;
            	  reverse.next=a;
            	  follow=a;
            	  trail=follow;
        	
        	 
    	  
    	    
    	  
      }
       
       
       
       return first;
   }
   
   
   public static void findSubstring(String s, String[] words) {
       HashMap<String,Integer> map=new HashMap<String,Integer>();
       List<Integer>locations=new ArrayList<Integer>();
       for(String w:words) {
    	   map.put(w, map.containsKey(w)?map.get(w)+1:1);
       }
       
       int length=words[0].length()*words.length;
       
       int lengthOfeachWords=words[0].length();
       
       for(int i=0;i<=s.length()-length;i=i+1) {
    	   String w=s.substring(i, i+length);
    	   
    	   HashMap<String,Integer>secondMap=new HashMap<String,Integer>(map);
    	   int first=i;
    	   boolean isPresent=true;
    	   for(int j=0;j<=w.length()-lengthOfeachWords;j=j+lengthOfeachWords) {
    		   String a=w.substring(j, j+lengthOfeachWords);
    		   if(secondMap.containsKey(a) && secondMap.get(a)!=0) {
    			   secondMap.put(a, secondMap.get(a)-1);
    		   }else {
    			   isPresent=false;
    			   break;
    		   }
    	   }
    	   if(isPresent) {
    		   locations.add(first);
    	   }
       }
       
   }
   
   public static void longestValidParentheses(String s) {
      int count=0;
      int maxCount=0;
      Stack<Character> stack=new Stack<Character>();
      for(int i=0;i<s.length();i++) {
    	  char c=s.charAt(i);
    	  if(c=='(') {
    		  stack.push(c);
    	  }else {
    		  if(s.isEmpty()) {
    			  count=0;
    		  }else {
    			  stack.pop();
    			  count=count+2;
    			  maxCount=maxCount>count?maxCount:count;
    		  }
    	  }
      }
      
      System.out.println(maxCount);
   }
   
   
   public static void trap(int[] height) {
       int count=0;
       
       for(int i=1;i<height.length-1;i++) {
    	   if(i==9) {
    		   int ceker=9;
    	   }
    	   int left=i;
    	   while(left>0 && height[left-1]>height[left]) left--;
    	  
    	   int right=i;
    	   while(right<height.length && height[right+1]>height[right])right++;
    	   
    	   
    	   
    	   int first=left;
    	   int maxHeight=height[first];
    	   while(first<right) {
    		   count=count+Math.abs(maxHeight-height[first]);
    		   first++;
    	   }
    	   
    	   
    	   
       }
       
      
       System.out.println(count);
   }
   
   public static int trapHelp(int left,int right,int current,int [] height,int count,int max) {
	   if(height[left]<=height[current] || height[right]<=height[current]) {
		   return count;
	   }
	   
	   count=count+Math.abs(height[right]-max)+Math.abs(height[left]-max);
	   
	   return trapHelp(left-1,right+1,current,height,count,max);
	   
	   
   }
   
   public static int getMax(int left,int right,int current ,int max,int []h) {
	   
	   if(left<=0 || right>=h.length-1) {
		   if(h[left] > h[right] && h[left] > h[current]) {
				return right;
			}
			
			if(h[right] > h[left] && h[right] > h[current] ) {
				return left;
			}
	   }
	   
	 if(h[left]<=h[current] || h[right]<=h[current] ) {
		 return max;
	 }
	 
	if(h[left] > h[right] && h[left] > h[current]) {
		max=right;
	}
	
	if(h[right] > h[left] && h[right] > h[current] ) {
		max=left;
	}
	 
	 return getMax(left-1,right+1,current,max,h);
	   
   }
   
   
   public static void jump(int[] nums) {
       int count=0;
       
       int i=0;
       int maxLocation=0;
       while(i<nums.length-1) {
    	  int j=i+1;
    	  int valAtJ=nums[i];
    	  int max=valAtJ;
    	  while(valAtJ>0 && j<nums.length) {
    		  if(nums[j]>=max) {
    			  max=nums[j];
    			  maxLocation=j;
    		  }
    		  j++;
    		  valAtJ--;
    	  }
    	  
    	  if(max<=nums[i]) {
    		  maxLocation=i+nums[i];
    	  }
    	  if(j>=nums.length) {
   		   count++;
   		   break;
   	   }
    	  System.out.println(maxLocation);
    	  
    	  i=maxLocation;
    	  count++;
       }
       
       System.out.println(count);
   }
   
   
   public  List<Interval> insert(List<Interval> intervals, Interval newInterval) {
       List<Interval> result=new ArrayList<Interval>();
       //Get first Point
       int first=newInterval.start;
       int secnd=newInterval.end;
       int point=0;
      
       for(int i=0;i<intervals.size();i++) {
    	   if(intervals.get(i).end<first) {
    		   result.add(intervals.get(i));
    	   }else {
    		   point=i;
    		   break;
    	   }
       }
       int i=0;
       
    while(i<intervals.size() && intervals.get(i).end<secnd) {
    	 Interval merge=new Interval();
    	    merge.start=Math.min(first, intervals.get(i).start);
    	    merge.end=Math.max(secnd, intervals.get(i).end);
    	    
    	    result.add(merge);
    	i++;
    }
       
   
    i++;
    while(i<intervals.size()) {
    	result.add(intervals.get(i));
    	i++;
    }
       
       
       return result;
   }
   
   
   //["This", "is", "an", "example", "of", "text", "justification."]
   public static List<String> fullJustify(String[] words, int maxWidth) {
       List<String> result=new ArrayList<String>();
       int maxLen=0;
       
       int i=0;
       int start=i;
       StringBuilder s=new StringBuilder();
       
       while(i<words.length) {
    	 String w=words[i];
    	 
       }
       
       
       return result;
   }
   
   public static void helperClass(String word) {
	   
	   System.out.println(word);
   }
   
   
   public static String minWindow(String s, String t) {
		    String result = "";
		    if(s==""||t.length()>s.length())
		        return result;
		    int[] map = new int[128];
		    int start = 0;
		    int minStart = 0;
		    int end = 0;
		    int count = t.length();
		    int minLength = Integer.MAX_VALUE;
		    for(char temp:t.toCharArray()){
		        map[temp]++;
		    }
		    while(end<s.length()){
		    	
		        if(map[s.charAt(end)]>0) {

		            count--;
		        }
		        map[s.charAt(end)]--;
		        end++;
		        while(count==0){
					if (end - start < minLength) {
						minStart = start;
						minLength = end - start;
					}
					map[s.charAt(start)]++;
					if (map[s.charAt(start)] > 0) {
						count++;
					}
						
					start++;
		        }
		        printMap(map,t);
		    }
		    return (minLength==Integer.MAX_VALUE)?"":s.substring(minStart, minStart+minLength);
		}
  
   public static void printMap(int[]map,String t) {
	   for(char c:t.toCharArray()) {
		   System.out.print(c+" --> "+map[c]+"  ");
	   }
	   System.out.println( );
   }
   
   
   public static void maximalRectangle(char[][] matrix) {
       for(int i=0;i<=matrix.length-2;i++) {
    	   for(int j=0;j<=matrix[i].length-1;j++ ) {
    		   
    		   if(matrix[i][j]=='1') {
    			   if(matrix[i+1][j]=='1') {
    				   matrix[i][j]='2';
    			   }
    		   }
    		   
    	   }
       }
       printMatrix(matrix);
       int maxArea=Integer.MIN_VALUE;
       for(int i=0;i<=matrix.length-2;i++) {
    	   for(int j=0;j<=matrix[i].length-1;j++ ) {
    		   
    		   if(matrix[i][j]=='2' && matrix[i+1][j]!='0' && matrix[i][j+1]!='0') {
    			   int length=countLength(matrix,i,j);
    			   int breadth=countBreadth(matrix,i,j);
    			   maxArea=Math.max(maxArea, length*breadth);
    		   }
    	   }
       }
       
       System.out.println("Max area is "+maxArea);
   }
   
   public static int countBreadth(char[][]matrix,int i,int j) {
	   int breadth=0;
	   while(j<matrix[i].length &&  matrix[i][j]=='2') {
		   breadth++;
		   j++;
	   }
	   
	   return breadth;
   }
   
   public static int countLength(char[][]matrix,int i,int j) {
	   int length=1;
	   while(matrix[i][j]=='2' && i<matrix.length) {
		   length++;
		   i++;
	   }
	   
	   return length;
   }
   
   public static void printMatrix(char[][]matrix) {
	   for(int i=0;i<matrix.length;i++) {
		   for(int j=0;j<matrix[i].length;j++) {
			   System.out.print(matrix[i][j]+" ");
		   }
		   System.out.println(" ");
	   }
   }
   
   
   
   public static void main(String[] args) {
	  String a="abcde";
	  System.out.println(a.substring(0,1));
	  System.out.println(a.substring(1));
	   //jump(nums1);
	   //jump(nums2);
	   //longestValidParentheses("(()");
	   //longestValidParentheses(")()())");
}
   public class Interval {
	   int start;
	   int end;
	   Interval() { start = 0; end = 0; }
	   Interval(int s, int e) { start = s; end = e; }
   }
   
}
