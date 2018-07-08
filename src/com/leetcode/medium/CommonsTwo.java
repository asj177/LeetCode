package com.leetcode.medium;

import java.util.*;

import com.linklist.ListNode;
import com.tree.TreeNode;

public class CommonsTwo {

	
	public static ListNode helperAddNumbers(ListNode l1,ListNode l2,int carry) {
		if(l1==null && l2==null) {
			if(carry==1) {
				return new ListNode(1);
			}
			return null;
		}
		
		if(l1==null) {
			int data=l2.data+carry;
			ListNode d=new ListNode(data%10);
			
				
				d.next=helperAddNumbers(l2.next,null,data>=10?1:0);
				
			
			return d;
		}
		
		if(l2==null) {
			int data=l1.data+carry;
			ListNode d=new ListNode(data%10);
			
				
				d.next=helperAddNumbers(l1.next,null,data>=10?1:0);
				
			
			return d;
		}
		int data=l1.data+l2.data+carry;
		ListNode node=new ListNode(data%10);
		node.next=helperAddNumbers(l1.next,l2.next,data>=10?1:0);
		return node;
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return helperAddNumbers(l1,l2,0);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max=Integer.MIN_VALUE;
		
		if(s.length()==0 || s.length()==1) {
			return s.length();
		}
		
		if(s.length()==2) {
			if(s.charAt(0)==s.charAt(1)) {
				return 1;
			}else {
				return 2;
			}
		}
		int point1=0;
		int point2=1;
		HashSet<Character> map=new HashSet<Character>();
		map.add(s.charAt(point1));
		while(point2<s.length()) {
			if(map.contains(s.charAt(point2))) {
				max=Math.max(max, Math.abs(point2-point1-1)+1);
				point1=point1+1;
				map.clear();
				map.add(s.charAt(point1));
				point2=point1+1;
				continue;
			}
			map.add(s.charAt(point2));
			max=Math.max(max, Math.abs(point2-point1)+1);
			point2++;
		}
		
		return max;
	}
	
	public static void convert(String s, int numRows) {
		ArrayList<String> temp=new ArrayList<String>();
		
		int i=0;
		
		while(i<s.length()) {
			StringBuilder middle=new StringBuilder();
			int j=0;
			while(j<numRows && j+i<s.length()) {
				middle.append(s.charAt(j+i));
				j++;
			}
			temp.add(middle.toString());
			
			i=i+j;
			j--;
			while(j>1) {
				String t=""+s.charAt(i);
				temp.add(t);
				j--;
				i++;
			}
			
			
		}
		
		for(String b:temp) {
			System.out.println(b);
		}
		
		
		ArrayList<StringBuilder> rowResult=new ArrayList<StringBuilder>();
		
		for(int m=0;m<numRows;m++) {
			rowResult.add(new StringBuilder(""));
		}
		
		
		
	}
	
	//ab{cd{ef}gh}ik
	//ab{cd{ef{gh}ik}lm}no
	
	
	public static void ms(String s) {
		
	}
	
	public static int myAtoi(String str) {
		long result=0;
		
		if(str.isEmpty() ) {
			return 0;
		}
		
		
		int i=0;
		
		
		boolean isNumberFound=false;
		String temp="";
		boolean isNegative=false;
		
		while(i<str.length()) {
			char c=str.charAt(i);
			if(c==' '&& isNumberFound) {
				break;
			}
			
			if(c==' ') {
				i++;
				continue;
			}
			if(i==0 && c!='-' && !Character.isDigit(c) && c!='+') {
				return 0;
			}else {
				
				if(c=='-' && i==0 ) {
					isNegative=true;
					i++;
					continue;
				}
				
				if(c=='+' && i==0) {
					//isNegative=true;
					i++;
					continue;
				}
				
				if(!Character.isDigit(c) && c!=' ') {
					break;
				}
				isNumberFound=true;
				temp=temp+c;
				i++;
				
			}
			
		}
		
		int n=temp.length()-1;
		long v=1;
		while(n>=0) {
			if(result>Integer.MAX_VALUE && !isNegative) {
				return Integer.MAX_VALUE;
			}
			
			if(isNegative && result>(long)Integer.MAX_VALUE+1) {
				return Integer.MIN_VALUE;
			}
			
			int c=Character.getNumericValue(temp.charAt(n));
			
			result=result+c*v;
			v=v*10;
			n--;
		}
		
		/*if(result>Integer.MAX_VALUE && !isNegative) {
			return Integer.MAX_VALUE;
		}
		
		long minR=(long)Integer.MAX_VALUE+1;
		if(isNegative && result>minR) {
			return Integer.MIN_VALUE;
		}*/
		
		return isNegative?-1*(int)result:(int)result;
	}
	
	public static int Min=Integer.MAX_VALUE;
	public static boolean ifBst(TreeNode node) {
		if(node==null) {
			return true;
		}
		if(!ifBst(node.left)) {
			return false;
		}
		
		Min=node.val;
		
		if(node.val<Min) {
			return false;
		}
		
		return ifBst(node.right);
		
		
		
	}
	public static void main(String[] args) {
		System.out.println(myAtoi("4193 with words"));
		
	}
}
