package com.medium_problems;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1, max = 0;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater sol = new ContainerWithMostWater();
		int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] height2 = { 1, 1 };
		System.out.println(sol.maxArea(height1)); // 49
		System.out.println(sol.maxArea(height2)); // 1
	}
}
