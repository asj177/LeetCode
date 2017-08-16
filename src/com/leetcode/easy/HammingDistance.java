package com.leetcode.easy;

public class HammingDistance {
	public static void main(String[] args) {
		int a=5;
		int b=9;
		
		System.out.println(4&1);
		int tem=5^9;
		int count=0;
		while(tem>0){
			int val=tem&1;
			
			if(val >=1){
				count++;
			}
			tem=tem>>1;
			
		}
		System.out.println(count);
	}
	
	
	

	
}
