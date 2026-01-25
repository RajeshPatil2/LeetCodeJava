package com.hard_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s == null || words.length == 0)
			return result;

		int wordLen = words[0].length(), totalLen = wordLen * words.length;
		Map<String, Integer> wordCount = new HashMap<>();
		for (String w : words)
			wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

		for (int i = 0; i <= s.length() - totalLen; i++) {
			Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while (j < words.length) {
				String sub = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
				if (!wordCount.containsKey(sub))
					break;
				seen.put(sub, seen.getOrDefault(sub, 0) + 1);
				if (seen.get(sub) > wordCount.get(sub))
					break;
				j++;
			}
			if (j == words.length)
				result.add(i);
		}
		return result;
	}

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sol = new SubstringWithConcatenationOfAllWords();
		String s1 = "barfoothefoobarman";
		String[] words1 = { "foo", "bar" };
		String s2 = "barfoofoobarthefoobarman";
		String[] words2 = { "bar", "foo", "the" };
		System.out.println(sol.findSubstring(s1, words1)); // [0, 9]
		System.out.println(sol.findSubstring(s2, words2)); // [6, 9, 12]
	}
}
