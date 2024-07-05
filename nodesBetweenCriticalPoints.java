/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int min = Integer.MAX_VALUE;
        int maxima = -1;
        int minima = -1;
        int index = 0;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            if (curr.val > prev.val && curr.val > curr.next.val || curr.val < prev.val && curr.val < curr.next.val) {
                if (maxima == -1) {
                    maxima = index;
                }
                if (minima != -1) {
                    min = Math.min(min, index - minima);
                }
                minima = index;
            }
            prev = curr;
            curr = curr.next;
            ++index;
        }
        if (min == Integer.MAX_VALUE) {
            return new int[] { - 1, -1};
        }

        return new int[] { min , minima - maxima };
    }
}