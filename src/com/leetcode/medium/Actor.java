package com.leetcode.medium;
import java.util.*;
public class Actor {

	String name;
	ArrayList<Actor> ac;
	
	public Actor(String name,ArrayList<Actor> a) {
		this.name=name;
		this.ac=a;
	}
	
	public boolean isLinked(String name) {
		Queue<Actor> q=new LinkedList<Actor>();
		
		for(Actor a:this.ac) {
			q.add(a);
		}
		
		while(q.size()>0){
			Actor t=q.remove();
			
			
			if(t.name.equals(name)){
				return true;
			}
			
			for(Actor m: t.ac) {
				q.add(m);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Actor a=new Actor("arpit",new ArrayList<Actor>());
		System.out.println(a.isLinked("mangesh"));
		
	}
	
}
