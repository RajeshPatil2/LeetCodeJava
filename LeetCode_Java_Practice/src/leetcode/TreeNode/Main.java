package leetcode.TreeNode;

import java.util.*;

//TreeNode definition
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

class Solution {

	// Function to find level with maximum sum
	public int maxLevelSum(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int level = 1;
		int answerLevel = 1;
		long maxSum = Long.MIN_VALUE;

		while (!queue.isEmpty()) {
			int size = queue.size();
			long levelSum = 0;

			// Traverse current level
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelSum += node.val;

				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}

			// Check maximum sum
			if (levelSum > maxSum) {
				maxSum = levelSum;
				answerLevel = level;
			}

			level++;
		}

		return answerLevel;
	}
}

public class Main {
	public static void main(String[] args) {

		/*
		 * Example 1: Tree: 1 / \ 7 0 / \ 7 -8
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);

		Solution solution = new Solution();
		int result = solution.maxLevelSum(root);

		System.out.println("Level with maximum sum: " + result);
	}
}
