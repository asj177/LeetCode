package com.leetcode.medium;

import java.util.*;

import com.linklist.Helper;
import com.linklist.ListNode;

public class CommonProblems {
	
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> result=new ArrayList<List<String>>();
	        
	        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
	        
	        for(String s:strs) {
	            char [] t=s.toCharArray();
	            Arrays.sort(t);
	            String temp=new String(t);
	            if(map.containsKey(temp)) {
	            	map.get(temp).add(s);
	            	
	            }else {
	            	List<String> list=new ArrayList<String>();
	            	list.add(s);
	            	map.put(temp, list);
	            }
	        }
	        
	        result.addAll(map.values());
	        return result;
	}
	 
	 
	 
	 public static void generateMatrix(int n) {
	        int [][]matrix=new int[n][n];
	        spiralOrder(matrix);
	        HelperUtils.printMatrix(matrix);
	    }
	 
	 public static void spiralOrder(int[][] matrix) {
	        int rowBegin =0;//rowBegin
	        int rowEnd=matrix.length-1;//rowEnd
	        int colEnd=matrix[0].length-1;//colEnd
	        int colBegin=0;//colBegin
	        List<Integer> result=new ArrayList<Integer>();
	        int i=1;
	        while(rowBegin <=rowEnd && colBegin<=colEnd) {
	        	//left
	        	for(int j=colBegin;j<=colEnd;j++) {
	        		matrix[rowBegin ][j]=i;
	        		i++;
	        		result.add(matrix[rowBegin ][j]);
	        	}
	        	
	        	rowBegin ++;
	        	//i++;
	        	//Bottom
 	        	for(int j=rowBegin;j<=rowEnd;j++) {
 	        		matrix[j][colEnd]=i;
 	        		i++;
	        		result.add(matrix[j][colEnd]);
	        	}
 	        	colEnd--;
	        	//Right
	        	for(int j=colEnd;j>=colBegin && rowEnd>=rowBegin ;j--) {
	        		matrix[rowEnd][j]=i;
	        		i++;
	        				
	        		result.add(matrix[rowEnd][j]);
	        	}
	        	
	        	//top
	        	rowEnd--;
	        	for(int j=rowEnd;j>=rowBegin  && colEnd>=colBegin;j--) {
	        		matrix[j][colBegin]=i;
	        		i++;
	        		result.add(matrix[j][colBegin]);
	        	}
	        	colBegin++;
	        	
	        }
	        
	        //System.out.println(result);
	        
	    }
	 
	 
	 public static boolean canJump(int[] nums) {
	        int i=0;
	        
	        while(i<=nums.length-1) {
	        	int t=nums[i];
	        	
	        	if(t==0) {
	        		return false;
	        	}
	        	
	        	if(t+i>=nums.length-1) {
	        		return true;
	        	}
	        		
	        	int a=Integer.MIN_VALUE;
	        	
	        	int j=i+1;
	        	int b=t+i;
	        	while(b>=j) {
	        		if(nums[j]>a) {
	        			a=nums[j];
	        			t=j;
	        		}
	        		i=t;
		        	j++;
	        	}
	        	
	        }
	        	
	        
	        return true;
	    }
	 
	 
	 public static void merge(List<Interval> intervals) {
		 
		  if(intervals.size()==1 || intervals.size()==0) {
			  return ;
		  }
	      List<Interval> result=new ArrayList<Interval>();
	      
	      Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				if(arg1.start>arg0.start) {
					return -1;
				}
				
				if(arg0.start>arg1.start) {
					return 1;
				}
				
				return 0;
			}
	    	  
	      });
	      
	      Interval it=new CommonProblems().new Interval(intervals.get(0).start,intervals.get(0).end);
	      
	      
	      
	      for(int i=1;i<intervals.size();i++) {
	    	  if(intervals.get(i).start<=it.end) {
	    		  it.end=Math.max(it.end, intervals.get(i).end);
	    	  }else {
	    		  result.add(new CommonProblems().new Interval(it.start,it.end));
	    		  it=new CommonProblems().new Interval(intervals.get(i).start,intervals.get(i).end);
	    	  }
	      }
	      
	      result.add(new CommonProblems().new Interval(it.start,it.end));
	      
	      
	      for(Interval i:result) {
	    	  System.out.println("["+i.start+","+i.end+"]");
	      }
	      
	      
	}
	 public static ListNode rotateRight(ListNode head, int k) {
	         
		 if(head==null) {
			 return head;
		 }
		 
		    ListNode pointer=head;
		    
		    int length=0;
		    ListNode tail=head;
		    while(pointer!=null) {
		    	 pointer=pointer.next;
		    	 if(pointer!=null) {
		    		 tail=tail.next;
		    		 
		    	 }
		    	 length++;
		    	 
		    }
		    
		    
		    
		    int toMove=k>=length?k%length:k;
		    
		    if(toMove==0) {
		    	return head;
		    }
		    
		    pointer=head;
		    
		    ListNode slowPointer=head;
		    
		    while(toMove!=0) {
		    	pointer=pointer.next;
		    	toMove--;
		    }
		   
		    while(pointer.next!=null) {
		    	slowPointer=slowPointer.next;
		    	pointer=pointer.next;
		    }
		    
		    
		 
		    ListNode newHead=slowPointer.next;
		    tail.next=head;
		    slowPointer.next=null;
		   
		    
		 
		     return newHead;
	    }
	 
	 public static int uniquePaths(int m, int n) {
		 
		    if(m==0||n==0) {
		    	return 1;
		    }
	        
	        
	        int [][]paths=new int[m][n];
	        
	        for(int i=0;i<paths[0].length;i++) {
	        	paths[0][i]=1;
	        }
	        
	        for(int i=0;i<paths.length;i++) {
	        	paths[i][0]=1;
	        }
	        
	        for(int i=1;i<paths.length;i++) {
	        	for(int j=1;j<paths[0].length;j++) {
	        		paths[i][j]=paths[i][j-1]+paths[i-1][j];
	        	}
	        }
	        return paths[paths.length-1][paths[0].length-1];
	       
	    }
	 
	 
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	       
		 
		 for(int i=0;i<obstacleGrid.length;i++) {
			 for(int j=0;j<obstacleGrid[0].length;j++) {
				 
				 if(obstacleGrid[i][j]==0) {
					 obstacleGrid[i][j]=1;
					 continue;
				 }
				 if(obstacleGrid[i][j]==1) {
					 obstacleGrid[i][j]=0;
					 continue;
				 }
				 
				 
			 }
		 }
		 
		  for(int i=1;i<obstacleGrid.length;i++) {
			  for(int j=1;j<obstacleGrid[0].length;j++) {
				 
				  if(obstacleGrid[i][j]==0) {
					  continue;
				  }
				  
				  obstacleGrid[i][j]=i>0?obstacleGrid[i-1][j]:0 + j>0?obstacleGrid[j-1][i]:0;
			  }
		  }
		 
		 
		 return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
	    }
	 
	 public class Interval {
		 int start;
		 int end;
		 Interval(){start=0;end=0;}
		 Interval(int s,int e){
			 start=s;
			 end=e;
		 }
	 }
	 
	 
	 public static int minPathSum(int[][] grid) {
	    
    for(int i=0;i<grid.length;i++) {
    	for(int j=0;j<grid[i].length;j++) {
    		if(i==0 && j==0) {
    			continue;
    		}
    		
    		if(i==0) {
    			grid[i][j]=grid[i][j-1]+grid[i][j];
    			continue;
    		}
    		
    		if(j==0) {
    			grid[i][j]=grid[i-1][j]+grid[i][j];
    			continue;
    		}
    		
    		grid[i][j]=grid[i][j]+Math.min(grid[i][j-1], grid[i-1][j]);
    		
    	}
    }
	  
		 
     return grid[grid.length-1][grid[0].length-1];
		 
		 
   }
	 
	 
	 public static void  getPermutation(int n, int k) {
	        int [] arr=new int[n];
	        for(int i=0;i<arr.length;i++) {
	        	arr[i]=i+1;
	        }
	        
	        int pointer=0;
	        StringBuilder s=new StringBuilder();
	        int totalN=n;
	        while(k>2) {
	        	int maxFact=getFactNumber(n);
	        	int perFact=maxFact/n;
	        	int no=(int)Math.ceil(k/perFact);
	        	no=no%n;
	        	int temp=arr[no+pointer];
	        	arr[no+pointer]=arr[pointer];
	        	arr[pointer]=temp;
	        	int mod=k/perFact;
	        	k=k-mod*perFact;
	        	n=n-1;
	        	pointer=pointer+1;
	        	
	        }
	        
	       for(int i:arr) {
	    	   s.append(String.valueOf(i));
	       }
	       System.out.println(s.toString());
	 }
	 
	 public static int getFactNumber(int n) {
		 int result=1;
		 
		 while(n>=1) {
			 result=result*n;
			 n=n-1;
		 }
		 
		 return result;
	 }
	 
	 
	 public static void simplifyPath(String path) {
	     String[]unix=path.split("/");
	     Stack<String> q=new Stack<String>();
	     
	     for(String t:unix) {
	    	 if(t.isEmpty() || t.equals(".")) {
	    		 continue;
	    	 }
	    	 
	    	 if(t.equalsIgnoreCase("..")) {
	    		 if(!q.isEmpty()) {
	    			 q.pop();
	    		 }
	    		 continue;
	    	 }
	    	 
	    	 q.push(t);
	    	 
	     }
	     
	     StringBuilder simple=new StringBuilder();
	     if(q.isEmpty()) {
	    	 simple.append("/");
	     }
	     
	     ArrayList<String> st=new ArrayList<String>();
	     while(!q.isEmpty()) {
	    	st.add(q.pop());
	     }
	     
	     
	     for(int i=st.size()-1;i>=0;i--) {
	    	 simple.append("/");
	    	 simple.append(st.get(i));
	    	 
	     }
	     
		 System.out.println(simple.toString());
	}
	 
	 
	 public static boolean searchMatrix(int[][] matrix, int target) {
	     int row=-1;
	     
	     if(matrix.length==0 || matrix[0].length==0) {
	    	 return false;
	     }
		 for(int i=0;i<matrix.length;i++) {
			 
			 if(matrix[i][0] <=target && matrix[i][matrix[i].length-1]>=target) {
				 row=i;
				 break;
			 }
		 }
		 
		 if(row==-1) {
			 return false;
		 }
		 
		 int left=0,right=matrix[0].length-1;
		 
		 while(left<=right) {
			 int mid=(left+right)/2;
			 
			 if(matrix[row][mid]==target) {
				 return true;
			 }
			 
			 if(matrix[row][right]==target) {
				 return true;
			 }
			 if(matrix[row][left]==target) {
				 return true;
			 }
			 
			 if(matrix[row][mid]<target) {
				 left=mid+1;
			 }
			 
			 if(matrix[row][mid]>target) {
				 right=mid-1;
			 }
		 }
		 
		 return false;
	}
	 
	 
	 public static void setZeroes(int[][] matrix) {
		 
		   ArrayList<int[]> track=new ArrayList<int[]>();
	        for(int i=0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix[i].length;j++) {
	        		if(matrix[i][j]==0) {
	        			int []t=new int[2];
	        			t[0]=i;
	        			t[1]=j;
	        			track.add(t);
	        		}
	        	}
	        }
	        
	       for(int []t:track) {
	    	   setOthers(matrix,t[0],t[1]);
	       }
	        
	        HelperUtils.printMatrix(matrix);
	
	 }
	 
	 public static void setOthers(int[][]matrix,int r,int c) {
		 for(int i=0;i<matrix.length;i++) {
			 
				 matrix[i][c]=0;
			 
		 }
		 
		 for(int i=0;i<matrix[0].length;i++) {
			 
				 matrix[r][i]=0;
			 
		 }
	 }
	 
	 public static void main(String[] args) {
		
		int [][]matrix={
				  {0,1,2,0},
				  {3,4,5,2},
				  {1,3,1,5}
				};
		setZeroes(matrix);
	}
}
