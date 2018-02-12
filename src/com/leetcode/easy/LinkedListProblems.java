package com.leetcode.easy;

import java.util.Stack;

import com.linklist.Helper;
import com.linklist.ListNode;

public class LinkedListProblems {
	

	public static void removeDuplicates(ListNode node) {
		
		if(node==null) {
			return;
		}
		ListNode follower=node;
		ListNode lead=node;
		if(node.next!=null) {
			 lead=node.next;
		}
		
		while(lead!=null) {
			if(lead.data!=follower.data) {
				lead=lead.next;
				follower=follower.next;
			}else {
				follower.next=lead.next;
				lead=lead.next;
			}
		}
		
		
		
		
		Helper.printLinkedList(node);
		
	}


	public static void merge(ListNode l1,ListNode l2) {
		
		ListNode t1=l1;
		ListNode t2=l2;
		ListNode f1=l1;
		ListNode f2=l2;
		
		while(t1 !=null && t2!=null) {
			if(t1.data > t2.data) {
				f2=t2.next;
				t2.next=t1;
				t2=f2;
			}else {
				f1=t1.next;
				t1.next=t2;
				t1=f1;
			}
		}
		
		System.out.println("Its over");
	}
	
	
	public static void removeDuplicates(int []nums,int val) {
		int counter=0;
		int length=0;
		int position=0;
		
		for(int i=0;i<nums.length;i++) {
			if(val!=nums[i]) {
				//counter=nums[i];
				length++;
				nums[position]=nums[i];
				position=position+1;
			}
		}
		
		
		
		System.out.println(length);
		System.out.println(" *****");
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
		
	}
	
	
	public static int recursriveSum(int n,int sum) {
		if(n==0) {
			return sum;
		}
		
		return recursriveSum(n-1,sum);
	}
	
	public static int nonRecursiveSum(int n,int sum) {
		for(int i=n;i>=0;i--) {
			sum=sum+i;
		}
		
		return sum;
	}
	
public static int  searchInsert(int[] nums, int target) {
        
        int i=0;
        
        if(nums.length==1) {
        	if(nums[i]==target) {
        		return i;
        	}
        	
        	if(nums[i]<target) {
        		return -1;
        	}
        	
        	if(nums[i] > target) {
        		return 0;
        	}
        }
        
        while(i<nums.length && nums[i]<target) {
            i++;
        }
        
        if(i==nums.length && nums[i]!=target) {
            return -1;
        }
        return i;
    }


   public static String say(String s ) {
	   int count=1;
	   String s2="";
	   char val=s.charAt(0);
	   
	   for(int i=1;i<s.length();i++) {
		   if(val==s.charAt(i)) {
			   count++;
		   }else {
			   s2=s2+count+val;
			   count=1;
			   val=s.charAt(i);
		   }
	   }
	   s2=s2+count+val;
	   return s2;
   }
    public static void countAndSay(int n) {
        String s="";
    	if(n>=1) {
    		s=s+"1";
    	}
    	char val=' ';
    	for(int i=2;i<=n;i++) {
    		
    		s=say(s);
    		
    	}
    	
    	System.out.println(s);
    }
    
    
   public static void isPalindrome(ListNode head) {
     ListNode slow=head;
     ListNode fast=head.next;
     
     while(fast!=null ) {
    	 fast=fast.next.next;
    	 slow=slow.next;
     }
     ListNode nodea=null;
     if(fast==null) {
    	 ListNode node=new ListNode(slow.data);
    	 node.next=slow.next;
    	 slow.next=null;
    	 
    	 head=reverLinkedListRecursive(nodea,head,head.next);
    	 
     }else {
    	 ListNode node=slow.next;
    	 head=reverLinkedListRecursive(nodea,head,head.next);
     }
     
     /*if(fast.next==null) {
    	 LinkedList node=slow.next;
    	 head=reverLinkedListRecursive(nodea,head,head.next);
     }*/
     
     while(head!=null || nodea!=null) {
    	 if(nodea.data!=head.data) {
    		 System.out.println("Not a palindrome");
    		 break;
    	 }
    	 nodea=nodea.next;
    	 head=head.next;
     }
     
     if((head==null && nodea!=null)||(head!=null && nodea==null)) {
    	 System.out.println("not a palindrome");
     }
    }
   
   
   public static void reverseLinkedList(ListNode head) {
	   
   }

   
   public static ListNode reverLinkedListRecursive(ListNode a,ListNode b,ListNode c) {
	   if(c==null) {
		   b.next=a;
		   
		   return b;
	   }
	   
	   b.next=a;
	   a=b;
	   b=c;
	   c=c.next;
	   return reverLinkedListRecursive(a,b,c);
   }
   
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	   ListNode result=null;
	   ListNode headResult=null;
	   int carry=0;
	   
	   ListNode head1=l1;
	   ListNode head2=l2;
	   
	   
	   while(head1!=null || head2!=null) {
		   int sum=0;
		  
		   if(head1!=null) {
			   sum=sum+head1.data;
			   head1=head1.next;
		   }
		   
		   if(head2!=null) {
			   sum=sum+head2.data;
			   head2=head2.next;
		   }
		   sum=sum+carry;
		   if(sum>9) {
			   
			   sum=sum%10;
			   carry=1;
		   }else {
			   carry=0;
		   }
		   
		   if(result==null) {
			   result=new ListNode(sum);
			   headResult=result;
		   }else {
			   result.next=new ListNode(sum);
			   result=result.next;
		   }
		   
		  
		   
		 
		   
	   }
	   
	   if(carry==1) {
		   if(result==null) {
			   result=new ListNode(carry);
			   headResult=result;
		   }else {
			   result.next=new ListNode(carry);
			   result=result.next;
		   }
	   }
	   
	   
	   return headResult;
   }
   
   
    
	public static void main(String[] args) {
		int []val= {9,9,9};
		int []val2= {1};
		ListNode head1=Helper.createList(val);
		ListNode head2=Helper.createList(val2);
		ListNode result=addTwoNumbers(null,null);
		Helper.printLinkedList(result);
	}

}
