package com.leetcode.skyline;

import java.util.*;

public class Solution {

    // LeetCode method
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start event
            events.add(new int[]{b[1], b[2]});  // end event
        }

        // Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(0);
        int prevHeight = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (int[] e : events) {

            if (e[1] < 0) {
                maxHeap.add(-e[1]); // building start
            } else {
                maxHeap.remove(e[1]); // building end
            }

            int currHeight = maxHeap.peek();

            if (currHeight != prevHeight) {
                result.add(Arrays.asList(e[0], currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] buildings = {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };

        List<List<Integer>> skyline = sol.getSkyline(buildings);

        System.out.println("Skyline Output:");
        for (List<Integer> point : skyline) {
            System.out.println(point);
        }
    }
}
