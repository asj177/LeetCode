package com.leetcode.easy;

public class MatrixReshap {

	 public static int[][] matrixReshape(int[][] nums, int r, int c) {
		 int rowsOriginal=nums.length;
		 int colsOrgininal=nums[0].length;
		 int [][]newMatrix=new int[r][c];
	        if(r*c!=rowsOriginal*colsOrgininal){
	        	return nums;
	        }else{
	        	int rowNew=0;
	        	int colsNew=0;
	        	for(int i=0;i<rowsOriginal;i++){
	        		for(int j=0;j<colsOrgininal;j++){
	        			newMatrix[rowNew][colsNew]=nums[i][j];
	        			
	        			colsNew++;
	        			if(rowNew>r){
	        				rowNew=0;
	        			}
	        			if(colsNew>=c){
	        				rowNew++;
	        				colsNew=0;
	        			}
	        		}
	        		//print(newMatrix);
	        	}
	        	
	        	
	        }
	        return newMatrix;
	    }
	 
	 public static void print(int[][]newMat){
		 for(int i=0;i<newMat[0].length;i++){
				for(int j=0;j<newMat.length;j++){
					System.out.print(newMat[i][j]+" ");
				}
				System.out.println(" ");
			}
	 }
	 
	 public static void main(String[] args) {
		int [][]mat={{1,2,3},{4,5,6},{5,6,7},{8,9,10}};
		int [][]newMat=matrixReshape(mat,6,2);
		
	}
}
