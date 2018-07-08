package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.medium.HelperUtils;
import com.linklist.ListNode;
import com.tree.TreeNode;

public class CommonsTwo {

	public static boolean repeatedSubstringPattern(String s) {

		int index = 1;

		while (index <= s.length() / 2) {
			String first = s.substring(0, index);
			if (check(first, first.length(), s, index)) {
				return true;
			}
			index = index + 1;
		}
		return false;
	}

	public static boolean check(String pattern, int patternLength, String s, int pointToCompare) {

		int i = pointToCompare;

		while (i <= s.length() - patternLength) {
			String com = s.substring(i, i + patternLength);
			if (!com.equals(pattern)) {
				return false;
			}
			i = i + patternLength;

		}

		return i >= s.length();
	}

	public static int islandPerimeter(int[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int temp = 0;
				if (grid[i][j] == 1) {
					if (i == 0 || j == 0 || i == grid.length - 1 || j == grid.length - 1) {
						temp = determineSide(i, j, grid);
					} else {
						temp = countWater(i, j, grid);
					}
				}

				count = count + temp;
			}
		}
		return count;
	}

	public static int countWater(int i, int j, int[][] grid) {
		int count = 0;

		if (grid[i - 1][j] == 0) {
			count = count + 1;
		}

		if (grid[i + 1][j] == 0) {
			count = count + 1;
		}

		if (grid[i][j - 1] == 0) {
			count = count + 1;
		}

		if (grid[i][j + 1] == 0) {
			count = count + 1;
		}
		return count;
	}

	public static int determineSide(int i, int j, int[][] grid) {
		int count = 0;
		if (i == 0 && j == 0) {
			count = 1;
			if (grid.length > 1) {
				if (grid[i + 1][j] == 0) {
					count = count + 2;
				}
			}

			if (grid[i].length > 1) {
				if (grid[i][j + 1] == 0) {
					count = count + 2;
				}
			}

			return count;
		}

		if (i == grid.length - 1 && j == 0) {
			count = 1;
			if (grid[i - 1][j] == 0) {
				count = count + 2;
			}

			if (grid[i][j + 1] == 0) {
				count = count + 2;
			}

			return count;
		}

		if (i == 0 && j == grid.length - 1) {
			count = 1;
			if (grid[i + 1][j] == 0) {
				count = count + 2;
			}

			if (grid[i][j - 1] == 0) {
				count = count + 2;
			}
			return count;

		}

		if (i == grid.length - 1 && j == grid.length - 1) {
			count = 1;
			if (grid[i - 1][j] == 0) {
				count = count + 2;
			}

			if (grid[i][j - 1] == 0) {
				count = count + 2;
			}

			return count;
		}

		if (i == 0 && j < grid.length - 1) {
			count = 1;
			if (grid[i][j - 1] == 0) {
				count = count + 1;
			}
			if (grid[i].length > 1) {
				if (grid[i][j + 1] == 0) {
					count = count + 1;
				}
			}

			if (grid.length > 1) {
				if (grid[i + 1][j] == 0) {
					count = count + 1;
				}
			}
			return count;
		}

		if (i == grid.length - 1) {
			count = 1;
			if (grid[i][j - 1] == 0) {
				count = count + 1;
			}

			if (grid[i][j + 1] == 0) {
				count = count + 1;
			}

			if (grid[i - 1][j] == 0) {
				count = count + 1;
			}
			return count;
		}

		if (j == grid.length - 1) {
			count = 1;
			if (grid[i][j - 1] == 0) {
				count = count + 1;
			}

			if (grid[i + 1][j] == 0) {
				count = count + 1;
			}

			if (grid[i - 1][j] == 0) {
				count = count + 1;
			}
			return count;
		}

		if (j == 0 && i < grid.length - 1) {
			count = 1;
			if (grid.length > 1) {
				if (grid[i + 1][j] == 0) {
					count = count + 1;
				}
			}

			if (grid[i - 1][j] == 0) {
				count = count + 1;
			}
			if (grid[i].length > 1) {
				if (grid[i][j + 1] == 0) {
					count = count + 1;
				}
			}

			return count;
		}

		return count;
	}

	static int minDiff = Integer.MAX_VALUE;
	static ArrayList<Integer> arr = new ArrayList<Integer>();

	public static int getMinimumDifference(TreeNode root) {
		getMinHelper(root);

		for (int i = 1; i < arr.size() - 1; i++) {
			int maxRight = Math.abs(arr.get(i) - arr.get(i - 1));
			int maxLeft = Math.abs(arr.get(i) - arr.get(i + 1));

			minDiff = Math.min(Math.min(maxRight, maxLeft), minDiff);

		}
		return minDiff;
	}

	public static void getMinHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		getMinHelper(root.left);
		if (root.left != null) {
			if (Math.abs(root.val - root.left.val) < minDiff) {
				minDiff = Math.abs(root.val - root.left.val);
			}
		}

		if (root.right != null) {
			if (Math.abs(root.val - root.right.val) < minDiff) {
				minDiff = Math.abs(root.val - root.right.val);
			}
		}

		arr.add(root.val);
		getMinHelper(root.right);
	}

	public static void findPairs(int[] nums, int k) {
		int count = 0;

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (!map.get(nums[i])) {
					count++;
					map.put(nums[i], true);
				}

			} else {
				map.put(nums[i] + k, false);
				map.put(Math.abs(nums[i] - k), false);
			}
		}

		System.out.println(count);
	}

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

		int count = 0;

		for (int i = 1; i < nums.length; i = i + 2) {

			int b = Math.min(nums[i], nums[i - 1]);
			count = count + b;
		}

		return count;
	}

	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		preOrder(root.left);
		System.out.println(root.val);
		preOrder(root.right);
	}

	public static int findUnsortedSubarray(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		int totalLength = 0;

		int firstLeft = -1;
		int firstRight = -1;
		while (left < nums.length - 2) {
			if (nums[left + 1] < nums[left] && firstLeft == -1) {
				firstLeft = left;
				break;
			}

			left++;
		}

		while (right > 0) {
			if (nums[right - 1] > nums[right] && firstRight == -1) {
				firstRight = right;
				break;
			}

			right--;
		}

		System.out.println(firstLeft + "---" + firstRight);

		if (firstLeft != -1 || firstRight != -1) {
			return firstRight - firstLeft + 1;
		}

		return totalLength;
	}

	public static int getPointTwo(int[] nums, int location) {
		int pointedLocation = location;
		while (location < nums.length - 1) {
			if (nums[location] > nums[location + 1]) {
				pointedLocation = location;
			}
			location++;
		}

		return pointedLocation + 1;
	}

	static int sumLeft = 0;
	static int sumRight = 0;
	static int sum = 0;

	public static void findTilt(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		findTilt(root.left);

		findTilt(root.right);
		if (root.left != null) {
			sumLeft = sumLeft + root.left.val;
		}

		if (root.right != null) {
			sumRight = sumRight + root.right.val;
		}

		sum = sum + Math.abs(sumLeft - sumRight);

	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n > flowerbed.length) {
			return false;
		}

		int count = 0;
		if (flowerbed[0] == 0) {
			if (flowerbed.length >= 2) {
				if (flowerbed[1] == 0) {
					count++;
					flowerbed[0] = 1;
				} else {
					return flowerbed[0] == 0 ? count >= n : false;
				}
			}

		}

		for (int i = 1; i < flowerbed.length - 1;) {
			if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
				count++;
				flowerbed[i] = 1;
				i = i + 2;

			} else {
				i = i + 1;
			}
		}

		if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
			count++;
		}

		return count >= n;
	}

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int max = Integer.MIN_VALUE;
		if (nums[0] * nums[1] * nums[2] > max) {
			max = nums[0] * nums[1] * nums[2];
		}

		if (nums[0] * nums[1] * nums[nums.length - 1] > max) {
			max = nums[0] * nums[1] * nums[nums.length - 1];
		}

		if (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3] > max) {
			max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
		}
		return max;
	}

	public static void mergeTrees(TreeNode t1, TreeNode t2, TreeNode temp) {

		if (t1 == null && t2 == null) {
			return;
		}

		if (t1 == null && t2 != null) {
			temp = new TreeNode(t2.val);
			return;
		}

		if (t1 != null && t2 == null) {
			temp = new TreeNode(t1.val);
			return;
		}

		if (t1 != null && t2 != null) {
			temp = new TreeNode(t1.val + t2.val);

		}

		mergeTrees(t1.left, t2.left, temp.left);
		mergeTrees(t1.right, t2.right, temp.right);
	}

	public static double findMaxAverage(int[] nums, int k) {

		int i = 0;
		int max = Integer.MIN_VALUE;
		while (i <= nums.length - k) {
			int j = i;
			int total = 0;
			while (j < k + i) {
				total = total + nums[j];
				j++;
			}
			max = Math.max(max, total);
			i++;
		}
		System.out.println(max);
		return (double) max / k;
	}

	public static boolean checkPossibility(int[] nums) {

		if (nums.length == 1 || nums.length == 0) {
			return true;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean notFound = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				if (nums[i] < min && notFound) {
					return false;
				}
				// max=Math.max(max, nums[i+1]);
				min = Math.min(min, nums[i]);
			} else {
				if (!notFound) {
					notFound = true;
					// max=Math.max(max, nums[i+1]);
					min = Math.min(nums[i + 1], nums[i]);
				} else {
					return false;
				}
			}
		}
		return true;

	}

	public static void printLetter(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print(i + "" + s.charAt(i) + " ");
		}
		System.out.println("");

		System.out.println("");
	}

	public static boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		int isdeleted = 0;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				System.out.println(i + "->" + s.charAt(i) + " " + j + "->" + s.charAt(j) + " ");
				if (isdeleted == 1) {
					return false;
				} else {
					if (s.charAt(i + 1) == s.charAt(j)) {
						i = i + 1;
						isdeleted = 1;
						continue;
					}

					if (s.charAt(i) == s.charAt(j - 1)) {
						j = j - 1;
						isdeleted = 1;
						continue;
					}
					return false;
				}
			}
		}

		return true;
	}

	public static int repeatedStringMatch(String A, String B) {

		if (B.length() < A.length()) {
			return -1;
		}

		if (A.equals(B)) {
			return -1;
		}

		if (A.length() == B.length()) {
			return -1;
		}

		int j = 0;
		int intialLength = A.length();
		while (j < B.length()) {
			A = A + A;

			if (A.contains(B)) {
				return A.length() / intialLength - 1;
			}
			j = j + 1;

		}

		return -1;
	}

	static int maxCount = 0;
	static int count = 0;

	public static void longestUnivaluePathHelper(TreeNode root, int prevVal, int count) {
		maxCount = Math.max(maxCount, count);
		if (root == null) {
			return;
		}

		longestUnivaluePathHelper(root.left, root.val, count);

	}

	public static int longestUnivaluePath(TreeNode root) {
		// longestUnivaluePathHelper(root,0);
		return maxCount;
	}

	int total = 0;

	public int getImportance(List<Employee> employees, int id) {

		for (Employee e : employees) {

			if (e.id == id) {
				total = total + e.importance;
				for (int i : e.subordinates) {
					getImportance(employees, i);
				}
			}
		}

		return total;
	}

	public static void longestWord(String[] words) {
		int length = 0;
		String result = "";
		HashSet<String> map = new HashSet<String>();
		for (String w : words) {
			map.add(w);
		}

		ArrayList<String> st = new ArrayList<String>();

		for (String s : words) {

			StringBuffer sr = new StringBuffer(s);
			String t = sr.deleteCharAt(s.length() - 1).toString();

			if (map.contains(sr.toString())) {
				if (length <= s.length()) {

					if (length == s.length()) {
						/*
						 * if(s.compareTo(result)<0) { result=s; }
						 */
						st.add(s);
					} else {
						st.clear();
						st.add(s);
						result = s;
					}

					length = s.length();
				}
			}
		}
		Collections.sort(st);
		for (String ex : st) {
			System.out.print(ex + " ");
		}
		// System.out.println(result);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int[][] visited = new int[image.length][image[0].length];
		floodFillHelper(image, sr, sc, newColor, image[sr][sc], visited);
		return image;
	}

	public void floodFillHelper(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] visited) {

		if (sr > image.length - 1 || sr < 0 || sc > image[0].length - 1 || sc < 0 || visited[sr][sc] == 1
				|| image[sr][sc] != oldColor) {
			return;
		}

		if (image[sr][sc] == oldColor)
			image[sr][sc] = newColor;
		visited[sr][sc] = 1;
		floodFillHelper(image, sr + 1, sc, newColor, oldColor, visited);
		floodFillHelper(image, sr, sc + 1, newColor, oldColor, visited);
		floodFillHelper(image, sr - 1, sc, newColor, oldColor, visited);
		floodFillHelper(image, sr, sc - 1, newColor, oldColor, visited);

	}

	public static void nextGreatestLetter(char[] letters, char target) {
		char smallest = ' ';
		int diff = Integer.MAX_VALUE;

		boolean isLargePresent = false;

		for (char c : letters) {
			if (c > target) {
				isLargePresent = true;
				break;
			}
		}

		for (char c : letters) {

			if (isLargePresent && c < target) {
				continue;
			}

			if (c == target) {
				continue;
			}
			int a = Math.abs(c - 97 + 1);
			int b = Math.abs(97 - target + 1);
			int d = a - b;

			if (isLargePresent) {
				if (d > 0) {
					if (d < diff) {
						diff = d;
						smallest = c;
					}
				}
			} else {
				if (d < 0) {
					if (Math.abs(d) < diff) {
						diff = d;
						smallest = c;
					}
				}
			}

			/*
			 * int a=Math.abs(c-97+1); if(isLargePresent && c<target) { continue; } int
			 * b=isLargePresent?Math.abs(97-target+1):Math.abs(97-target+1)%26; int
			 * d=Math.abs(a-b); if(d<diff && c!=target) { diff=d; smallest=c; }
			 */
		}
		System.out.println(smallest);
	}

	public static void dominantIndex(int[] nums) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int firstIndex = 0;
		int secondIndex = 0;
		int j = 0;
		for (int i : nums) {

			if (i > firstMax) {
				secondMax = firstMax;
				firstMax = i;

				secondIndex = firstIndex;
				firstIndex = j;
			} else {
				if (i > secondMax) {
					secondMax = i;
					secondIndex = j;
				}
			}

			j++;
		}

		if (firstMax >= secondMax * 2) {
			System.out.println(firstIndex);
		} else {
			System.out.println(-1);
		}

		System.out.println(firstIndex + " " + secondIndex);
	}

	public static void printDiagonal(int[][] m) {

		int cLength = m[0].length;
		int k = 0;
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m[i].length - 1; j++) {
				System.out.print(m[i][j] + " " + m[i + 1][j + 1]);
			}
			System.out.println(" ");
		}

	}

	static List<String> result = new ArrayList<String>();
	static HashSet<String> visited = new HashSet<String>();

	public static void letterHelper(StringBuffer s, int point) {
		if (point > s.length()) {
			return;
		}
		if (!visited.contains(s.toString())) {
			result.add(s.toString());
			visited.add(s.toString());
		}

		for (int i = point; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c)) {
				letterHelper(s, point + 1);
				char toAdd = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
				s.setCharAt(i, toAdd);

				letterHelper(s, point + 1);
			} else {
				continue;
			}
		}

	}

	public static void letterCasePermutation(String S) {

		letterHelper(new StringBuffer(S), 0);

		// return result;
	}

	public static boolean rotateString(String A, String B) {
		int length = A.length();
		int count = 0;
		char[] c = A.toCharArray();
		while (count < A.length()) {
			System.out.println(new String(c));
			if (new String(c).equals(B)) {
				return true;
			}
			int i = count + 1;
			char temp = c[count];
			char temp2 = ' ';
			int k = 0;
			while (k <= length) {
				temp2 = c[i % length];
				c[i % length] = temp;
				temp = temp2;
				i++;
				k++;
			}
			count++;
		}

		return false;
	}

	public static void shortestToChar(String S, char C) {
		ArrayList<Integer> position = new ArrayList<Integer>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == C) {
				position.add(i);
			}
		}
		int[] index = new int[S.length()];
		for (int i = 0; i < S.length(); i++) {
			int distance = Integer.MAX_VALUE;

			for (int j = 0; j < position.size(); j++) {
				if (Math.abs(i - position.get(j)) < distance) {
					distance = Math.abs(i - position.get(j));
				}
			}
			index[i] = distance;
		}

		for (int p : index) {
			System.out.print(p + " ");
		}
	}

	public static void threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		int i = 0;
		int previous = Integer.MAX_VALUE;

		while (i <= nums.length - 3) {
			if (nums[i] == previous) {
				i++;
				continue;
			}

			int n = nums[i];
			int a = i + 1;
			int b = nums.length - 1;
			int preva = Integer.MAX_VALUE;
			int prevb = Integer.MAX_VALUE;
			boolean resultFound = false;
			while (a < b) {

				if (preva == nums[a] && resultFound) {
					a++;
					continue;
				}

				if (prevb == nums[b] && resultFound) {
					b--;
					continue;
				}

				preva = nums[a];
				prevb = nums[b];
				int r = nums[a] + nums[b];
				if (r == n * -1) {
					List<Integer> t = new ArrayList<Integer>();
					t.add(nums[a]);
					t.add(nums[b]);
					t.add(n);
					result.add(t);
					b--;
					a++;
					resultFound = true;
				}

				if (r > n * -1) {
					b--;
					resultFound = false;
				}

				if (r < n * -1) {
					a++;
					resultFound = false;
				}

			}
			previous = nums[i];
			i++;
		}

		for (List<Integer> m : result) {
			System.out.print(m);
			System.out.println(" ");
		}
	}

	public static int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int closestSum = 0;
		if (nums.length < 3) {
			return 0;
		}

		if (nums.length == 3) {
			return Math.abs(nums[0] + nums[1] + nums[2]);
		}

		Arrays.sort(nums);

		int a = 0;

		while (a <= nums.length - 3) {
			int i = a + 1;
			int j = nums.length - 1;

			int toGet = target - nums[a];

			while (i < j) {
				int diff = nums[i] + nums[j];
				if (diff == toGet) {
					return target;
				}

				// min=Math.min(min, Math.abs(diff-toGet));

				if (Math.abs(diff - toGet) < min) {
					min = Math.abs(diff - toGet);
					closestSum = nums[a] + nums[i] + nums[j];
				}

				if (diff > toGet) {
					j--;
				}

				if (diff < toGet) {
					i++;
				}
			}
			a++;
		}

		return closestSum;
	}

	public static void letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String[] ar = new String[digits.length()];
		for (int i = 0; i < digits.length(); i++) {
			ar[i] = map[Character.getNumericValue(digits.charAt(i))];
		}
		Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < ar.length; i++) {
			String number = ar[i];
			if (q.isEmpty()) {
				for (Character c : number.toCharArray()) {
					q.add(new String("" + c));
				}
			} else {
				int size = q.size();

				while (size > 0) {
					String s = q.remove();

					for (Character c : number.toCharArray()) {
						q.add(s + c);
					}
					size--;
				}

			}
		}

		while (!q.isEmpty()) {
			result.add(q.remove());
		}

		for (String s : result) {
			System.out.println(s);
		}
		System.out.println(result.size());
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fast = head;
		ListNode slow = head;

		while (n > 0) {
			fast = fast.next;
			n--;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		if (slow != null && slow.next != null)
			slow.next = slow.next.next;

		return head;
	}

	public static int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) {
			return 0;
		}

		int dividend_check = dividend < 0 ? -1 : 1;
		int divsor_check = divisor < 0 ? -1 : 1;
		long ansToAdd = (long) dividend_check * (long) divsor_check;
		long div = dividend;
		long visor = divisor;
		long dividend_long = Math.abs(div);
		long divisor_long = Math.abs(visor);
		if (divisor_long > dividend_long) {
			return 0;
		}
		if (divisor_long == 1) {
			int f = (int) (ansToAdd * dividend_long);
			return f;
		}
		long left = 1;
		long right = dividend_long;
		long ans = 1;
		while (left < right) {
			long mid = left + ((right - left) / 2);
			ans = mid;

			if (right - left == 1) {
				mid = left;
				break;
			}
			if (mid * divisor_long == dividend_long) {
				ans = mid;
				break;
			}

			if (mid * divisor_long > dividend_long) {
				right = mid;
			}

			if (mid * divisor_long < dividend_long) {
				left = mid;
			}

		}

		ans = ans * (dividend_check * divsor_check);

		return (int) ans;

	}

	public static void search(int[] nums, int target) {

		int l = 0;
		int r = nums.length - 1;
		int point = -1;
		while (l < r) {
			int mid = (l + r) / 2;

			int n = nums[mid];

			if (nums[l] == target) {
				point = l;
				break;
			}

			if (nums[r] == target) {
				point = r;
				break;
			}

			if (n == target) {
				point = mid;
				break;
			}
			if (target >= nums[l] && target <= n) {
				r = mid;
			} else {
				l = mid;
			}
		}

		System.out.println(point);
	}

	public static int getLeft(int[] nums, int left, int right, int target, int direction) {
		int point = -1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;

			if (direction == 1) {
				if (nums[mid] == target && nums[mid - 1] < target) {
					return mid;
				}

				if (nums[mid] >= target) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (nums[mid] == target && nums[mid + 1] > target) {
					return mid;
				}

				if (nums[mid] <= target) {
					left = mid;
				} else {
					right = mid;
				}
			}

		}

		if (nums[left] == target && nums[right] != target) {
			return left;
		}

		if (nums[right] == target && nums[left] != target) {
			return right;
		}

		if (nums[left] == target && nums[right] == target) {
			return direction == 1 ? left : right;
		}

		return point;
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums.length == 0) {
			return result;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				if (nums[mid - 1] < target && nums[mid + 1] > target) {
					result[0] = mid;
					result[1] = mid;
					return result;
				} else {
					result[0] = getLeft(nums, left, mid, target, 1);
					result[1] = getLeft(nums, mid, right, target, 0);
					return result;
				}
			}

			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}

		}

		if (nums[left] == target && nums[right] != target) {
			result[0] = left;
			result[1] = left;
			return result;
		}
		if (nums[right] == target && nums[left] != target) {
			result[1] = right;
			result[0] = right;
			return result;
		}

		if (nums[left] == target && nums[right] == target) {
			result[0] = left;
			result[1] = right;
			return result;
		}

		System.out.println(result[0] + " " + result[1]);

		return result;

	}

	public static boolean isValidSudoku(char[][] board) {
		boolean result = true;

		// Row
		for (int i = 0; i < board.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < board[i].length; j++) {
				char c = board[i][j];
				if (Character.isDigit(c)) {
					if (set.contains(Character.getNumericValue(c))) {
						return false;
					} else {
						set.add(Character.getNumericValue(c));
					}
				}
			}
		}

		// Column
		for (int i = 0; i < board.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < board[i].length; j++) {
				char c = board[j][i];
				if (Character.isDigit(c)) {
					if (set.contains(Character.getNumericValue(c))) {
						return false;
					} else {
						set.add(Character.getNumericValue(c));
					}
				}
			}
		}

		// Set of Three
		int count = 3;
		int row = 0;
		int col = 0;
		int ct = 1;
		int rt = 1;
		int mao = 1;
		while (rt <= count) {
			while (ct <= count) {
				System.out.println("******************  ");
				System.out.println("Set " + mao);
				System.out.println("  ");
				HashSet<Integer> set = new HashSet<Integer>();
				for (int i = row; i < board.length && i < row + count; i++) {

					for (int j = col; j < board[i].length && j < col + count; j++) {

						char c = board[i][j];
						System.out.print(c == '.' ? '0' + " " : c + "  ");
						if (Character.isDigit(c)) {
							if (set.contains(Character.getNumericValue(c))) {
								return false;
							} else {
								set.add(Character.getNumericValue(c));
							}
						}
					}
					System.out.println(" ");

				}

				col = col + count;
				ct++;
				mao++;
			}
			row = row + count;
			col = 0;
			ct = 0;
			rt++;

		}

		return result;
	}

	static List<List<Integer>> combinationSumResult = new ArrayList<List<Integer>>();

	public static void combinationSum(int[] candidates, int target) {
		combinationSumResultHelper(candidates, target, 0, new ArrayList<Integer>(), 0);

		// return combinationSumResult;
	}

	public static void combinationSumResultHelper(int[] candiates, int target, int sumTillNow, List<Integer> temp,
			int position) {
		if (sumTillNow == target) {
			combinationSumResult.add(new ArrayList<Integer>(temp));
			temp.remove(temp.size() - 1);
			return;
		}

		if (sumTillNow > target) {
			temp.remove(temp.size() - 1);
			return;
		}

		for (int i = position; i < candiates.length; i++) {

			if (i > position && candiates[i] == candiates[i - 1]) {
				continue;
			}
			temp.add(candiates[i]);
			combinationSumResultHelper(candiates, target, sumTillNow + candiates[i], temp, i + 1);

			// temp=new ArrayList<Integer>();
			// temp.remove(temp.size()-1);

		}

		if (temp.size() >= 1) {
			temp.remove(temp.size() - 1);
		}

	}

	public static void multiply(String num1, String num2) {
		int[] result = new int[num1.length() + num2.length()];

		int carry = 0;
		int addCarry = 0;

		int row = 0;
		int index = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int a = Character.getNumericValue(num1.charAt(i));

			index = index + row;
			for (int j = num2.length() - 1; j >= 0; j--) {
				result[index] = result[index] + carry;
				int b = Character.getNumericValue(num2.charAt(j));

				int r = a * b;

				if (r > 9) {
					carry = r / 10;
					r = r % 10;
				} else {
					carry = 0;
				}
				int m = result[index] + r + addCarry;

				if (m > 9) {
					addCarry = m / 10;
					m = m % 10;
				} else {
					addCarry = 0;
				}
				result[index] = m;

				index++;
			}

			result[index] = carry + addCarry;

			carry = 0;
			addCarry = 0;
			row = row + 1;
			index = 0;
		}

		StringBuilder resultInString = new StringBuilder("");
		boolean firstNumber = false;
		for (int i = result.length - 1; i >= 0; i--) {

			if (result[i] == 0 && !firstNumber) {
				continue;
			} else {
				firstNumber = true;
			}
			resultInString.append(String.valueOf(result[i]));
		}

		if (resultInString.toString().isEmpty()) {

		}

		System.out.println(resultInString.reverse().toString());
	}

	static List<List<Integer>> resultsPermute = new ArrayList<List<Integer>>();

	public static void permute(int[] nums) {
		Arrays.sort(nums);
		permuteHelper(nums, new ArrayList<Integer>(), new boolean[nums.length]);
	}

	public static void permuteHelper(int[] nums, List<Integer> temp, boolean[] visited) {
		if (temp.size() >= nums.length) {
			resultsPermute.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// if(i>0 && nums[i]==nums[i-1])continue;
			if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])
				continue;
			if (visited[i])
				continue;
			if (!visited[i]) {

				visited[i] = true;
				temp.add(nums[i]);
				permuteHelper(nums, temp, visited);

			}
			visited[i] = false;
			if (temp.size() > 0) {
				temp.remove(temp.size() - 1);
			}

		}
	}

	public void rotate(int[][] matrix) {
		roatateRows(matrix);
		rotateCols(matrix);
		HelperUtils.printMatrix(matrix);
	}

	public void rotateCols(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {

			for (int j = i + 1; j < matrix.length; j++) {
				int hor = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = hor;
			}
		}
	}

	public void roatateRows(int[][] matrix) {
		int i = 0, j = matrix.length - 1;

		while (i < j) {
			for (int col = 0; col < matrix.length; col++) {
				int up = matrix[i][col];
				matrix[i][col] = matrix[j][col];
				matrix[j][col] = up;
			}
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		CommonsTwo c = new CommonsTwo();
		c.rotate(matrix);
	}

	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};
}
