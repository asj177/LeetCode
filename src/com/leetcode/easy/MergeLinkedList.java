package com.leetcode.easy;

import com.linklist.Helper;
import com.linklist.ListNode;

public class MergeLinkedList {

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
    
    
	public static void main(String[] args) {
		int []n1= {1};
		//say("11");
		countAndSay(10);
	}
}
