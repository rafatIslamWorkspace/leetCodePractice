package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class Codility {

	public static int code(int M, int[] A) {
		int N = A.length;

		// array to count the number of repeating elements
		int[] count = new int[M + 1];

		for (int i = 0; i <= M; i++) {
			count[i] = 0;
		}

		// { 1, 2, 3, 3, 1, 3, 1, 2, 2 };
		int maxOccurence = 1;
		int index = -1;

		for (int i = 0; i < N; i++) {

			if (count[A[i]] > 0) {
				int tmp = count[A[i]];

				if (tmp > maxOccurence) {
					maxOccurence = tmp;
					index = i;
				}
				count[A[i]] = tmp + 1;
			} else {
				count[A[i]] = 1;
			}

			if (maxOccurence == M) {
				break;
			} // missing piece in the code
		}
		return A[index];
	}

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		int aResult = 0;
		int bResult = 0;

		for (int i = 0; i < 3; i++) {
			if (a.get(i) > b.get(i)) {
				aResult = aResult + 1;
			}
			if (b.get(i) > a.get(i)) {
				bResult = bResult + 1;
			}
		}
		result.add(aResult);
		result.add(bResult);
		return result;
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
		// Write your code here
		int n = arr.size();
		int d1 = 0;
		int d2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					d1 = d1 + arr.get(i).get(j);
				}
				if (i == n - j - 1) {
					d2 = d2 + arr.get(i).get(j);
				}
			}
		}
		return Math.abs(d1 - d2);
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public int[] twoSum_less_complex(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static boolean isPalindrome(String str) {
		// Write your code here.
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}

		System.out.println(reverse);
		if (reverse.equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}

	public static String findSubstring(String s, int k) {
		// Write your code here
		String temp = "";
		String cur = "";
		int lengthOfString = 0;

		if (k == 1) {
			for (int i = 0; i < s.length(); i++) {
				lengthOfString = checkVowel("" + s.charAt(i));
				if (lengthOfString == 1) {
					return "" + s.charAt(i);
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			temp += s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				temp += s.charAt(j);
				if (temp.length() == k) {
					int n = checkVowel(temp);
					if (n >= lengthOfString) {
						lengthOfString = n;
						cur = temp;
						temp = "";
						break;
					} else {
						temp = "";
						break;
					}
				}
			}
		}
		return cur;
	}

	private static int checkVowel(String str) {
		int longestSub = 0;
		char b;

		for (int j = 0; j < str.length(); j++) {
			b = str.charAt(j);
			if (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u') {
				longestSub++;
			}
		}
		return longestSub;
	}

	public static int smallestPositiveInteger(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer n = 0;

		for (int i : A) {
			if (i > 0) {
				map.put(i, i);
			}
		}

		if (map.size() == 0) {
			return 1;
		}

		for (Integer j = 1; j <= map.size(); j++) {
			n = map.get(j);
			if (j != n) {
				return j;
			}

		}
		return n + 1;
	}

	public int longestBiValue(int[] a) {

		// a = [ 1 2 3 2 ] should return 3 because 2 3 2 is a bi valued slice of array a
		// a = [ 0 5 4 4 5 12 ] should return 4 because 5 4 4 5 is a bi valued slice of
		// array a
		// a = [ 4 4 ] should return 2

		// what are needed for this problem:
		// positions where the slice starts and where it ends

		return 0;
	}

	static int solution(int[] A) {
		//
		int ans = A[0];
		// @formatter:on
		;
		for (int i = 1; i < A.length; i++) {
			if (ans > A[i]) {
				ans = A[i];
			}
		}
		return ans;
	}

	public static int sol(int[] A) {
		int ans = 1;

		for (int i = 0; i < A.length; i++) {
			ans = ans * A[i];
		}

		if (ans > 0) {
			return 1;
		}

		if (ans < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	static int count = 0;

	public int solution(Tree T) {
		// write your code in Java SE 8
		count = 0;
		traversePreOrder(T, Integer.MIN_VALUE);
		return count;
	}

	public void traversePreOrder(Tree t, int max) {

		if (t == null) {
			return;
		}

		if (t.x >= max) {
			++count;
			max = Math.max(t.x, max);
		}

		traversePreOrder(t.l, max);
		traversePreOrder(t.r, max);
	}

	public static boolean checkParenthesisBalance(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char bracket = s.charAt(i);

			if (bracket == '(' || bracket == '[' || bracket == '{')
				st.push(bracket);
			else if (bracket == ')') {
				if (st.isEmpty() || st.pop() != '(')
					return false;
			} else if (bracket == '}') {
				if (st.isEmpty() || st.pop() != '{')
					return false;
			} else if (bracket == ']') {
				if (st.isEmpty() || st.pop() != '[')
					return false;
			} else {
				// st.push(bracket);
				continue;
				// For non-bracket characters, this will already
				// be handled earlier, but inserting it
				// in the stack will mean that no matching characters will be found
				// causing the stack to be non-empty at the end
			}
		}
		return st.isEmpty();
	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		// Write your code here.
		List<Integer[]> result = new ArrayList<Integer[]>();

		List<Integer> list = new ArrayList<Integer>();

		for (int a : array) {
			list.add(a);
		}

		for (int a : array) {

		}

		return new ArrayList<Integer[]>();
	}

	public static void power(int n, int p) throws Exception {
		// n or p cannot be negative
		if ((n < 0) || (p < 0)) {
			throw new Exception("n and p should be non-negative");
		}
		System.out.println(Math.pow(n, p));
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			if (value < this.value) {
				System.out.println("OG Head is " + this.value);
				System.out.println("Value is " + value);
				System.out.println("Going left");
				if (left == null) {
					BST newBST = new BST(value);
					left = newBST;
					System.out.println("Goes left: " + left.value);
				} else {
					left.insert(value);
				}
			} else {
				System.out.println("OG Head is " + this.value);
				System.out.println("Value is " + value);
				System.out.println("Going Right");
				if (right == null) {
					BST newBST = new BST(value);
					right = newBST;
					System.out.println("Goes right: " + right.value);
				} else {
					right.insert(value);
				}
			}
			return this;
		}

	}

	List<Integer> list = new ArrayList<Integer>();
	Map<Integer, List<Integer>> catalogue = new HashMap<Integer, List<Integer>>();

	public long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts,
			List<Integer> priceOfTops, int dollars) {

		if (dollars == 0) {
			return 0;
		}

		catalogue.put(0, priceOfJeans);
		catalogue.put(1, priceOfShoes);
		catalogue.put(2, priceOfSkirts);
		catalogue.put(3, priceOfTops);

		for (Map.Entry mapElement : catalogue.entrySet()) {

		}

		return 0;
	}

	public static List<String> doesCircleExist(List<String> commands) {

		// Need to maintain the direction of the Robot in a grid
		// 0' 90' 270' 360'
		// -0' -90' -270' -360'
		// What we need is to add 90' when moving right
		// Then for Left, we will subtract -90
		// Based on the degrees, we can also determine which axis the Robot is moving on
		// Then its a matter of adding or subtracting the direction based on the degree
		List<String> result = new ArrayList<>();
		for (String command : commands) {
			int x = 0;
			int y = 0;
			int direction = 0;
			for (int i = 0; i < command.length(); i++) {
				char move = command.charAt(i);
				if (move == 'G') {
					if (direction == 0 || direction == 360 || direction == -360) {
						y++;
					} else if (direction == 90 || direction == -270) {
						x++;
					} else if (direction == 180 || direction == -180) {
						y--;
					} else if (direction == 270 || direction == -90) {
						x--;
					}
				} else if (move == 'L') {
					direction = direction - 90;
				} else if (move == 'R') {
					direction = direction + 90;
				}

				if (direction == 360 || direction == -360) {
					direction = 0;
				}
			}

			if (x == 0 && y == 0) {
				result.add("YES");
			} else {
				result.add("NO");
			}
		}
		return result;

		// x and y coordinates. using another variable direction to tell which way the
		// robot is facing
		// Robot has 4 directions. 0', 90', 270', and 360 and their compliments for the
		// opposite direction
		//
	}
//	
//    public static List<Integer> reassignedPriorities(List<Integer> priorities) {
//    	
//    }

	public static List<String> triangleType(List<String> triangleToy) {
		List<String> triangleTypes = new ArrayList<String>();

		for (String s : triangleToy) {
			// Checks if the string in the list is empty or is just a space
			if (!s.isEmpty() || !s.equalsIgnoreCase(" ") || s.length() == 3) {
				// Splits the string on the spaces and inserts in to the array
				String sideLength[] = s.split(" ");

				if (sideLength[0].equalsIgnoreCase(sideLength[1]) && sideLength[2].equalsIgnoreCase(sideLength[1])
						&& sideLength[0].equalsIgnoreCase(sideLength[2])) {
					triangleTypes.add("Equilateral");
				} else if (sideLength[0].equalsIgnoreCase(sideLength[1])
						|| sideLength[2].equalsIgnoreCase(sideLength[1])
						|| sideLength[0].equalsIgnoreCase(sideLength[2])) {
					triangleTypes.add("Isosceles");
				} else if (sideLength[0] != sideLength[1] && sideLength[2] != sideLength[1]
						&& sideLength[0] != sideLength[2]) {
					triangleTypes.add("None of these");
				}
			}
		}

		return triangleTypes;
	}

	public static String reverseSentence(String input) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String[] s = input.split(" ");
		String reverse = "";
		for (int i = s.length - 1; i >= 0; i--) {
			map.put(i, s[i] + " ");
		}
		System.out.println(map);
		for (int j = map.size() - 1; j >= 0; j--) {
			reverse = reverse + map.get(j);

		}

		System.out.println(reverse);

		return "";
	}

	public static void arrayFromString(String line) {
		String[] a = line.split(";");
		String[] b = a[1].split(",");
		int[] c = new int[Integer.parseInt(a[0])];
		for (int i = 0; i < c.length; i++) {
			c[i] = Integer.parseInt(b[i]);
		}
		for (int j = 0; j < c.length; j++) {
			for (int k = j + 1; k < c.length; k++) {
				if (c[k] == c[j]) {
					System.out.println(c[k]);
				}
			}
		}
	}

	private static int[] Integer(char charAt) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		// Write your code here
		Map<String, Integer> stringArray = new HashMap<String, Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (String s : strings) {
			if (!stringArray.containsKey(s)) {
				stringArray.put(s, 1);
			} else {
				stringArray.put(s, stringArray.get(s) + 1);
			}
		}
		for (String s : queries) {
			if (stringArray.containsKey(s)) {
				result.add(stringArray.get(s));
			} else {
				result.add(0);
			}
		}
		return result;
	}
	

	public static int minCost(String colors, int[] neededTime) {
//        int minTime = 0;
//        //Map<Integer, Integer> neededTimeMap = new HashMap<Integer, Integer>();
//        //int[] repeatingColors;
//        int length = colors.length();
//        char firstPointer;
//        char secondPointer;
//        
//        if ( length == 0){
//            
//            return minTime;
//        }
//        
//        for ( int i = 0 ; i< length-1; i++){
//            
//            firstPointer = colors.charAt(i);
//            secondPointer = colors.charAt(i+1);
//            
//            if ( firstPointer == secondPointer){
//                if ( neededTime[i] <= neededTime [i+1] ){
//                    minTime = minTime + neededTime[i];
//                } else {
//                     minTime = minTime + neededTime[i+1];
//                }
//            }else{
//                continue;
//            }
//        }
//        
//        return minTime;

		// this is using 2 pointers. Cannot use for loop as the pointer needs to be
		// controlled by user

		int min_cost = 0;

		int i = 0;
		int j = i + 1;

		while (j < colors.length()) {

			if (colors.charAt(i) != colors.charAt(j)) {
				i = j;
			} else {
				if (neededTime[i] >= neededTime[j]) {
					min_cost += neededTime[j];

				} else {
					min_cost += neededTime[i];
					i = j;
				}
			}

			j++;
		}

		return min_cost;
	}

	public static int maxLength(List<String> arr) {
		// Initialize results with an empty string
		// from which to build all future results
		List<String> results = new ArrayList<>();
		results.add("");
		int best = 0;
		for (String word : arr) {
			// We only want to iterate through results
			// that existed prior to this loop
			int resultsLen = results.size();
			for (int i = 0; i < resultsLen; i++) {
				// Form a new result combination and
				// use a set to check for duplicate `s
				String newRes = results.get(i) + word;
				Set<Character> newResSet = new HashSet<>();
				for (char c : newRes.toCharArray())
					newResSet.add(c);
				if (newRes.length() != newResSet.size()) {
					continue;
				} else {
					// Add valid options to results and
					// keep track of the longest so far
					results.add(newRes);
					best = Math.max(best, newRes.length());
				}
			}
		}
		return best;
	}

	public static int[] zeroSum(int n) {

		// Creating an array of size n to store all unique numbers
		int[] zeroSumArray = new int[n];

		if (n == 1) {
			// First and only edge case coming to mind, if the there is only on number,
			// the result should be 0
			zeroSumArray[0] = 0;
		} else {
			int i = 0;
			while (i < (n - 1)) {
				// Storing the first positive value
				zeroSumArray[i] = (i + 1);
				// Storing absolute value of the first value
				// its unique because its negative
				zeroSumArray[i + 1] = (i + 1) * (-1);
				// iterating to the 3rd index
				i += 2;
			}
			// In case n is odd, the last value is 0
			if (i == (n - 1)) {
				zeroSumArray[i] = 0;
			}
		}
		return zeroSumArray;
	}

	public static int minOperations(String s) {
		int count = 0;
		Map<Integer, Character> map = new HashMap<Integer, Character>();

		for (int i = 0; i < s.length(); i++) {

			map.put(i, s.charAt(i));
		}

		for (int i = 0; i < map.size() - 1; i++) {
			char firstPointer = map.get(i);
			char secondPointer = map.get(i + 1);

			if (firstPointer == secondPointer && firstPointer == '0') {

				map.put(i + 1, '1');
				count++;
				continue;
			}

			if (firstPointer == secondPointer && firstPointer == '1') {

				map.put(i + 1, '0');
				count++;
				continue;
			}

		}

		return count;
	}

	private static int testChecker(String[] T, String[] R) {

		Map<String, String> resultMap = new HashMap<String, String>();
		int testCaseGroup; // contains all test case groups
		int result; // keeps the results
		int pass = 0; // How many test case groups have passed

		String testGroup;

		for (int i = 0; i < T.length; i++) {
			testGroup = getTestName(T[i]);
			if (resultMap.containsKey(testGroup)) {
				// Creating the result map based of the OK, Runtime error and Wrong answer
				// criteria
				String newResult = resultMap.get(testGroup).concat(compileGroupScore(R[i]));
				// read up on hash collisions

//				n*(k+((m+k)*m) 
//						= n*(k+m^2+km) 
//						= since we take the largest value (squared values have larger precedence than addition)
//						= n * m^2

//				where,
//				n = number of members in T
//				k = k elements in each nth member
//				m = length of each member in R
//				for loop er jonno O(n)
//				parseTestName er jonno O(k)
//				concat O(m+k)
//				convertResult O(m)

				resultMap.put(testGroup, newResult);
			} else {
				resultMap.put(testGroup, compileGroupScore(R[i]));
			}
		}

		testCaseGroup = resultMap.size();
		for (String groupResult : resultMap.values()) {

			// O(n) since the number of the T and R are the same length. Going to add up to
			// the size of the
			// T or R

			if (!groupResult.contains("0")) {
				pass = pass + 1;
			}
		}

		return result = Math.round(pass * 100) / testCaseGroup;
	}

	private static String getTestName(String fullTestName) {

		// assumption: the test name is grouped naturally. So the last character is
		// different

		String testCaseGroup;
		char[] word = fullTestName.trim().toCharArray();
		if (!Character.isDigit(word[word.length - 1])) {
			// create test case group
			testCaseGroup = fullTestName.substring(0, fullTestName.length() - 1);
		} else {
			testCaseGroup = fullTestName;
		}
		return testCaseGroup;
	}

	private static String compileGroupScore(String resultName) {
		// complies every groups result accordingly to the OK, Runtime error
		// and Wrong answer

		String result;
		if ("OK".equalsIgnoreCase(resultName)) {
			result = "1";
		} else {
			// always 0 for Runtime error and Wrong answer
			result = "0";
		}
		return result;
	}

	public static boolean evenlySpaced(int a, int b, int c) {
		
		
		int[] array = new int [3];
		
		array[0]=a;
		array[1]=b;
		array[2]=c;
		
		Arrays.sort(array);

		int spaceBetweenSmallAndMedium = array[1] - array[0];
		int spaceBetweenMediumAndLarge = array[2] - array[1];
		
		System.out.println(spaceBetweenSmallAndMedium);
		System.out.println(spaceBetweenMediumAndLarge);

		if (Math.abs(spaceBetweenMediumAndLarge) == Math.abs(spaceBetweenSmallAndMedium)) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public static List<Integer> uniqueNumbers ( List<Integer> list) {
	      for ( int i=0 ; i < list.size(); i++){
	    	  int n = list.get(i);
	        for ( int j = i+1; j < list.size(); j++){
	           if ( n == list.get(j) ){
	               list.remove(j);
	           }
	        }
	      }
	    return list; 
	  }
	
	
//	Group Anagrams- https://leetcode.com/problems/group-anagrams/
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
	
	public static int threeSumSmaller ( int[] nums, int target) {
		int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int first = nums[i];
            int start = i+1;
            int end = nums.length-1;
            int sum;
            while (start<end){
                sum = first + nums[start] + nums[end];
                if(target>sum){
                    ans += (end-start);
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
	}
	
//	Top K Frequent Elements 
//	https://leetcode.com/problems/top-k-frequent-elements/description/	
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                count = map.get(n);
                map.replace(n, count + 1);
                count = 0;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= k) {
                list.add(entry.getKey());
            }
        }
        int[] array = new int[list.size()];
        
        for ( int i = 0; i<list.size();i++){
            array[i]=list.get(i);
        }

        return array;
    }

	public static void main(String[] args) throws Exception {
		
		
		Codility code = new Codility();
		
		int[] nums = {-2,0,1,3};
		int k = 2;
		
		code.threeSumSmaller(nums, k);
		
		
		
//		Codility anagrams = new Codility();
//		
//		String[] str = {"eat","tea","tan","ate","nat","bat"};
//		
//		System.out.println("Output is: " + anagrams.groupAnagrams(str));
//		
//		List<Integer> numbers = new ArrayList<Integer>();
	    // strings.add("Hello, World!");
	    // strings.add("Welcome to CoderPad.");
	    // strings.add("This pad is running Java " + Runtime.version().feature());

//	    numbers.add(1);
//	    numbers.add(2);
//	    numbers.add(-1);
//	    numbers.add(0);
//	    numbers.add(2);
//	    numbers.add(4);
//	    numbers.add(7);
//	    
//	    System.out.println(uniqueNumbers(numbers).toString());
		
//		System.out.println(evenlySpaced (6,2,4));

		// Test case 1
//		String[] T = { "test1a", "test2", "test1b", "test1c", "test3" };
//		String[] R = { "Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded" };
//		String[] T = { "codility1", "codility3", "codility2", "codility4b", "codility4a" };
//		String[] R = { "Wrong answer", "OK", "OK", "Runtime error", "OK" };
//		System.out.println(testChecker(T, R));

//		minOperations("10010100");

//		List<String> arr = new ArrayList<String>();
//		// {"un","iq","ue"};
//		arr.add("un");
//		arr.add("in");
//		arr.add("ue");
//		System.out.println(maxLength(arr));

//		zeroSum(10);

//		int[] numbers = { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 };
//		System.out.println(minCost("aaabbbabbbb", numbers));

//		List<String> triangleToy = new ArrayList<String>();
////		triangleToy.add("10");
//		triangleToy.add("323 323 945");
//		triangleToy.add("46 96 90");
//		triangleToy.add("46 46 46");
//		triangleToy.add("273 201 156");
//
//		System.out.println(triangleType(triangleToy));
//		reverseSentence("HELLO WORLD HI EVERYONE");
//		List<Integer> a = new ArrayList<Integer>();
//		List<Integer> b = new ArrayList<Integer>();
//		List<List<Integer>> massiveList = new ArrayList<List<Integer>>();
//		
//		System.out.println("Return is: " + checkParenthesisBalance("(a)"));
//		
//		new Audi().run();
//		power(2,1000);
//		((Car) new Audi()).run();
		// int[] numbers = { 1, 2, 3, 3, 1, 3, 1, 2, 2 };
//		int[] numbers = { 1, 3, 4, 3, 4, 4, 4, 3 };
//		int[] missingNumbers = { 1, 3, 2, 3, 1, 3, 1 };
//		int[] negativeNumbers = { -1, -2, 0 };
//		int[] n = { 100, 1};
//		a.add(5);
//		a.add(6);
//
//		b.add(3);
//		b.add(6);
//
//		massiveList.add(a);
//		massiveList.add(b);
//		
//		System.out.println(sol(n));
//		
//		Tree tree = new Tree();
//		 
//        /*
//                5
//               /  \
//             3     10
//            /  \   /
//           20   21 1 
//*/
// 
//		tree.x = new Tree(5);
//        tree.l = new Tree(3);
//        tree.r = new Tree(10);
// 
//        tree.r.l.l = new Tree(20);
//        tree.r.l.r = new Tree(21);
// 
//        tree.r.r.l = new Tree(1);
// 
//        
//        traversePreOrder(tree.x, Integer.MIN_VALUE);
// 
//        System.out.println(count);
//		
//		System.out.println("longest sub string is: " + findSubstring("weallloveyou", 7));

//		System.out.println("most occured " + code(4, numbers));
//		System.out.println(compareTriplets(a,b));

		// System.out.println(diagonalDifference(massiveList));
		//
//		Tenor t = new Tenor();
//		Singer s = new Tenor();
//		System.out.println(t.sing()+""+s.sing());
//		new Codility().go();
//		
//		BST binaryTree = new BST(5);
//		binaryTree.insert(10);
//		binaryTree.insert(4);
//		binaryTree.insert(8);
//		binaryTree.insert(5);

	}

//	void go() {
//		new Hound().bark();
//		((Dog) new Hound()).bark();
//		((Dog) new Hound()).sniff();
//	}

}
