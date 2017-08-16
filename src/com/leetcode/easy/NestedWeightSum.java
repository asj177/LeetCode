package com.leetcode.easy;
import java.util.List;



/*  Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
[1,[4,[6]]]
*/
public class NestedWeightSum {

	public void depthSum(List<NestedInteger> nestedList) {
		int count=0;
		int depth=1;
		for(NestedInteger val:nestedList){
			if(!val.isInteger()){
				
				//count=
			}else{
				count=depth*val.getInteger();
			}
		}
		
	}
	
	void helper(NestedInteger number,int depth){
		if(! number.isInteger()){
			
		}
	}
}


