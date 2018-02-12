package com.leetcode.easy;
import java.util.*;
public class BackTracking {

	ArrayList<String> s=new ArrayList();
	
	 public List<String> readBinaryWatch(int num) {
	       
		return s;
	}
	 
	 
	 
	 
	 public static String helper(int num,String s) {
		 if(num==0) {
			 return "0";
		 }
		 
		 for(int i=0;i<num;i++) {
			 String t=helper(num-1,s).equals("0")?"0":"1";
			 s=s+t;
		 }
		 System.out.println(s);
		 return s;
	 }
	
	 List<String>combine=new ArrayList<String>();
	 
	 public  void combine(int n,int total,int[]arr) {
		 if(n==0) {
			
			 addToCombine(arr);
			 return;
		 }
		 
		 
		 for(int i=total;i>=0;i--) {
			 arr[i]=1;
			 combine(n-1,i-1,arr);
			 arr[i]=0;
			 
		 }
		 
		 
	 }
	 
	 
	 public String getTime(int []arr) {
		 
		 String time="";
		int hour=0;
		 int minute=0;
		
		 for(int i=9;i>=4;i--) {
			 minute=minute+(int)(arr[i]*Math.pow(2, 9-i));
		 }
		 
		 for(int i=3;i>=0;i--) {
			 int val=arr[i];
			 int toMultiple=(int)Math.pow(2, 3-i);
			 hour=hour+(int)(val*toMultiple);
		 }
		 
		 if(hour>11) {
			 return "";
		 }
		 
		 if(minute>59) {
			 return "";
		 }
		 
		 if(minute<10) {
			 time=hour+":"+"0"+minute;
		 }else {
			 time=hour+":"+minute;
		 }
		 return time;
		 
	 }
	 
	 public String getVisited(int[]arr) {
		 String s="";
		 for(int i=0;i<arr.length;i++) {
			 s=s+arr[i];
		 }
		 
		 return s;
	 }
	 
	 public void addToCombine(int []arr) {
		 ArrayList<Integer>a=new ArrayList<Integer>();
		 for(int i=0;i<arr.length;i++) {
			 a.add(arr[i]);
		 }
		 
		 String time=getTime(arr);
		 if(!time.isEmpty()) {
			 combine.add(time);
		 }
		 
	 }
	public static int getBinary(String s) {
		
		int result=0;
		for(int i=s.length()-1;i>=0;i--) {
			int val=(s.length()-1)-i;
			int toadd=(int)Math.pow(2, val);
			int n=Character.getNumericValue(s.charAt(i))*toadd;
			result=result+n;
		}
		return result;
	}
	
	
   

	public static void main(String[] args) {
		int []arr= {0,0,0,0,0,0,0,0,0,0};
		
		BackTracking bt=new BackTracking();
		bt.combine(2,9,arr);
		HashSet<String>derived=new HashSet<String>();
		for(String a:bt.combine) {
			derived.add(a);
		}
		
		String[]real= {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
		System.out.println(derived.size());
		System.out.println(real.length);
		for(String b:real) {
			if(!derived.contains(b)) {
				System.out.println(b);
			}
		}
		
	}
}
