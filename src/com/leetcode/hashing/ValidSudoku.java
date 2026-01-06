package com.leetcode.hashing;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char ch = board[i][j];
                if (ch != '.') {

                    if (!seen.add(ch + " in row " + i)) 
                    	return false;
                    if (!seen.add(ch + " in col " + j))
                    	return false;
                    if (!seen.add(ch + " in box " + 
                    	(i / 3) + "-" + (j / 3))) 
                    	return false;
                }
            }
        }
        return true;
    }
}
