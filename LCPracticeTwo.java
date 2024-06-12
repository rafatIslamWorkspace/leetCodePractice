package random;

import java.util.HashMap;
import java.util.Map;

import random.Codility.BST;

public class LCPracticeTwo {

//	https://github.com/celaurentin/coding-interview/blob/0cefb6da318fa67174f717119e52f5b5ab5b7bd1/src/com/foo/Nathan. 
	//java#L82 time complexity analyze kortesi. eikhane amar kisu assumptions 
	// ase: I'm only using T as a variable since R only has a fixed number of values
	//so R always contributes to O(1) complexity. 
//
//		https://github.com/celaurentin/coding-interview/blob/0cefb6da318fa67174f717119e52f5b5ab5b7bd1/src/com/foo/Nathan.
	//java#L92 --> O(n) - n being the number of elements in T. 
	//Line#96 e nested for loop not happening as it's taking a single value for `group`. 
//
//		https://github.com/celaurentin/coding-interview/blob/0cefb6da318fa67174f717119e52f5b5ab5b7bd1/src/com/foo/Nathan.java#
	//L105 again for loop and the number of elements for nathanMap is proportional to T. 
	//So O(n) + O(n) => O(n) for time complexity.
//
//		Space complexity would be O(n) for the hashmap.

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

	void printPreorder(BST node) {
		if (node == null)
			return;

		/* first print data of node */
		// or return here
		System.out.print(node.value + " ");

		/* then recur on left subtree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
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

	// read up on hash collisions

//	n*(k+((m+k)*m) 
//			= n*(k+m^2+km) 
//			= since we take the largest value (squared values have larger precedence than addition)
//			= n * m^2

//	where,
//	n = number of members in T
//	k = k elements in each nth member
//	m = length of each member in R
//	for loop  O(n)
//	parseTestName  O(k)
//	concat O(m+k)
//	compileGroupScore O(m)

	private static int testChecker(String[] T, String[] R) {

		Map<String, Boolean> resultMap = new HashMap<>();
		int testCaseGroup; // contains all test case groups
		// int result; //keeps the results
		int pass = 0; // How many test case groups have passed

		String testGroup;

		for (int i = 0; i < T.length; i++) {
			testGroup = getTestName(T[i]);
			if (resultMap.containsKey(testGroup)) {
				// Creating the result map based of the OK, Runtime error and Wrong answer
				// criteria
				Boolean newResult = resultMap.get(testGroup) && (compileGroupScore(R[i]));
				resultMap.put(testGroup, newResult);
			} else {
				resultMap.put(testGroup, compileGroupScore(R[i]));
			}
		}

		testCaseGroup = resultMap.size();
		for (Boolean groupResult : resultMap.values()) {

			// O(n) since the number of the T and R are the same length. Going to add up to
			// the size of the
			// T or R

			if (groupResult) {
				pass = pass + 1;
			}
		}

		return Math.round(pass * 100) / testCaseGroup;
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

	private static Boolean compileGroupScore(String resultName) {
		// complies every groups result accordingly to the OK, Runtime error
		// and Wrong answer

		Boolean result;
		if ("OK".equalsIgnoreCase(resultName)) {
			result = true;
		} else {
			// always 0 for Runtime error and Wrong answer
			result = false;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {

		// Test case 1
//		String[] T = { "test1a", "test2", "test1b", "test1c", "test3" };
//		String[] R = { "Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded" };
		String[] T = { "codility1", "codility3", "codility2", "codility4b", "codility4a" };
		String[] R = { "Wrong answer", "OK", "OK", "Runtime error", "OK" };
		System.out.println(testChecker(T, R));
	}

}
