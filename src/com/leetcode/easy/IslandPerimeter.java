package com.leetcode.easy;

public class IslandPerimeter {

	void calculate(int [][]grid) {
		int r=0;
		int c=0;
		
		for(int i=0;i<grid[0].length;i++) {
			for(int j=0;j<grid.length;j++) {
				if(grid[i][j]==1) {
					r=i;
					c=j;
					break;
				}
			}
		}
		
		int peri=0;
		while(r>=0 && r<grid[0].length && c>=0 && c<grid.length) {
			
		}
	}
	
	void  getSides(int [][]grid,int r,int c) {
		int size=0;
		
		if(r==0 || c==0) {
			
		}else{
			int sides;
		}
		
		
	}
}
