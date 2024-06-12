package random;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	// Complete the compareTriplets function below.
	// public static List<String> reorderLines(int logFileSize, List<String>
	// logLines) {
	// // Lines with words are lexicographically ordered
	// // Indentifiers are ignored
	// // In case of ties, indentifiers are used to order, lexicographically
	// // Alpha numeric to be sorted in ASCII Order
	// // WRITE YOUR CODE HERE
	// List<String> letter;
	// List<String> digits;
	// List<String> tmp;
	// int i;
	// int j;
	//
	// for( i =0; i< logFileSize; i ++)
	//
	// }
	// METHOD SIGNATURE ENDS

	public static int[] twoNumberSum(int[] array, int targetSum) {
		// Write your code here.
		// 2 elemenets in array need to sum up to targetSum
		// if no elements sum up to the targetSum, empty array is returned
		int i = 0;
		int j = 0;
		int[] result = new int[2];
		if (array.length > 0) {
			for (i = 0; i < array.length; i++) {
				for (j = 1; j < array.length; j++) {
					if (array[i] + array[j] == targetSum && (array[i] != array[j])) {
						result[0] = array[i];
						result[1] = array[j];
						return result;
					}
				}
			}
		}
		return new int[0];
	}

	public static int biValuedArrLength(int[] a) {

		// if (a.length == 2)
		// return 2;

		int maxLength = 0;

		for (int i = 0; i < a.length; i++) {

			int firstNo = a[i];

			int secondNo = firstNo;

			for (int j = i + 1; j < a.length; j++) {

				int currLength = j - i + 1;

				if (a[j] != firstNo && a[j] != secondNo) {

					if (secondNo == firstNo) {
						secondNo = a[j];
					} else {
						break;
					}

				}
				if (currLength > maxLength) {
					maxLength = currLength;
				}

			}
		}
		return maxLength;
	}

	public static int sol(int[] A, int[] B, int N) {
		// Need to loop through A and B to set the edges
		// The total number of edges for both nodes A and B
		// need to be counted too find the direction. NOTE: be aware of bi-direction
		// Once the edge count in done, and the ranks are counted too, compare rank
		// for the latest nodes with the latest maximal value. Save if greater than.

		// to keep track of all the edges
		int numberOfEdges[] = new int[N + 1];

		// length of node A
		int lengthA = A.length;

		// length of node B
		int lengthB = B.length;

		// Maximal network rank
		int max = 0;

		// iterator
		int i = 0;

		// counting the number of edegs. No need to differentiate A and B length as they
		// are the same
		for (i = 0; i < lengthA; i++) {
			numberOfEdges[A[i]] = numberOfEdges[A[i]] + 1;
			numberOfEdges[B[i]] = numberOfEdges[B[i]] + 1;

		}

		// Comparing the edges. If Max, then store. Finall, return max
		for (i = 0; i < lengthA; i++) {
			int temp = numberOfEdges[A[i]] + numberOfEdges[B[i]] - 1;

			if (temp > max) {
				max = temp;
			}
		}

		return max;

	}

	public class Tree {
		public int x;
		public Tree l;
		public Tree r;
	};

	// To create a new Tree
	public Tree newTree(int val) {
		Tree t = new Tree();
		t.x = val;
		t.l = null;
		t.r = null;
		return t;
	}

	// return struct to check perfectness of subtree
	static class infoStruct {
		boolean isPerfect; // check if subtree is perfect
		int height; // tree height
		Tree rootTree; // root of largest perf sub-tree
	}

	static public int solution(Tree T) {
		infoStruct ans = findPerfectBinaryTree(T);

		// Height of the found sub-tree
		int h = ans.height;

		return (int) (Math.pow(2, h) - 1.0);
	}

	static infoStruct findPerfectBinaryTree(Tree t) {

		infoStruct is = new infoStruct();

		// base case. If base case is hit, store all info and return
		if (t == null) {
			is.isPerfect = true;
			is.height = 0;
			is.rootTree = null;
			return is;
		}

		// recurse on left subtree
		infoStruct lst = findPerfectBinaryTree(t.l);
		
		// recurse on right subtree
		infoStruct rst = findPerfectBinaryTree(t.r);

		if (lst.isPerfect && rst.isPerfect && lst.height == rst.height) {
			is.height = lst.height + 1;
			is.isPerfect = true;
			is.rootTree = t;
			return is;
		}

		is.isPerfect = false;
		is.height = Math.max(lst.height, rst.height);
		is.rootTree = (lst.height > rst.height ? lst.rootTree : rst.rootTree);
		return is;
	}

	public static void main(String[] args) throws IOException {
//        int size = 6;
//        List<String> logFile = new ArrayList<String>();
//        logFile.add("t2 12 121 98");
//        logFile.add("r1 box ape bit");
//
//        int[] a = { 4 };
//
//        int solution = biValuedArrLength(a);
//
//        System.out.println("Result is :" + solution);

		// for (int i : twoNumberSum(a, 4)) {
		// System.out.println(i);
		// }

		// [t2 12 121 98, r1 box ape bit, b4 xi me nu, br8 eat num did, w1 has
		// uni gry, f3 52 54 31]

		// [mi2 jog mid pet, wz3 34 54 398, a1 alps cow bar, x4 45 21 7]

		// for (int i = 0; i < logFile.size(); i++) {
		// System.out.print("============" + logFile);
		// }

		// List<String> reordered = reorderLines(6, logFile);

//		int[] a = { 1, 2, 4, 5 };
//		int[] b = { 2, 3, 5, 6 };
//
//		System.out.println("output is : " + sol(a, b, 6));

		Solution test = new Solution();
		Tree t = test.newTree(50);
		t.l = test.newTree(30);
		t.r = test.newTree(60);
		t.l.l = test.newTree(5);
		t.l.r = test.newTree(20);
		t.r.l = test.newTree(45);
		t.r.r = test.newTree(70);
		t.r.l.l = test.newTree(10);
		t.r.l.r = test.newTree(85);
		t.r.r = test.newTree(70);
		t.r.r.l = test.newTree(65);
		t.r.r.r = test.newTree(80);

		System.out.print("answer: " + String.valueOf(solution(t)));

	}
}
