package com.leetcode.easy;

import java.util.*;
import java.util.Map.Entry;

import com.tree.TreeNode;
import com.tree.TreeHelper;

public class Common {

	static void reverseString(String words) {
		String[] listOfWords = words.split(" ");
		String common = "";
		int i = 0;
		for (String one : listOfWords) {
			if (i != listOfWords.length - 1) {
				common = common + reverse(one) + " ";
			} else {
				common = common + reverse(one);
			}
			i++;
		}
		System.out.println(common);
	}

	static String reverse(String word) {
		String common = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			common = common + word.charAt(i);
		}
		return common;
	}

	static void longestUncommonSubsequence(String a, String b) {
		int alen = 0;
		int blen = 0;
		int maxlen = 0;
		int intialSize = 0;
		while (blen < b.length()) {
			if (b.charAt(blen) != a.charAt(alen)) {
				blen++;
				intialSize++;
			} else {
				maxlen = intialSize > maxlen ? intialSize : maxlen;
				blen = common(a, b, blen);

				intialSize = 0;

			}
		}
		maxlen = intialSize > maxlen ? intialSize : maxlen;
		System.out.println("max len is " + maxlen);
	}

	static int common(String a, String b, int stopofblen) {
		int alen = 0;
		while (alen < a.length() && stopofblen < b.length()) {
			if (a.charAt(alen) == b.charAt(stopofblen)) {
				alen++;
				stopofblen++;
			} else {
				break;
			}
		}
		return stopofblen;
	}

	

	public static int maxDepthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(maxDepthOfTree(root.left) + 1, maxDepthOfTree(root.right) + 1);
	}

	public static boolean detectCapitalUse(String word) {
		char[] ch = word.toCharArray();
		boolean second = true;
		boolean rest = true;
		boolean first = (ch[0] >= 65 && ch[0] <= 90) ? true : false;
		if (ch.length > 1) {

			second = (ch[1] >= 65 && ch[1] <= 90) ? true : false;

			if (!first && second) {
				return false;
			}

			for (int i = 2; i < ch.length; i++) {
				if (first & second) {
					if (ch[i] <= 90 && ch[i] >= 65) {
						rest = true;
					} else {
						rest = false;
						break;
					}
				}

				if (!second && first || !first && !second) {
					if (ch[i] >= 97) {
						rest = true;
					} else {
						rest = false;
						break;
					}
				}

			}

		} else {
			return rest;
		}
		return rest;
	}

	public static void findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		for (int a : ret) {
			System.out.println(a);
		}
	}

	public static TreeNode invertBinaryTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode n = root.left;
		root.left = root.right;
		root.right = n;

		root.left = invertBinaryTree(root.left);
		root.right = invertBinaryTree(root.right);
		return root;

	}

	static int sum = 0;

	public static void converToGreaterTree(TreeNode root) {
		if (root == null) {
			return;
		}

		converToGreaterTree(root.right);
		root.val = root.val + sum;
		sum = root.val;

		converToGreaterTree(root.left);

	}

	public static boolean twoNodeHelper(TreeNode root, int difference) {

		if (root == null) {
			return false;
		}

		if (root.val == difference) {
			return true;
		}

		if (root.val > difference) {
			return twoNodeHelper(root.left, difference);
		}

		return twoNodeHelper(root.right, difference);
	}

	public static boolean towSumBinaryTree(TreeNode root, TreeNode mainRoot, int target) {
		if (root == null) {
			return false;
		}

		/*
		 * boolean val=twoNodeHelper(mainRoot,Math.abs(root.val-target));
		 * 
		 * if(val) { return true; }
		 */

		return twoNodeHelper(root.left, Math.abs(root.val - target))
				|| twoNodeHelper(root.right, Math.abs(root.val - target));

	}

	public TreeNode convertBST(TreeNode root) {
		converToGreaterTree(root);
		return root;
	}

	public void convert(TreeNode cur) {
		if (cur == null)
			return;
		convert(cur.right);
		cur.val += sum;
		sum = cur.val;
		convert(cur.left);
	}

	public static char findLetterDifference(String s, String t) {
		char[] charCompare = new char[256];

		for (int i = 0; i < s.length(); i++) {
			charCompare[s.charAt(i)] = 1;
		}

		for (int i = 0; i < t.length(); i++) {

			if (charCompare[t.charAt(i)] == 1) {

			}
			if (charCompare[t.charAt(i)] == 0) {
				return t.charAt(i);
			}
		}

		return 0;

	}

	public static void moveZeroes(int[] nums) {
		int i = 0;
		int j = 1;
		System.out.println("Length is " + nums.length);
		while (j < nums.length) {
			System.out.println("Current value of i is " + i);
			System.out.println("Current value of j is " + j);
			if (nums[i] != 0) {
				j++;
				i++;
				continue;
			}

			if (nums[i] == 0 && nums[j] == 0) {
				j++;
				continue;
			}

			if (nums[j] != 0 && nums[i] == 0) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				j++;
				continue;
			}

		}

		for (int a : nums) {
			System.out.print(a + " ");
		}

	}

	
	
	public static void maxCount(int m, int n, int[][] ops) {
		int max = 0;

		int[][] M = new int[m][n];
		int count = m * n;
		for (int x = 0; x < ops.length; x++) {
			int a = ops[x][0];
			int b = ops[x][1];

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					M[i][j] = M[i][j] + 1;
					if (M[i][j] > max) {
						count = 1;
						max = M[i][j];
					} else {
						if (M[i][j] == max) {
							count++;
						}
					}

				}
			}
		}

		System.out.println("count is " + count + " for max number" + max);
	}

	public static void twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> check = new HashMap<Integer, Integer>();
		int[] index = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (check.containsKey(nums[i])) {
				index[0] = check.get(nums[i]);
				index[1] = i;
				break;
			} else {
				check.put(target - nums[i], i);
			}
		}

		System.out.println("Locations are [" + index[0] + "," + index[1] + "]");

	}

	public static int reverse(int x) {
		long result = 0;

		while (x > 0) {
			result = result * 10 + (x % 10);
			if (result >= Integer.MAX_VALUE) {

			}
			x = x / 10;

		}
		return (int) result;
	}

	private static int getSizeOfNumber(int number) {
		int i = 1;
		while (number > 0) {
			i = i * 10;
			number = number / 10;
		}
		return i / 10;
	}

	public static boolean validParanthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);

			switch (a) {
			case '[':
				stack.push(a);
				break;
			case '(':
				stack.push(a);
				break;
			case '{':
				stack.push(a);
				break;
			case ']':

				if (!stack.isEmpty()) {
					if (stack.peek() != '[') {
						check = false;

					}

					stack.pop();
				} else {
					check = false;
				}
				break;

			case ')':

				if (!stack.isEmpty()) {
					if (stack.peek() != '(') {
						check = false;

					}

					stack.pop();
				} else {
					check = false;
				}
				break;

			case '}':

				if (!stack.isEmpty()) {
					if (stack.peek() != '{') {
						check = false;

					}

					stack.pop();
				} else {
					check = false;
				}
				break;

			}

		}

		if (!stack.isEmpty()) {

			return false;
		}

		return check;
	}

	public static String say(String s) {
		int count = 1;
		String s2 = "";
		char val = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {
			if (val == s.charAt(i)) {
				count++;
			} else {
				s2 = s2 + count + val;
				count = 1;
				val = s.charAt(i);
			}
		}
		s2 = s2 + count + val;
		return s2;
	}

	public static void countAndSay(int n) {
		String s = "";
		if (n >= 1) {
			s = s + "1";
		}
		char val = ' ';
		for (int i = 2; i <= n; i++) {

			s = say(s);

		}

		System.out.println(s);
	}
	
	public static void maxSubArray(int []nums) {
		if(nums==null || nums.length==0) {
            System.out.println(0);
        }
        
        if(nums.length==1) {
            System.out.println(nums[0]);
        }
        int sum=nums[0];
        int max=sum;
        
        for(int i=1;i<nums.length;i++) {
        	if(nums[i]>sum && sum<0) {
        		sum=nums[i];
        		
        	}else {
        		sum=sum+nums[i];
        	}
        	max=max>sum?max:sum;
        }
		
		System.out.println(max);
	}
	
	public static void lengthOfLastWord(String s) {
		
		if(s.isEmpty() || s.trim().length()==0) {
			return;
		}
        int length=0;
        int startLength=s.length()-1;
        
        while(startLength>=0 && s.charAt(startLength) ==' ') {
        	startLength--;
        }
        
        for(int i=startLength;i>=0;i--) {
            if(s.charAt(i)==' ') {
                break;
            }
            length++;
        }
        
        System.out.println(length);
    }
	
   public static void plusOne(int[] digits) {
        int []result=new int [digits.length+1];
        
        
        int carry=1;
        
        for(int i=digits.length-1;i>=0;i--) {
        	int sum=digits[i]+carry;
        	
        	if(sum>9) {
        		carry=1;
        		result[i+1]=0;
        		
        	}else {
        		result[i+1]=sum;
        		
        		carry=0;
        	}
        }
        
        
           
        	result[0]=carry;
        
        	
        	
        for(int i=0;i<result.length;i++) {
        	System.out.print(result[i]+" ");
        }
        System.out.println("*******");
        
    }

   
   public static void addBinary(String a, String b) {
      String s="";
       
      int lena=a.length()-1;
      int lenb=b.length()-1;
      int carry=0;
      
      while(lena >=0 && lenb>=0) {
    	  if(a.charAt(lena) ==b.charAt(lenb) && a.charAt(lena)=='1') {
    		  if(carry==0) {
    			  s=s+"0";
    			  carry=1;
    		  }else {
    			  s=s+"1";
    			  carry=1;
    			  
    		  }
    	  }
    	  
    	  if(a.charAt(lena) ==b.charAt(lenb) && a.charAt(lena)=='0') {
    		  if(carry==0) {
    			  s=s+"0";
    			  carry=0;
    		  }else {
    			  s=s+"1";
    			  carry=0;
    		  }
    	  }
    	  
    	  if(a.charAt(lena) !=b.charAt(lenb)) {
    		  if(carry==0) {
    			  s=s+"1";
    			  carry=0;
    		  }else {
    			  s=s+"0";
    			  carry=1;
    		  }
    	  }
    	  
    	  lena--;
    	  lenb--;
      }
      
      int lenRemain=(lena>lenb?lena:lenb);
      String toMake=a.length()>b.length()?a:b;
      for(int i=lenRemain;i>=0;i--) {
    	  if(toMake.charAt(i)==String.valueOf(carry).charAt(0) && carry==0) {
    		  s=s+"0";
    		  carry=0;
    	  }
    	  
    	  if(toMake.charAt(i)=='1' && carry==1) {
    		  s=s+"0";
    		  carry=1;
    	  }
    	  
    	  if(toMake.charAt(i)!=String.valueOf(carry).charAt(0)) {
    		  s=s+"1";
    		  carry=0;
    	  }
    	  
    	  
      }
      
       if(carry==1) {
    	   s=s+carry;
       }
       
       System.out.println(reverseBinaryString(s));
       
       System.out.println("Actual value should be "+110110);
   }
   
   public static String reverseBinaryString(String s) {
	   String a="";
	   for(int i=s.length()-1;i>=0;i--) {
		   a=a+s.charAt(i);
	   }
	   return a;
   }
   
public static void mySqrt(int x) {
	int head=1;
	int tail=x;
	int ans=1;
	while(head<tail) {
		int mid=head+(tail-head)/2;
		
		
		if(mid==(x/mid)) {
			ans=mid;
			break;
		}else {
			if(mid>=(x/mid)) {
				tail=mid-1;
				//ans=mid;
			}else {
				head=mid +1;
				ans=mid;
			}
		}
		
	}
	
	
	System.out.println(" answer is "+ans);
}

public static int climbStairs(int n) {
    if(n==1) {
    	return 1;
    }
    
    if(n==2) {
    	return 2;
    }
    
    int result=climbStairs(n-2)+climbStairs(n-1);
    return result;
}


public static void compareClimb(int n) {
	int a = 1, b = 1;
    while (n-- > 0)
        a = (b += a) - a;
    
    System.out.println(a);
    
}
   
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    
	int firstArray=nums1.length-1;
	int secondArray=nums2.length-1;
	m=m-1;
	n=n-1;
	
	while(m>=0 && n>=0) {
		if(nums1[m] > nums2[n]) {
			nums1[firstArray]=nums1[m];
			
			m--;
			firstArray--;
			continue;
		}
		
		if(nums2[n]>nums1[m]) {
			nums1[firstArray]=nums2[n];
			
			n--;
			firstArray--;
			continue;
		}
		
		if(nums1[m]==nums2[n]) {
			nums1[firstArray]=nums1[m];
			firstArray--;
			nums1[firstArray]=nums2[n];
			m--;
			n--;
			firstArray--;
			continue;
		}
	}
	
	if(n>=0) {
		while(n>=0) {
			nums1[firstArray]=nums2[n];
			
			firstArray--;
			n--;
		}
	}
	
	printArray(nums1);
}

public static void printArray(int[]num) {
	System.out.println(" ");
	for(int i=0;i<num.length;i++) {
		System.out.print(num[i]+"  ");
	}
	System.out.println(" ");
}


public static List<List<Integer>> generate(int numRows) {
    
	
	List<List<Integer>> finalResult=new ArrayList<List<Integer>>();
	
	if(numRows==0) {
		return finalResult;
	}
	if(numRows==1) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		result.add(1);
		finalResult.add(result);
		return finalResult;
	}
	
	if(numRows<=2) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		result.add(1);
		finalResult.add(result);
		ArrayList<Integer> result2=new ArrayList<Integer>();
		result2.add(1);
		result2.add(1);
		finalResult.add(result2);
		return finalResult;
	}
	
	if(numRows>2) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		result.add(1);
		finalResult.add(result);
		ArrayList<Integer> result2=new ArrayList<Integer>();
		result2.add(1);
		result2.add(1);
		finalResult.add(result2);
		
		for(int i=1;i<numRows-1;i++) {
			List<Integer> result_mid=finalResult.get(i);
			List<Integer>midResults=new ArrayList<Integer>();
			midResults.add(1);
			for(int j=0;j<=result_mid.size()-2;j++) {
				midResults.add(result_mid.get(j)+result_mid.get(j+1));
			}
			midResults.add(1);
			finalResult.add(midResults);
			
		}
		
		
	}
	
	return finalResult;
}


public static int maxProfit(int[] prices) {
    int result=0;
    
    if(prices.length==0) {
    	return result;
    }
    
    
    int min=prices[0];
    int profit=Integer.MIN_VALUE;
    for (int i=1;i<prices.length;i++) {
    	
    	if(prices[i]<min) {
    		min=prices[i];
    	}
    	
    	if(prices[i]-min>profit) {
    		profit=prices[i]-min;
    		result=result+profit;
    		profit=0;
    		min=prices[i];
    		
    	}
    	
    	
    }
    
    return result;
}

public static boolean isPalindrome(String s) {
	
	if(s.isEmpty()) {
		return true;
	}
    int i=0;
    int j=s.length()-1;
    
    while(i<j) {
    	if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
    		i++;
    		continue;
    	}
    	
    	if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
    		j--;
    		continue;
    	}
    	
    	
    	if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
    		return false;
    	}
    	i++;
    	j--;
    }
    
    return true;
}

static HashMap<Integer,String> alphaMap=new HashMap<Integer,String>();

public static void initialize() {
	alphaMap.put(1, "A");
	alphaMap.put(2, "B");
	alphaMap.put(3, "C");
	alphaMap.put(4, "D");
	alphaMap.put(5, "E");
	alphaMap.put(6, "F");
	alphaMap.put(7, "G");
	alphaMap.put(8, "H");
	alphaMap.put(9, "I");
	alphaMap.put(10, "J");
	alphaMap.put(11, "K");
	alphaMap.put(12, "L");
	alphaMap.put(13, "M");
	alphaMap.put(14, "N");
	alphaMap.put(15, "O");
	alphaMap.put(16, "P");
	alphaMap.put(17, "Q");
	alphaMap.put(18, "R");
	alphaMap.put(19, "S");
	alphaMap.put(20, "T");
	alphaMap.put(21, "U");
	alphaMap.put(22, "V");
	alphaMap.put(23, "W");
	alphaMap.put(24, "X");
	alphaMap.put(25, "Y");
	alphaMap.put(26, "Z");
}

public static String convertToTitle(int n) {
    return getColumn("",n);
}

public static String getColumn(String s,int number) {
	
	if(number<0) {
		return s;
	}
	
	if(number>0 && number<=26) {
		s=s+alphaMap.get(number+1);
		return s;
	}
	int first=((number)%26)-1;
	s=alphaMap.get(first)+s;
	//int second=Math.abs(number-(26*(first+1)));
	
	return getColumn(s,number/26);
	
}

public static void majorityElement(int[] nums) {
    int major=nums[0];
    int max=1;
    int current=nums[0];
    int currentcount=1;
    
    for(int i=1;i<nums.length;i++){
        if(nums[i]==current) {
            currentcount++;
            if(currentcount>=max) {
            	major=current;
                max=currentcount;
            }
            
        }else {
        	current=nums[i];
            currentcount=1;
        }
        
        
    }
    
    System.out.println(major);
}


public static double  calculateFactorial(int n) {
	if(n<=1) {
		return 1;
	}
	
	return n*calculateFactorial(n-1);
}


public static void rotate(int[] nums, int k) {
    int i=0;
    
    int temp=nums[0];
    while(i<k) {
    	for(int j=0;j<nums.length;j++) {
    		int n=nums[(j+1)%nums.length];
        	nums[(j+1)%nums.length]=temp;
        	//j=(j+1)%nums.length;
        	temp=n;
    	}
    	temp=nums[0];
    	i++;
    }
    
	for(int j=0;j<nums.length;j++) {
		System.out.print(nums[j]+" ");
	}
}

public static void isHappy(int n) {
    HashSet<Integer> set=new HashSet<Integer>();
   
   // set.add(n);
    while(!set.contains(n) ) {
    	set.add(n);
    	n=calculate(n);
    	System.out.println(" n is "+n);
    	if(n==1) {
    		System.out.println(true);
    		break;
    	}
    	
    }
    
    System.out.println(false);
    
}

public static int calculate(int n) {
	int sum=0;
	while(n>0) {
		sum=sum+(n%10)*(n%10);
		n=n/10;
		
	}
	return sum;
}

public static int  rob(int[] nums) {
	
	if(nums.length==0) {
		return 0;
	}
	
	if(nums.length==1) {
		return nums[0];
	}
	int adj1=0;
	int adj2=0;
	for(int i=0;i<nums.length;i=i+2) {
		adj1=adj1+nums[i];
	}
	
	for(int i=1;i<nums.length;i=i+2) {
		adj2=adj2+nums[i];
	}
	
	return adj1>adj2?adj1:adj2;
}

public static void reverseBits(int n) {
    int temp=0;
    long nu=n;
  
    int i=1;
    while(i<=32) {
    	 int mask=0;
    	 mask=n&1;
    	// System.out.println(Integer.toBinaryString(mask));
    	 temp=temp|mask;
    	// System.out.println(Integer.toBinaryString(temp));
    	 temp=temp<<1;
    	 n=n>>>1;
    	System.out.println(Long.toBinaryString(temp));
    	 //System.out.println(Integer.toBinaryString(n));
    	 i++;
    	 if(i>30) {
    		 System.out.println("yes i");
    	 }
    }
    temp=temp>>1;
    System.out.println(temp);
}

public static int hammingWeight(int n) {
    int count=0;
    
    while(n!=0) {
    	long mask=1;
    	mask=n&mask;
    	if(mask>0) {
    		count++;
    	}
    	n=n>>1;
    }
    return count;
}


//Given "egg", "add", return true
//Given "foo", "bar", return false.
//aba and baa fase


public static String getString(String s) {
	HashMap<Character,Integer>check1=new HashMap<Character,Integer>();
	String s1="";
	int i1=0;
	
	for(int i=0;i<s.length();i++) {
		if(check1.containsKey(s.charAt(i))) {
			s1=s1+check1.get(s.charAt(i));
		}else {
			s1=s1+i1;
			check1.put(s.charAt(i), i1);
			i1++;
		}
	}
	
	System.out.println("String for "+s+" is "+s1);
	return s1;
}
public static boolean isIsomorphic(String s, String t) {
	
	if(s.isEmpty() && t.isEmpty()) {
		return true;
	}
	HashMap<Character,Character> map=new HashMap<Character,Character>();
	char[]map2=new char[256];
	
	for(int i=0;i<s.length();i++) {
		
		if(map.containsKey(s.charAt(i))) {
			if(t.charAt(i)!=map.get(s.charAt(i))) {
				return false;
			}
			if(map2[t.charAt(i)]!=s.charAt(i)) {
				return false;
			}
		}else {
			if(map2[t.charAt(i)]!=0) {
				return false;
			}
			map2[t.charAt(i)]=s.charAt(i);
			map.put(s.charAt(i), t.charAt(i));
			
		}
	}
	
	return true;
	
}

//Given an array of integers and an integer k, find out whether there are
//two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
public static boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer,Integer > c=new HashMap<Integer,Integer>();
	for(int i=0;i<nums.length;i++) {
		if (c.containsKey(nums[i])) {
			if(Math.abs(c.get(nums[i])-i)<=k) {
				return true;
		}
		}
			
		c.put(nums[i], i);
		
	}
	
	
	return false;
}


public static int shortestDistance(String[]words,String word1,String word2) {
	int min=Integer.MAX_VALUE;
	
	int pos1=Integer.MAX_VALUE;
	int pos2=Integer.MAX_VALUE;
	
	for(int i=0;i<words.length;i++) {
		
		if(words[i].equals(word1)) {
			pos1=i;
		}
		
		if(words[i].equals(word2)) {
			pos2=i;
		}
		
		if(Math.abs(pos1-pos2)<min && pos1!=Integer.MAX_VALUE && pos2!=Integer.MAX_VALUE) {
			min=Math.abs(pos1-pos2);
		}
	}
	
	
	
	
	
	return min;
}


public static boolean isStrobogrammatic(String num) {
	boolean isYes=true;
	
	
	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	
	
	map.put(0, 0);
	map.put(6, 9);
	map.put(8, 8);
	map.put(9, 6);
	map.put(1, 1);
	
	
	
	int head=0,tail=num.length()-1;
	
	while(head<tail) {
		int numhead=Character.getNumericValue(num.charAt(head));
		
		int numtail=Character.getNumericValue(num.charAt(tail));
		
		if(map.containsKey(numhead) && map.containsKey(numtail)) {
			
			if(map.get(numhead)!=numtail) {
				isYes=false;
				break;
			}
			
		}else {
			isYes=false;
			break;
		}
		head++;
		tail--;
		
	}
	
	return isYes;
}


public  int minCost(int[][] costs) {
	int min=Integer.MAX_VALUE;
	int previous=0;
	
	for(int i=0;i<3;i++) {
		if(costs[0][i]<min) {
			min=costs[0][i];
			previous=i;
		}
	}
	for(int i=1;i<costs.length;i++) {
	
		int min_internal=Integer.MAX_VALUE;
		for(int j=0;j<3;j++) {
			if(j==previous) {
				continue;
			}
			
			if(min_internal>costs[i][j]) {
				min_internal=costs[i][j];
				previous=j;
			}
			
			
		}
		min=min+min_internal;
	}
	
	return min;
}

public static int addDigits(int num) {
    
    int result=0;
    
    while(num>0){
        result=result+num%10;
        num=num/10;
    }
    
    if(result<10){
        return result;
    }
    
    return addDigits(result);
}


public static boolean isUgly(int num) {
    if(num%2==0) {
    	return isUgly(num/2);
    }
    
    if(num%3==0) {
    	return isUgly(num/3);
     }
    
    if(num%5==0) {
    	return isUgly(num/5);
    }
    
    if(num==1) {
    	return true;
    }
    
    return false;
}

public static String revString(String s) {
	String result="";
    
    for(int i=s.length()-1;i>=0;i--){
        result=result+s.charAt(i);
    }
    
    return result;
}


public int helper(int first,int last) {
	if(isBadVersion(last) && !isBadVersion(last-1)) {
		return last;
	}
	
	int mid=first+(last-first)/2;
	
	
	
	if(!isBadVersion(mid)) {
		return helper(mid,last);
	}
	
	return helper(first,mid);
}


boolean isBadVersion(int version) {
	
	return true;
}

public static String reverseVowels(String s) {
    char[]words=s.toCharArray();
    
    int i=0,j=s.length()-1;
    
    HashSet<Character>vowels=new HashSet<Character>();
    vowels.add('a');
    vowels.add('A');
    vowels.add('e');
    vowels.add('E');
    vowels.add('i');
    vowels.add('I');
    vowels.add('o');
    vowels.add('O');
    vowels.add('u');
    vowels.add('U');
    
    while(i<j) {
    	if(!vowels.contains(s.charAt(i))) {
    		i++;
    		continue;
    	}
    	if(!vowels.contains(s.charAt(j))) {
    		j--;
    		continue;
    	}
    	
    	char temp=s.charAt(i);
    	words[i]=s.charAt(j);
    	words[j]=temp;
    	j--;
    	i++;
    	
    }
    
    return new String(words);
}


public static int[] intersection(int[] nums1, int[] nums2) {
	
	   
    if(nums1.length==0 || nums2.length==0){
        return new int[0];
    } 
    
    HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
    for(int i:nums1) {
    	res.put(i,0);
    }
    
   for(int i:nums2) {
	   if(res.containsKey(i)) {
		   res.put(i, 1);
	   }
   }
   
   
   ArrayList<Integer>updateResult=new ArrayList<Integer>();
   
   Iterator r=res.entrySet().iterator();
   
   while(r.hasNext()) {
	   Entry<Integer,Integer> entry=(Entry<Integer, Integer>) r.next();
	   
	   if(entry.getValue()==1) {
		   updateResult.add(entry.getKey());
	   }
   }
   
    return getMyResult(updateResult);
}


public static int[] intersect(int[] nums1, int[] nums2) {
	if(nums1.length==0 || nums2.length==0){
        return new int[0];
    } 
    
    HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
    for(int i:nums1) {
    	if(res.containsKey(i)) {
    		res.put(i, res.get(i)+1);
    	}else {
    		res.put(i,1);
    	}
    	
    }
    
    
   ArrayList<Integer>updateResult=new ArrayList<Integer>();
    
   for(int i:nums2) {
	   
	   if(res.containsKey(i)) {
		   if(res.get(i)>0) {
			   updateResult.add(i);
			   res.put(i, res.get(i)-1);
		   }
	   }
	   
	   
   }
   return getMyResult(updateResult);
}



public static int[]getMyResult(ArrayList<Integer> r){
	int []sent=new int[r.size()];
	for(int i=0;i<r.size();i++) {
		sent[i]=r.get(i);
	}
	
	return sent;
}


public static boolean canConstruct(String ransomNote, String magazine) {
	long a=System.currentTimeMillis();
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    
    for(int i=0;i<magazine.length();i++) {
    	if(map.containsKey(magazine.charAt(i))){
    		map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
    	}else {
    		map.put(magazine.charAt(i),1);
    	}
    }
    
    for(int i=0;i<ransomNote.length();i++) {
    	if(!map.containsKey(ransomNote.charAt(i))) {
    		long c=System.currentTimeMillis();
    		System.out.println("a is "+a);
    		System.out.println("b is "+c);
    		return false;
    	}else {
    		if(map.get(ransomNote.charAt(i))==0) {
    			long c=System.currentTimeMillis();
    			System.out.println("a is "+a);
    			System.out.println("b is "+c);
    			return false;
    		}
    		
    		map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
    	}
    }
	
    long c=System.currentTimeMillis();
    System.out.println("a is "+a);
	System.out.println("b is "+c);
	return true;
}

public static int firstUniqChar(String s) {
    int pos=0;
    
   int []p=new int[26];
   
   for(int i=0;i<s.length();i++) {
	   
	   p[s.charAt(i)-'a']=p[s.charAt(i)-'a']+1;
   }
   
   for(int i=0;i<s.length();i++) {
	   if(p[s.charAt(i)-'a']==1) {
		   return i;
	   }
   }
    
    
    
    return pos;
}


public static int guessNumber(int n) {
    int mid=n/2;
    
    return mid;
    
	
}


public static int helperForMid(int head,int tail) {
	
	int result=0;
	while(tail>head) {
		int mid=head+(tail-head)/2;
		if(guess(mid)==0) {
			result= mid;
			break;
		}
		
		if(guess(mid)==1) {
			head=mid+1;
		}
		
		if(guess(mid)==-1) {
			tail=mid-1;
		}
	}
	
	return result;
}


public static int guess(int num) {
	
	if(num==6) {
		return 0;
	}
	
	if(num<6) {
		return 1;
	}
	return -1;
}
public static void findTheDifference(String s, String t) {
    int a=0;
    
    for(int i=0;i<s.length();i++) {
    	
    	a=a ^ s.charAt(i);
    	
    }
    
    for(int i=0;i<t.length();i++) {
       
        a=a^t.charAt(i);
    }
    
    char result=(char) a;
    System.out.println(result);
    
}

public static boolean isPerfectSquare(int num) {
    long head=1;
    long tail=num;
    
    while(head<=tail) {
    	long mid=head+(tail-head)/2;
    	System.out.println(mid);
    	if(mid*mid==num) {
    		return true;
    	}
    	
    	if(mid*mid>num) {
    		tail=mid-1;
    	}
    	
    	if(mid*mid<num) {
    		head=mid+1;
    	}
    	
    }
	
	
	return false;
}

public static String hexa(int num) {
	String s="";
	HashMap<Integer,String> map=new HashMap<Integer,String>();
	map.put(10, "a");
	map.put(11, "b");
	map.put(12, "c");
	map.put(13, "d");
	map.put(14, "e");
	map.put(15, "f");
	
	if(num<0) {
		return convertToComplement(num);
	}
	
	while(num>0) {
		
		int re=num%16;
		if(re>9) {
			s=s+map.get(re);
		}else {
			s=s+String.valueOf(re);
		}
		num=num/16;
	}
	
	String hexa="";
	for(int i=s.length()-1;i>=0;i--) {
		hexa=hexa+s.charAt(i);
	}
	
	return hexa;
}

public static String  convertToComplement(int n) {
	HashMap<Integer,String> map=new HashMap<Integer,String>();
	map.put(10, "a");
	map.put(11, "b");
	map.put(12, "c");
	map.put(13, "d");
	map.put(14, "e");
	map.put(15, "f");
	
	String s="";
	while(n!=0) {
		
		int re=n&15;
		if(re>9) {
			s=s+map.get(re);
		}else {
			s=s+String.valueOf(re);
		}
		
		n=n>>>4;
		
	}
	return s;
	
	
}


public static int thirdMax(int[] nums) {
    int max1=nums[0];
    int max2=Integer.MIN_VALUE;
    int max3=Integer.MIN_VALUE;
    
    for(int i=1;i<nums.length;i++) {
    	if(nums[i]==max1||nums[i]==max2||nums[i]==max3) {
    		continue;
    	}
    	if(nums[i]>=max1) {
    		int temp=max1;
    		max1=nums[i];
    		int temp2=max2;
    		max2=temp;
    		max3=temp2;
    	}else {
    		if(nums[i]>=max2) {
    			int temp2=max2;
    			max2=nums[i];
    			max3=temp2;
    		}else {
    			if(nums[i]>=max3) {
    				max3=nums[i];
    			}
    		}
    	}
    }
    
    System.out.println(max3);
    System.out.println(max2);
    System.out.println(max1);
    
    return Integer.min(max3, Integer.min(max1, max2));
}


public static String addStrings(String num1, String num2) {
	
	if(num1.isEmpty() || num2.isEmpty()) {
		if(num1.isEmpty()) {
			return num2;
		}
		
		if(num2.isEmpty()) {
			return num1;
		}
		
		
	}
    String result="";
    
    int carry=0;
    
   int maxLength=num1.length()>num2.length()?num1.length()-1:num2.length()-1;
   int n1=num1.length()-1;
   int n2=num2.length()-1;
   while(maxLength>=0) {
	   
	   int a=n1>=0?Character.getNumericValue(num1.charAt(n1)):0;
	   int b=n2>=0?Character.getNumericValue(num2.charAt(n2)):0;
	   
	   int r=a+b+carry;
	   
	   if(r>9) {
		   carry=1;
		   
		   int m=r%10;
		   result=result+String.valueOf(m);
	   }else {
		   carry=0;
		   result=result+String.valueOf(r);
	   }
	   
	   
	   n1--;
	   n2--;
	   maxLength--;
	   
	   
   }
    
   
   String toReturnResult="";
   if(carry==1) {
	   toReturnResult=toReturnResult+String.valueOf(carry);
   }
   for(int i=result.length()-1;i>=0;i--) {
	   toReturnResult=toReturnResult+result.charAt(i);
   }
    
    return toReturnResult;
}

//He is   an aaa     man
public static int countSegments(String s) {
    int count=0;
    s=s.trim();
    String []word=s.split(" ");
    
    
    boolean isPrevious=false;
    for(String a:word) {
    	
    	if(!a.isEmpty()) {
    		count++;
    	}
    	
    }
    
    
    return count;
}


//s: "cbaebabacd"(10) p: "abc"(3)   [0, 6]
//s: "abab" p: "ab"   [0, 1, 2]
public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> ana=new ArrayList<Integer>();
    
    
    int[]map=createMap(p);
    
    
    int a=s.length();
    int b=p.length();
    int diff=a-b;
    
   
   
    
    for(int i=0;i<=diff;i++) {
    	
    	String c=s.substring(i, i+b);
    	
    	if(checkifPresent(createMap(c),map,c)) {
    		ana.add(i);
    	}
    }
   
    
    return ana;
}


public  static int[] createMap(String p) {
	int[]map=new int[256];
    for(Character c:p.toCharArray()) {
    	
    	map[c]=map[c]+1;
    	
    }
    
    return map;
}


public  static boolean checkifPresent(int[] s,int []h,String a) {
	
	for(Character c:a.toCharArray()) {
		if(s[c]!=h[c]) {
			return false;
		}
	}
	
	
	return true;
}


public static void isCorrectSequence(List<String> words) {
	boolean isValid=true;
	
	
	int length=0;
	int l=0;
	for(int col=0;col<words.size();col++) {
		
		String a=words.get(col);
		String t="";
		
		for(int row=0;row<words.size();row++) {
			
			if(l<words.get(row).length()) {
				t=t+words.get(row).charAt(l);
			}
			
			
		}
		
		if(!a.equals(t)) {
			isValid=false;
			break;
		}
		l++;
		
	}
	
	
	System.out.println(isValid);
	
}

public static void arrangeCoins(int n) {
    int left=0;
    int right=n;
    
    while(right>left) {
    	int mid=(right+left)/2;
    	
    	int total=(mid*(mid+1))/2;
    	
    	if(total>n) {
    		right=mid-1;
    	}else {
    		left=mid+1;
    	}
    }
    
    System.out.println(left-1);
    System.out.println(right-1);
}

public static void verify(int n) {
	
	int i=1;
	int count=1;
	while(count<n) {
		for(int j=0;j<i;j++) {
			
			n=n-j;
			count++;
		}
		
	
		i++;
		
	}
	
	System.out.println(i-1);
}

public static boolean repeatedSubstringPattern(String s) {
    int index=1;
    String pattern="";
    while(2*index<=s.length()) {
    	String first=s.substring(0, index);
    	
    	String second=s.substring(index, 2*index);
    	
    	if(first.equals(second)) {
    		pattern=first;
    		if(check(index,pattern,s)) {
    			return true;
    		}else {
    			index=index+1;
    		}
    	}else {
    		index=index+1;
    	}
    	
    }
    
    return false;
    
    		
    
}

public static int hammingDistance(int x, int y) {
    int i=0;
    
    
    int a=x^y;
    
    while(a>0) {
    	int b=a&1;
    	if(b==1) {
    		i++;
    	}
    	a=a>>>1;
    }
    
    return i;
}


public static boolean check(int index,String pattern,String s) {
	int v=index;
    for(v=index;v<=s.length()-pattern.length();v=v+pattern.length()) {
    	
    	String check1=s.substring(v,v+pattern.length());
    	if(!check1.equals(pattern)) {
    		return false;
    	}
    	

    	
    }
    
    return v==s.length()?true:false;
}

public int findRadius(int[] houses, int[] heaters) {
    int rad=0;
    
    
    
    return rad;
}

public static int findMaxConsecutiveOnes(int[] nums) {
    int max=Integer.MIN_VALUE;
    int count=0;
    for(int i=0;i<nums.length;i++) {
    	
    	if(nums[i]==1) {
    		count++;
    	}
    	if(nums[i]==0) {
    		count=0;
    	}
    	
    	max=Math.max(max, count);
    	
    }
    
    
    return max;
}


public static void  constructRectangle(int area) {
    int []res=new int[2];
	int width=(int)Math.sqrt(area);
	
	int length=width;
	
	if(length*width==area) {
		 res[0]=length;
		 res[1]=width;
	}
	
	while(width>0 && length<=area) {
		int a=width*length;
		
		if(a==area) {
			res[0]=length;
			 res[1]=width;
			 break;
		}
		
		if(a>area) {
			width--;
		}
		
		if(a<area) {
			length++;
		}
	}
	
	System.out.println(res[0]+" "+res[1]);
	
	
	
}

//FlaG
//USA
//leetcode
public static boolean detectCapitalUseAgain(String word) {
    boolean firstUse=false;
   
    boolean smallUse=false;
    boolean perfectUse=false;
    for(int i=0;i<word.length();i++) {
    	char a=word.charAt(i);
    	
    	if(a>=65 && a<=90 && i==0) {
    	     firstUse=true;
    	     continue;
    	}
    	
    	if(a>=65 && a<=90 && i>0 && firstUse) {
    		continue;
     	}
    	
    	if(a>90 && firstUse && i==1) {
    		perfectUse=true;
    		firstUse=false;
    		continue;
    	}
    	
    	if(a>90 && !firstUse) {
    		smallUse=true;
    		continue;
    	}
    	
    	if(a>90 && (smallUse ||  perfectUse)) {
    		continue;
    	}
    	
    	return false;
    	
    }
    
    
    return true;
}


public static int findPairs(int[] nums, int k) {
	Arrays.sort(nums);
    int count=0;
    
    int i=0;
    int j=i+1;
    HashSet<String> map=new HashSet<String>();
    while(j<nums.length) {
    	
    	
    	
    	
    	
    	int val=Math.abs(nums[i]-nums[j]);
    	if(val==k ) {
    		String forward=String.valueOf(nums[i])+String.valueOf(nums[j]);
    		String backward=String.valueOf(nums[j])+String.valueOf(nums[j]);
    		
    		if(!map.contains(forward) && !map.contains(backward)) {
    			count++;
    		}
    		
    		map.add(forward);
    		map.add(backward);
    		j++;
    		
    	}
    	
    	if(val>k) {
    		
    		i++;
    		j=i+1;
    		
    		
    	}
    	
    	if(val<k) {
    		j++;
    	}
    	
    }
    
    return count;
}


public int distributeCandies(int[] candies) {
    int max=0;
    
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    
    for(int n:candies) {
    	if(map.containsKey(n)) {
    		map.put(n, map.get(n)+1);
    	}else {
    		map.put(n, 1);
    	}
    }
    
    int boys=candies.length/2;
    int girls=candies.length-boys;
    
    for(Integer key:map.keySet()) {
    	int val=map.get(key);
    	
    	if(val%2==0) {
    		max++;
    	}
    }
    
    return max;
}

public static int findUnsortedSubarray(int[] nums) {
    int length=0;
    
    int point1=0;
    int point2=0;
    for(int i=1;i<nums.length;i++) {
    	if(nums[i-1]>nums[i] && point2==0) {
    		point2=i;
    	}
    	
    	if(point2!=0 && nums[i-1]>=nums[i]) {
    		point1=i;
    	}
    	
    	
    }
    
    System.out.println("point 1 is "+point1+" at "+nums[point1]);
    System.out.println("point 2 is "+point2+" at "+nums[point2]);
    length=(point1==point2 && point2==0)?0:point1-point2+2;
    
    
    
    return length;
}

public boolean canPlaceFlowers(int[] flowerbed, int n) {
    
	if(n>flowerbed.length) {
		return false;
	}
	
	int count=0;
	for(int i=1;i<flowerbed.length-1;i++) {
		if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0) {
			count++;
		}
	}
	
	return count==n;
}


public static int maximumProduct(int[] nums) {
    int result=0;
    
    int max1=nums[0];
    int max2=Integer.MIN_VALUE;
    int max3=Integer.MIN_VALUE;
    
    
    for(int i=1;i<nums.length;i++) {
    	if(nums[i]>max1) {
    		int temp=max1;
    		max1=nums[i];
    		int temp2=max2;
    		max2=temp;
    		max3=temp2;
    		
    	}else {
    		if(nums[i]>max2) {
    			int temp=max2;
        		max2=nums[i];
        		max3=temp;
    		}else {
    			if(nums[i] >max3) {
    				max3=nums[i];
    			}
    		}
    		
    		
    	}
    	
    	
    }
    
    System.out.println(" max1 ="+max1+" ,max2 ="+max2+" ,max3 ="+max3);
    result=max1*max2*max3;
    return result;
}


public static boolean judgeSquareSum(int c) {
    
	int right=(int)Math.sqrt(c);
	int left=1;
	
	while(right>left) {
		int num=(right*right)+(left*left);
		if(num==c) {
			return true;
		}
		
		if(num>c) {
			right=right-1;
		}
		
		if(num<c) {
			left=left+1;
		}
	}
	
	return false;
}

public static double findMaxAverage(int[] nums, int k) {
    double result=Integer.MIN_VALUE;
    
    int i=0;
    
    while(i<nums.length-k) {
    	
    	int j=0;
    	double avg=0;
    	while(j<k) {
    		
    		avg=avg+nums[i+j];
    		j++;
    	}
    	
    	result=Math.max(result, avg/4);
    	i++;
    }
    return result;
}

public static int[] findErrorNums(int[] nums) {
    int []result=new int[2];
    HashSet<Integer>visited=new HashSet<Integer>();
    
    int sum=0;
    
    for(int n:nums) {
    	if(visited.contains(n)) {
    		result[0]=n;
    	}else {
    		visited.add(n);
    		sum=sum+n;
    		
    		
    	}
    }
    
    int max=nums.length;
    
    int a=(max*(max+1))/2;
    
    result[1]=Math.abs(sum-a);
    
    return result;
    
}


public static boolean judgeCircle(String moves) {
    
	int suml=0;
	int sumd=0;
	for(int i=0;i<moves.length();i++) {
		char a=moves.charAt(i);
		
		switch(a) {
		case 'U':
			sumd=sumd+1;
			break;
		case 'D':
			sumd=sumd-1;
			break;
		case 'L':
			suml=suml+1;
			break;
		case 'R':
			suml=suml-1;
			break;
		}
		
	}
	
	if(suml==0 && sumd==0) {
		return true;
	}
		
	return false;
}

public static boolean checkPossibility(int[] nums) {
    
	boolean isOne=false;
	int min=Integer.MAX_VALUE;
	for(int i=0;i<nums.length-1;i++) {
		
		
		if(nums[i]>nums[i+1] && !isOne) {
			isOne=true;
			continue;
		}
		
		if(nums[i]>nums[i+1]) {
			return false;
		}
		
		if(nums[i]<min && isOne) {
			return false;
		}
		min=Math.min(min, nums[i]);
	}
	
	
	return true;
}

public static int findLengthOfLCIS(int[] nums) {
    int length=1;
    int maxLength=Integer.MIN_VALUE;
    for(int i=1;i<nums.length;i++) {
    	if(nums[i] >nums[i-1]) {
    		length=length+1;
    		
    		maxLength=Math.max(maxLength, length);
    	}else {
    		length=1;
    	}
    }
    
    return maxLength;
}

public static boolean validPalindrome(String s) {
    
	int i=0,j=s.length()-1;
	boolean isSet=false;
	
	for(int a=0;a<s.length();a++) {
		System.out.println("Postiion "+a+" :"+s.charAt(a));
	}
	while(i<=j) {
		System.out.println("Postiion "+i+" :"+s.charAt(i)+" Position at "+ j +" "+s.charAt(j));
		if(s.charAt(i)==s.charAt(j)) {
			i++;
			j--;
		}else {
			if(s.charAt(i)==s.charAt(j-1) && !isSet) {
				j--;
				isSet=true;
			}else if(s.charAt(j)==s.charAt(i+1) && !isSet) {
				i++;
				isSet=true;
			} else {
				return false;
			}
			
			
		}
	}
	
	return true;
}


public static void maxAreaOfIsland(int[][] grid) {
	
	int max=Integer.MIN_VALUE;
   for(int i=1;i<grid.length;i++) {
	   for(int j=0;j<grid[i].length;j++) {
		   if(grid[i][j]==1) {
			   System.out.println("i is "+i+" j is "+j);
			   int cal=calculate(i,j,grid);
			   System.out.println("cal is "+cal);
			   max=Math.max(max,cal );
		   }
	   }
   }
   
   System.out.println(max);
}


public static int calculate(int i,int j,int[][]grid) {
	
	if(i>grid.length && j>grid[i].length) {
		return 0;
	}
	
	if(i>grid.length) {
		return 0;
	}
	
	if(j>grid[i].length) {
		return 0;
	}
	
	if(grid[i-1][j]==1) {
		return 1;
	}
	if(grid[i][j+1]==1) {
		return 1;
	}
	
	if(grid[i][j]==0) {
		return 0;
	}
	
	
	return calculate(i+1,j,grid)+calculate(i-1,j,grid)+1;


}


public static int pivotIndex(int[] nums) {
	
	
	if(nums.length<=2) {
		return 0;
	}
    int sum=0;
   for(int a=0;a<nums.length;a++) {
	   if(nums[a]<0) {
		   nums[a]=nums[a]*-1;
	   }
	   
	   sum=sum+nums[a];
   }
    
    int i=0,j=nums.length-1;
    
    int sumLeft=0;
    int sumRight=0;
    int curI=0;
    int curJ=nums.length-1;
    sumLeft=sumLeft+nums[i];
	sumRight=sumRight+nums[j];
	
    while(j>i) {
    	
    	if(i!=curI) {
    		
    	sumLeft=sumLeft+nums[i];
    	
    	}
    	if(j!=curJ) {
    		
    	sumRight=sumRight+nums[j];
    	
    	}
    	
    	if(sumRight+sumLeft==sum) {
   
    		break;
    	}
    	
    	if(sumRight>sumLeft) {
    		
    		curI=i;
    		i++;
    		curJ=j;
    		
    	}else if (sumLeft>sumRight) {
    		
    		curJ=j;
    		j--;
    		curI=i;
    		
    	}
    	
    	if(sumLeft==sumRight) {
    		i++;
    		j--;
    	}
    	
    }
    
    if(sumRight+sumLeft+nums[i]==sum) {
    	return i;
    }
    
    return -1;
}


public static boolean hasAlternatingBits(int n) {
    boolean isZero=false;
    boolean isOne=false;
    
    int a=n&1;
    
    if(a==1) {
    	isOne=true;
    }else {
    	isZero=true;
    }
    n=n>>1;
    while(n>0) {
    	int b=n&1;
    	n=n>>1;
    	if(b==1 && !isOne) {
    		isOne=true;
    		isZero=false;
    		continue;
    	}
    	
    	if(b==0 && !isZero) {
    		isZero=true;
    		isOne=false;
    		continue;
    	}
    	
    	return false;
    }
    
    return true;
}



public int getImportance(List<Employee> employees, int id) {
	HashMap<Integer,Integer> empMap=new HashMap<Integer,Integer>();
	Employee res=null;
    
	for(Employee a:employees) {
		empMap.put(a.id, a.importance);
		if(a.id==id) {
			res=a;
		}
	}
	int sum=0;
	for(int a:res.subordinates) {
		sum=sum+empMap.get(a);
	}
	
	sum=sum+empMap.get(id);
	return sum;
}

public void helper() {
	List<Integer> a=new ArrayList<Integer>();
	a.add(2);
	a.add(3);
	
	Employee first=new Employee(1,5,a);
	Employee second=new Employee(2,3,new ArrayList<Integer>());
	Employee third=new Employee(3,3,new ArrayList<Integer>());
	List<Employee> e=new ArrayList<Employee>();
	e.add(first);
	e.add(second);
	e.add(third);
	Common c=new Common();
	System.out.println(c.getImportance(e, 1));
}


public static int findShortestSubArray(int[] nums) {
	
	int max=Integer.MIN_VALUE;
	
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    HashMap<Integer,List<Integer>>locations=new HashMap<Integer,List<Integer>>();
    for(int i=0;i<nums.length;i++) {
    	if(map.containsKey(nums[i])) {
    		if(map.get(nums[i])+1 > max) {
    			max=map.get(nums[i])+1;
    			
    		}
    		map.put(nums[i],map.get(nums[i])+1);
    		List<Integer> l=locations.get(nums[i]);
    		l.add(i);
    		locations.put(nums[i], l);
    	}else {
    		map.put(nums[i], 1);
    		if(map.get(nums[i]) > max) {
    			max=map.get(nums[i]);
    			
    		}
    		List<Integer> l=new ArrayList<Integer>();
    		l.add(i);
    		locations.put(nums[i],l);
    		
    	}
    }
    
    int minDistance=Integer.MAX_VALUE;
    
    for(Map.Entry<Integer, Integer> set:map.entrySet()) {
    	if(set.getValue()==max) {
    		int v=locations.get(set.getKey()).get(locations.get(set.getKey()).size()-1)-locations.get(set.getKey()).get(0);
    		minDistance=Math.min(minDistance, v);
    	}
    }
	
	
   System.out.println(minDistance+1);
	
	return 0;
}



public static boolean isOneBitCharacter(int[] bits) {
    boolean canBe=false;
    
    int i=0;
    
    while(i<bits.length) {
    	if(bits[i]==1) {
    		i=i+2;
    		canBe=false;
    	}else {
    		canBe=true;
    		i=i+1;
    	}
    }
    
    return canBe;
}


public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    
	floodFillHelper(image,sr,sc,newColor,image[sr][sc]);
	return image;
}


public static void floodFillHelper(int[][] image, int sr, int sc, int newColor,int oldColor) {
    
	if(sr>image.length-1 || sr<0) {
		return ;
	}
	
	if(sc>image[0].length-1 || sc<0) {
		return ;
	}
	if(image[sr][sc]!=oldColor) {
		return ;
	}
	image[sr][sc]=newColor;
	System.out.println(" sr "+sr+" sc "+sc);
	
	floodFillHelper(image,sr+1, sc, newColor,oldColor);
	floodFillHelper(image,sr, sc+1, newColor,oldColor);
	floodFillHelper(image,sr-1, sc, newColor,oldColor);
	floodFillHelper(image,sr, sc-1, newColor,oldColor);
	
	
}


public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    int w1=0;
    int w2=0;
    
    if(pairs.length==0) {
    	return true;
    }
    
    if(words1.length==words2.length && words1.length==0) {
    	return true;
    }
    if(words1.length!=words2.length) {
    	return false;
    }
	for(int i=0;i<pairs.length;i++) {
		
		String []word=pairs[i];
		if( (words1[w1].equals( word[0] ) && words2[w2].equals( word[1] ) )|| (words1[w1].equals( word[1] ) && words2[w2].equals( word[0] ) )) {
			w1++;
			w2++;
		}else {
			return false;
		}
	}
	
	return true;
}


public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
	
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
    
    
public Employee(int id,int imp,List<Integer> sub){
		this.id=id;
		this.importance=imp;
		this.subordinates=sub;
	}
}


public static void convert(String s, int numRows) {
    
	StringBuilder result=new StringBuilder();
	
	for(int i=0;i<=numRows;i++) {
		int up=numRows;
		StringBuilder result1=new StringBuilder();
		result1.append(s.charAt(i));
		int down=i;
		
		while(down<numRows) {
			down=down+1;
		}
		up=down;
		while(up<i) {
			up=up-1;
			down=down+1;
		}
		
		
	}
	System.out.println(result.toString());
}


public static int lengthOfLongestSubstring(String s) {
    int max=Integer.MIN_VALUE;
    int h=0;
    int t=1;
	if(s.length()== 0 || s.length()==1) {
		return s.length();
	}
	
	if(s.length()==2) {
		if(s.charAt(0)==s.charAt(1)) {
			return 1;
		}else {
			return 2;
		}
	}
	
	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	int head=0;
	//int tail=1;
	map.put(s.charAt(0), 0);
	
	for(int i=1;i<s.length();i++) {
		
		if(map.containsKey(s.charAt(i))) {
			head=Math.max(head, map.get(s.charAt(i))+1);
			//map.put(s.charAt(i), i);
		}
			
		map.put(s.charAt(i), i);
		
		
		if(i-head>max) {
			h=head;
			t=i;
		}
		max=Integer.max(i-head+1, max);
		
		
	}
	
	System.out.println("Head is "+h+" tail is "+(t));
	return max;
}

public static int convertIntToRoman(String s) {
	String roman=s;
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
map.put('I',1);
map.put('V',5);
map.put('X',10);
map.put('L',50);
map.put('C',100);
map.put('D',500);
map.put('M',1000);

int prev=-1;
int curr=0;
int number=0;

int i=0;

while(i<roman.length()-1) {
	int numberToAdd=0;
	
	if(map.get(roman.charAt(i))>=map.get(roman.charAt(i+1))) {
		numberToAdd=numberToAdd+map.get(roman.charAt(i));
		i++;
	}else {
		numberToAdd=numberToAdd+Math.abs(map.get(roman.charAt(i+1))-map.get(roman.charAt(i)));
		i=i+2;
	}
	
	number=number+numberToAdd;
	
}
    
    if(i==roman.length()){
        return number;
    }
    
    return number=map.get(roman.charAt(i));
}
	
	
	
	

public static String longestCommonPrefix(String[] strs) {
   
    String first=strs[0];
    StringBuilder prefix=new StringBuilder(first);
    for(int i=1;i<strs.length;i++) {
    	String second=strs[i];
    	int lengthToCounter=second.length()>first.length()?first.length():second.length();
    	int j=0;
    	String result="";
    	while(j<lengthToCounter) {
    		if(first.charAt(j)==second.charAt(j)) {
    			result=result+first.charAt(j);
    		}else {
    			break;
    		}
    		j++;
    	}
    	
    	prefix=prefix.length()>result.length()?new StringBuilder(result):prefix;
    	first=second.length()>first.length()?first:second;
    	
    }
    
    return prefix.toString();
}

 static ArrayList<int[]> watch=new ArrayList<int[]> ();
 
public void addToArrayResult(int []nums) {
	int []n=new int[nums.length];
	for(int i=0;i<nums.length;i++) {
		n[i]=nums[i];
	}
	watch.add(n);
 }

public  void helperForWatch(int count,int currentIndex,int[] nums,int maxCount) {
	if(count==maxCount) {
		Common c=new Common();
		c.addToArrayResult(nums);
		//watch.addAll(Arrays.asList(nums));
		//nums[currentIndex-1]=0;
		return;
	}
	if(currentIndex>nums.length-1) {
		return;
	}
	
	for(int i=currentIndex;i<nums.length;i++) {
		nums[i]=1;
		helperForWatch(count+1,i+1,nums,maxCount);
		nums[i]=0;
	}
	
	
	
}

public static void binaryWatch(int n) {
	Common c=new Common();
	int[]a= {0,0,0,0,0,0,0,0,0,0,0};
	c.helperForWatch(0,0,a,2);
	
	for(int[] states:c.watch) {
		for(int i:states) {
			System.out.print(i+" ");
		}
		System.out.println(" ");
	}
}

public static int  longestPalindrome(String s) {
    int sumEven=0;
    int sumOdd=0;
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    
    for(Character c:s.toCharArray()) {
    	if(map.containsKey(c)) {
    		map.put(c, map.get(c)+1);
    	}else {
    		map.put(c,1);
    	}
    }
    
    for(Map.Entry<Character,Integer> set:map.entrySet()) {
    	if(set.getValue()%2==0) {
    		sumEven=sumEven+set.getValue();
    	}else {
    		
    		sumOdd=Math.max(sumOdd, set.getValue());
    	}
    }
    
    System.out.println(sumEven+sumOdd);
    return sumEven+sumOdd;
    
}

public static void numberOfBoomerangs(int[][] points) {
    HashSet<Double> distance=new HashSet<Double> ();
    int count=0;
    for(int i=0;i<points.length-1;i++) {
    	
    	for(int j=i+1;j<points.length;j++) {
    		double distanceResult=getDistance(points[i][0],points[j][0],points[i][1],points[j][1]);
    		if(distance.contains(distanceResult)) {
    			count++;
    		}else {
    			distance.add(distanceResult);
    		}
    	}
    	
    }
    
    System.out.println(count);
}

public static double getDistance(int x1,int x2,int y1,int y2) {
	
	double distance=Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2);
	return Math.sqrt(distance);
}

public static void findDisappearedNumbersAgain(int[] nums) {
    List<Integer> result=new ArrayList<Integer>();
    for(int i=0;i<nums.length;i++) {
    	if(nums[i]<=nums.length) {
    		int point=Math.abs(nums[i]);
    		if(nums[point-1]>0) {
    			nums[point-1]=nums[point-1]*-1;
    		}
    		
    	}
    }
    
    for(int i=0;i<nums.length;i++) {
    	if(nums[i]>0) {
    		result.add(i+1);
    	}
    }
    
    for(int i:result) {
    	System.out.println(i);
    }
}

	public static void main(String[] args) {
		int[]n= {4,3,2,7,8,2,3,1};
		findDisappearedNumbersAgain(n);
		//Employee two=new Employee(2,3,new ArrayList<Integer>());
		
				
	}
	
	
	
}
