package com.leetcode.medium;

import com.linklist.Helper;
import com.linklist.ListNode;
import java.util.*;

public class LinkedListProblems {

	
public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second=head.next;
        int i=0;
        
        while(i!=n) {
        	first=second;
        	second=second.next;
        	i++;
        }
        
        first.next=first.next.next;
        
        return head;
    }


public static void swapPairs(ListNode head) {
	
    ListNode a=head;
    ListNode b=null;
    ListNode c=a.next;
    ListNode head1=null;
    if(head1==null) {
		head1=a.next;
		
	}
    while(a!=null && a.next!=null) {
    	a.next=c.next;
    	c.next=a;
    	if(b!=null) {
    		b.next=c;
    	}
    	b=a;
    	
    	a=a.next;
    	if(a!=null && a.next!=null) {
    		c=a.next;
    	}
    	
    	
    }
    Helper.printLinkedList(head1);
}


public static void main(String[] args) {
	int[]nums= {1,2};
	//2,1,4,3,6,5
	ListNode a=Helper.createList(nums);
	swapPairs(a);
}
}
