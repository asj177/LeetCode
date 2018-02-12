package com.leetcode.medium;

import java.util.*;

public class Common {

    public String longestPalindrome(String s) {
	        
    	return "";
	 }
	 
    
    public static void intToRoman(int num) {
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        int[]arr= {1,5,10,50,100,500,900,1000};
        
        
        ArrayList<String> roman=new ArrayList<String>();
        //4899----MMMMDCCCXCIX---MMMMDCCCXCIX
        //2456 ---- LVI
        
        
        int n=1;
        
        int i=0;
        while(num>0) {
        	
        	int a=num%10 * n;
        	
        	if(map.containsKey(a)) {
        		
        		
        		roman.add(map.get(a));
        	}else {
        		 StringBuilder s1=new StringBuilder();
        		int ans=a;
        		
        		while(ans>0) {
        			int j=0;
        			
        			while(j<arr.length && arr[j]<ans) {
        				j++;
        			}
        			
        			if(map.containsKey(ans)) {
        				s1.append(map.get(ans));
        				//roman.add(map.get(ans));
        				break;
        			}
        			s1.append(map.get(arr[j-1]));
        			//roman.add(map.get(arr[j-1]));
        			ans=ans-arr[j-1];
        			
        		}
        		
        		roman.add(s1.toString());
        		
        		
        	}
        	i=i+1;
        	n=n*10;
        	num=num/10;
        }
        String romanString="";
        
        for(int f=roman.size()-1;f>=0;f--) {
        	romanString=romanString+roman.get(f);
        }
        
        System.out.println("Roman string is "+romanString);
       
    }
    
    
   
    
    public static int myAtoi(String str) {
    	
        str=str.trim();
        boolean isNegative=false;
        int length=str.length();
        
        if(str.charAt(0)=='-') {
        	isNegative=true;
        	
        	if(str.length()>11) {
        		return 0;
        	}
        	
        	if(length==11 && Character.getNumericValue(str.charAt(1))>2) {
        		return 0;
        	}
        	//length=length-1;
        }
        
        
        int num=1;
        
        if(length>10 && !isNegative) {
        	return 0;
        }
        
        if(length==10 && Character.getNumericValue(str.charAt(0))>2 && !isNegative) {
        	return 0;
        }
        
        int n=0;
       
        int i=length-1;
        int notDigits=0;
       
        while(i>=0) {
        	
        	
        	if(Character.isDigit(str.charAt(i))) {
        		
        		if(isNegative) {
            		if(Integer.MIN_VALUE+n>-2000000000 && i==1) {
            			
            			return 0;
            		}
            	}
        		
        		n=n+Character.getNumericValue(str.charAt(i))*num;
        	
        	/*
        	if(i==1) {
        		System.out.println(n);
        	}*/
        	
        	
        	if(Integer.MAX_VALUE-n<2000000000 && i==1 && !isNegative) {
        		return 0;
        	}
        	num=num*10;
        	}else {
        		notDigits=notDigits+1;
        		if(notDigits>1) {
        			return 0;
        		}
        	}
        	i--;
        	
        	
        }
        
        if(isNegative) {
        	n=n*-1;
        }
       return n;
    	
    }
    
    
    
 public static void letterCombinations(String digits) {
        
	 HashMap<Integer,String>map=new HashMap<Integer,String>();
	 map.put(2, "abc");
	 map.put(3, "def");
	 map.put(4, "ghi");
	 map.put(5, "jkl");
	 map.put(6, "mno");
	 map.put(7, "pqrs");
	 map.put(8, "tuv");
	 map.put(9, "xyz");
	 
	 Queue<String> q=new LinkedList<String>();
	 
	 for(int i=0;i<digits.length();i++) {
		 q.add(map.get(Character.getNumericValue(digits.charAt(i))));
	 }
	 
	 
	 ArrayList<String>result=new ArrayList<String>();
	 String first=q.remove();
	 
	 for(int a=0;a<first.length();a++) {
		 String ac="";
		 result.add(ac+first.charAt(a));
	 }
	 //result.add(first);
	 int index=1;
	 while(!q.isEmpty()) {
		 int le=result.size();
		 String a=result.get(0);
		 String b=q.remove();
		 
		 for(int i=0;i<le;i++) {
			 
			 for(int j=0;j<b.length();j++) {
				 String r="";
				 r=r+result.get(i)+b.charAt(j);
				 result.add(r);
			 }
			 
		 }
		 
		 int remove=0;
		 
		 while(remove<le) {
			 result.remove(0);
			 remove++;
		 }
		 
	 }
	 
	 System.out.println(result.size());
	 for(String a:result) {
		 System.out.println(a);
	 }
	 }
    
 
 /**
  * For example, given array S = {-1 2 1 -4}, and target = 1.
{-4,-1,1,2}
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
  * @param nums
  * @param target
  */
 public static void threeSumClosest(int[] nums, int target) {
     int minDiff=Integer.MAX_VALUE;
     
     Arrays.sort(nums);
     int i=0;
     int j=nums.length-1;
     
     while(i<j-2) {
    	 int first=nums[i]+nums[i+1]+nums[j];
    	 int second=nums[i]+nums[j]+nums[j-1];
    	 
    	 
    	 if(first-target==0) {
    		 break;
    	 }
    	 
    	 if(second-target==0) {
    		 break;
    	 }
    	 if(Math.abs(first-target)<Math.abs(second-target)) {
    		 minDiff=checkNear(minDiff,first,target);
    		 System.out.println("its first ");
    		 j--;
    	 }else {
    		 minDiff=checkNear(minDiff,second,target);
    		 System.out.println("its second ");
    		 i++;
    	 }
    	 
     }
     for(int a:nums) {
    	 System.out.print(a+" ");
     }
     
     System.out.println("\n i is "+i+" j is "+j);
     
     System.out.println(minDiff);
 }
 
 
 public static int checkNear(int a,int b,int target) {
	 
	 if(a==Integer.MAX_VALUE) {
		 return b;
	 }
	 if(Math.abs(a-target) > Math.abs(b-target)) {
		 return b;
	 }
		 return a;
	 
 }
 
 
/* 
 * -1, 0, 1, 2, -1, -4---->  -4,-1,-1,0,1,2
*/ 
 public static void  threeSum(int[] nums) {
	 Arrays.sort(nums);
	 
	 List<List<Integer>> result=new ArrayList<List<Integer>>();
	 int preFirst=Integer.MAX_VALUE;
	 int preSecond=Integer.MAX_VALUE;
	 int preThird=Integer.MAX_VALUE;
	 for(int i=0;i<nums.length;i++) {
		 
		 if(preFirst==nums[i]) {
			 continue;
		 }
		 int first=nums[i];
		 preFirst=first;
		 int head=i+1;
		 int tail=nums.length-1;
		 
		 while(head<tail) {
			 
			 if(preSecond==nums[head]) {
				 head++;
				 continue;
			 }else {
				 preSecond=nums[head];
			 }
			 
			 if(preThird==nums[tail]) {
				 tail--;
				 continue;
			 }else {
				 preThird=nums[tail];
			 }
			 int s=first+nums[head]+nums[tail];
			 if(s==0) {
				 List<Integer> temp=new ArrayList<Integer>();
				 temp.add(first);
				 temp.add(nums[head]);
				 temp.add(nums[tail]);
				 result.add(temp);
				 head++;
				 tail--;
			 }
			 
			 if(s<0) {
				 head++;
			 }
			 
			 if(s>0) {
				 tail--;
			 }
		 }
	 }
	 
	 for(List<Integer> t:result) {
		 System.out.println(t);
	 }

 }
 
 static List<String>com=new ArrayList<String>();
 
 public static void generateParenthesis(int n) {
     
 }
 
 public static void helperCombine(int n,String s,char c) {
	 if(n==0) {
		 com.add(s);
		 return;
	 }
	 
	 
	
	 if(c=='(') {
		 s=s+c+')';
		 
	 }
	 
	 if(c==')') {
		 s=s+c+')';
	 }
	 helperCombine(n,s,'(');
	 helperCombine(n,s,'(');
	 
 }
 
    
	public static void main(String[] args) {
		int []n= {-1, 0, 1, 2, -1, -4};
		threeSum(n);
		
	}
}
