package com.linklist;

public class Helper {
	
	public static ListNode createList(int []nums) {
		ListNode head=null;
		ListNode a=null;
		for(int i=0;i<nums.length;i++) {
			ListNode node=new ListNode(nums[i]);
			
			if(i==0) {
				head=node;
				a=head;
				
			}else {
				a.next=node;
				a=node;
			}
				
			
		}
		
		return head;
	}
	
	public static void printLinkedList(ListNode node) {
		ListNode follower=node;
		System.out.println(" ");
		while(follower!=null) {
			System.out.print(follower.data+"--->");
			follower=follower.next;
		}
		System.out.println(" ");
		System.out.println("*********");
	}

}
