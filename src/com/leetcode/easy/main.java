package com.leetcode.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	
	void readFile(char[][] grades) throws IOException {
		File gradeFile=new File("grades.txt");
		
		if(!gradeFile.exists()) {
			System.out.println("File Not Found and hence cannot be open");
		}else {
			BufferedReader br = new BufferedReader(new FileReader(gradeFile));
			String line=null;
			int i=0,j=0;
		    while((line=br.readLine())!=null) {
		    	grades[i][j]=line.charAt(0);
				j++;
				if(j==3) {
					i=i+1;
					j=0;
				}
			}
		}
	}
	
	void displayGrades(char [][]grades) {
		
	}
	
	void calculateTotal() {
		
	}
	
	void caculateGPA() {
		
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		
		char[][]grades=new char[5][3];
		
		
	}
}
