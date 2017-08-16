package com.leetcode.easy;

import java.util.*;
import java.util.Map.Entry;

public class PalindromePermutation {
	
	public static boolean check(String s){
		char[]ch=s.toCharArray();
		
		HashMap<Character,Integer>track=new HashMap<Character,Integer>();
		
		for(int i=0;i<ch.length;i++) {
			if(track.containsKey(ch[i])) {
				track.put(ch[i], track.get(ch[i])+1);
			}else{
				track.put(ch[i], 1);
			}
		}
		
		Set<Entry<Character,Integer>> it=track.entrySet();
		boolean firstOccured=true;
		Iterator<Entry<Character,Integer>> ii=it.iterator();
		
		while(ii.hasNext()) {
			if(ch.length%2==0) {
				if (ii.next().getValue()%2!=0){
					return false;
				}
			}else{
				if(ii.next().getValue()%2!=0 && firstOccured) {
					firstOccured=false;
				}else{
					if(ii.next().getValue()%2!=0 && !firstOccured){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(check("naman"));
	}

}
