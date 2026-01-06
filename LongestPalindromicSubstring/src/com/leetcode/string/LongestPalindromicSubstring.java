package com.leetcode.string;

public class LongestPalindromicSubstring {

	// Main method to test
	public static void main(String[] args) {
		String s1 = "babad";
		String s2 = "cbbd";

		System.out.println("Input: " + s1);
		System.out.println("Longest Palindrome: " + longestPalindrome(s1));

		System.out.println("\nInput: " + s2);
		System.out.println("Longest Palindrome: " + longestPalindrome(s2));
	}

	// Method to find longest palindromic substring
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";

		int start = 0, end = 0; // indices of longest palindrome

		for (int i = 0; i < s.length(); i++) {
			// Odd-length palindrome
			int len1 = expandAroundCenter(s, i, i);
			// Even-length palindrome
			int len2 = expandAroundCenter(s, i, i + 1);

			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	// Helper method: expand from center and return length
	private static int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1; // length of palindrome
	}
}
