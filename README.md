# LeetCode Java Solutions
This repository contains Java solutions for selected LeetCode problems.
All code is organized by problem type in packages.

---

## 1️⃣ Problem: Rotate List (Medium)
**Problem Description:**  
Given the head of a linked list, rotate the list to the right by `k` positions.

**Input & Output Examples:**

Example 1:  
Input: head = [1,2,3,4,5], k = 2  
Output: [4,5,1,2,3]  

Example 2:  
Input: head = [0,1,2], k = 4  
Output: [2,0,1]  

**Constraints:**  
- Number of nodes: 0 to 500  
- Node values: -100 to 100  
- k: 0 <= k <= 2 * 10^9  

**Explanation (Easy Diagram):**

Original List:  
1 → 2 → 3 → 4 → 5  

Rotate by k=2:  
Step 1: Split last 2 nodes:  
...1 → 2 → 3   4 → 5  
Step 2: Attach last nodes at front:  
4 → 5 → 1 → 2 → 3  

**Key Idea:**  
- Find length of list  
- k = k % length  
- Cut last k nodes and attach in front  

**Package & File Location:**  
`com.leetcode.linkedlist/RotateList.java`  

---

## 2️⃣ Problem: Valid Sudoku (Medium)
**Problem Description:**  
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated.  
Rules:  
- Each row must contain digits 1-9 without repetition  
- Each column must contain digits 1-9 without repetition  
- Each 3x3 sub-box must contain digits 1-9 without repetition  

**Input Example:**
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]


**Output:** `true`

**Key Idea (Easy Diagram):**
- Check each row, column, and 3x3 box for duplicates
- Ignore empty cells ('.')


