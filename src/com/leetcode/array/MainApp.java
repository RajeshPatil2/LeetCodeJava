package com.leetcode.array;

import com.leetcode.linkedlist.*;
import com.leetcode.hashing.*;

public class MainApp {

    public static void main(String[] args) {

        // ===== Rotate List Test =====
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        ListNode result = RotateList.rotateRight(head, 2);

        System.out.print("Rotated List: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        // ===== Valid Sudoku Test =====
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("\nSudoku Valid: " + ValidSudoku.isValidSudoku(board));
    }
}

