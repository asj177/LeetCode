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
   
   public static void isMatch(String s, String p) {
       
	   boolean match=false;
	   
	   int i=p.length()-1;
	   int j=s.length()-1;
	   while(i>=0) {
		   
		   if(p.charAt(i)==s.charAt(j)) {
			   i--;
			   j--;
			  // match=true;
			   continue;
		   }
		   
		   if(p.charAt(i)=='*') {
			   match=true;
			   break;
		   }
		   if(p.charAt(i)=='.') {
			   j--;
			   i--;
			   continue;
		   }
		   
		   if(p.charAt(i)!=s.charAt(j)) {
			   match=false;
			   break;
		   }
	   }
	   
	   if(i==-1 && j==-1 ) {
		   match=true;
	   }
	   
	   System.out.println(match);
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
       for(String w:words) {
    	   
       }
   }
   
   
   public static void main(String[] args) {
	   int []a= {1,2,3,4,5};
	   
	   Helper.printLinkedList(reverseKGroup(Helper.createList(a),3));
}

}
