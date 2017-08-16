package com.leetcode.easy;

public class Complement {

	public static void main(String[] args) {
		int num=3;
		int count=0;
		
		while(num>0){
			System.out.println(Integer.toBinaryString(num&1));
			int temp=num^1;
			count=count+(num&1);
			num=num>>1;
		}
		System.out.println(count);
	}
}
