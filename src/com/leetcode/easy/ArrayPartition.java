package com.leetcode.easy;

import java.util.Arrays;

public class ArrayPartition {

	public static void maxSumOfMin(int []nums){
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		
		int count=0;
		for(int i=0;i<nums.length;i=i+2){
			count=count+nums[i];
		}
		
		System.out.println("Max is "+count);
	}
	
	public static void main(String[] args) {
		int []nums={1,4,3,2};
		maxSumOfMin(nums);
	}
}
