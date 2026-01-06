package leetcode.graph;

import java.util.*;

public class LastDayToCross {

	// Directions: down, up, right, left
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static int latestDayToCross(int row, int col, int[][] cells) {
		int left = 0;
		int right = cells.length;
		int answer = 0;

		// Binary Search on days
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (canCross(row, col, cells, mid)) {
				answer = mid; // crossing possible
				left = mid + 1; // try later day
			} else {
				right = mid - 1; // try earlier day
			}
		}
		return answer;
	}

	// BFS check if crossing possible on given day
	private static boolean canCross(int row, int col, int[][] cells, int day) {
		int[][] grid = new int[row][col];

		// Flood cells till 'day'
		for (int i = 0; i < day; i++) {
			int r = cells[i][0] - 1;
			int c = cells[i][1] - 1;
			grid[r][c] = 1; // water
		}

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[row][col];

		// Start BFS from top row
		for (int c = 0; c < col; c++) {
			if (grid[0][c] == 0) {
				queue.offer(new int[] { 0, c });
				visited[0][c] = true;
			}
		}

		// BFS traversal
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			// Reached bottom row
			if (r == row - 1) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc] && grid[nr][nc] == 0) {

					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		return false;
	}

	// ---------------- MAIN METHOD ----------------
	public static void main(String[] args) {

		int row1 = 2, col1 = 2;
		int[][] cells1 = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 2, 2 } };
		System.out.println(latestDayToCross(row1, col1, cells1)); // 2

		int row2 = 2, col2 = 2;
		int[][] cells2 = { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		System.out.println(latestDayToCross(row2, col2, cells2)); // 1

		int row3 = 3, col3 = 3;
		int[][] cells3 = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 2, 2 }, { 1, 1 }, { 1, 3 }, { 2, 3 }, { 3, 2 }, { 3, 1 } };
		System.out.println(latestDayToCross(row3, col3, cells3)); // 3
	}
}
