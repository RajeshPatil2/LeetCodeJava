package com.leetcode.linkedlist;

public class RotateList {

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k == 0)
			return head;

		ListNode curr = head;
		int length = 1;

		while (curr.next != null) {
			curr = curr.next;
			length++;
		}

		// circular list
		curr.next = head;

		k = k % length;
		int steps = length - k;

		ListNode newTail = head;
		for (int i = 1; i < steps; i++) {
			newTail = newTail.next;
		}

		ListNode newHead = newTail.next;
		newTail.next = null;

		return newHead;
	}
}
