package com.medium_problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0, maxLen = 0;
		for (int right = 0; right < s.length(); right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left++));
			}
			set.add(s.charAt(right));
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(sol.lengthOfLongestSubstring("pwwkew")); // 3
	}
}
