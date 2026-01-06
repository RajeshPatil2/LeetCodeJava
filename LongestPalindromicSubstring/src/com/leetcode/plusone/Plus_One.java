package com.leetcode.plusone;

import java.util.Arrays;

public class Plus_One {

	public int[] plusOne(int[] digits) {

		// Start from last digit
		for (int i = digits.length - 1; i >= 0; i--) {

			// If digit is less than 9, just add 1 and return
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			// If digit is 9, make it 0 and continue carry
			digits[i] = 0;
		}

		// If all digits were 9
		int[] result = new int[digits.length + 1];
		result[0] = 1; // Example: 999 -> 1000
		return result;
	}

	// Main method for local testing
	public static void main(String[] args) {
		Plus_One sol = new Plus_One();

		int[] digits1 = { 1, 2, 3 };
		int[] digits2 = { 4, 3, 2, 1 };
		int[] digits3 = { 9 };

		System.out.println(Arrays.toString(sol.plusOne(digits1))); // [1, 2, 4]
		System.out.println(Arrays.toString(sol.plusOne(digits2))); // [4, 3, 2, 2]
		System.out.println(Arrays.toString(sol.plusOne(digits3))); // [1, 0]
	}
}
