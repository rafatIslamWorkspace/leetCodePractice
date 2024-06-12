package random;

import java.util.*;

public class LCPractice {

	public static int maxLength(List<String> arr) {

		// Problem is 2 folds:
		// 1. Need to keep track of duplicates
		// 2. Even if the characters are formed need to check if its the longest
		List<String> results = new ArrayList<>();

		results.add("");

		int best = 0;

		for (String word : arr) {
			int resultsLen = results.size();

			for (int i = 0; i < resultsLen; i++) {
				String newRes = results.get(i) + word;
				Set<Character> newResSet = new HashSet<>();

				for (char c : newRes.toCharArray()) {
					newResSet.add(c);
				}

				if (newRes.length() != newResSet.size()) {
					continue;
				} else {
					results.add(newRes);
					best = Math.max(best, newRes.length());
				}
			}
		}
		return best;

	}

	public int minCost(String colors, int[] neededTime) {
		int min_cost = 0;

		int i = 0;
		int j = i + 1;

		while (j < colors.length()) {

			if (colors.charAt(i) != colors.charAt(j))
				i = j;
			else {
				if (neededTime[i] >= neededTime[j])
					min_cost += neededTime[j];

				else {
					min_cost += neededTime[i];
					i = j;
				}
			}

			j++;
		}

		return min_cost;
	}


	public int minOperationsToChangeBinaryString(String s) {
		int count0 = 0, count1 = 0;

		// If string starts with '0' even numbers should be '0' and odd numbers should
		// '1';
		for (int i = 0; i < s.length(); i += 2) {
			if (s.charAt(i) != '0')
				count0++;
		}

		for (int i = 1; i < s.length(); i += 2) {
			if (s.charAt(i) != '1')
				count0++;
		}

		// If string starts with '1' even numbers should be '1' and odd numbers should
		// '0';

		for (int i = 0; i < s.length(); i += 2) {
			if (s.charAt(i) != '1')
				count1++;
		}

		for (int i = 1; i < s.length(); i += 2) {
			if (s.charAt(i) != '0')
				count1++;
		}

		return Math.min(count1, count0);

	}

	public int[] sumZero(int n) {

		int[] array = new int[n];
		if (n == 1) {
			array[0] = 0;
		} else {
			int i = 0;
			while (i < (n - 1)) {
				array[i] = (i + 1);
				array[i + 1] = (i + 1) * (-1);
				i += 2;
			}
			if (i == (n - 1)) {
				array[i] = 0;
			}
		}
		return array;
	}

	public int largestPerimeterTriangle(int[] A) {
		Arrays.sort(A);
		for (int i = A.length - 3; i >= 0; --i)
			if (A[i] + A[i + 1] > A[i + 2])
				return A[i] + A[i + 1] + A[i + 2];
		return 0;
	}

	public int maxNumberOfBalloons(String text) {
		int bCount = 0, aCount = 0, lCount = 0, oCount = 0, nCount = 0;

		// Count the frequencey of all the five characters
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'b') {
				bCount++;
			} else if (text.charAt(i) == 'a') {
				aCount++;
			} else if (text.charAt(i) == 'l') {
				lCount++;
			} else if (text.charAt(i) == 'o') {
				oCount++;
			} else if (text.charAt(i) == 'n') {
				nCount++;
			}
		}

		// Find the potential of each character.
		// Except for 'l' and 'o' the potential is equal to the frequency.
		lCount = lCount / 2;
		oCount = oCount / 2;

		// Find the bottleneck.
		return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
	}

	public static void main(String[] args) throws Exception {

		// String[] arr = {"un","iq","ue"};

		List<String> arr = new ArrayList<>();

		arr.add("un");
		arr.add("iq");
		arr.add("ue");

		System.out.println(maxLength(arr));

	}

}
