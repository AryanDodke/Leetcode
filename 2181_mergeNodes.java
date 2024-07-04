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

/*
 * 0 1 2 3 0 4 5 0 6 0
 * currently head = 9
 * if head.val = 0 {
 * add curr.val }
 * return original then
 */

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode original = head;
        ListNode curr = head.next;
        int temp = 0;
        while (curr != null) {
            if (curr.val == 0) {
                head.val = temp;
                temp = 0;
                if (curr.next != null) {
                    head = head.next;
                }
            }
            temp += curr.val;
            curr = curr.next;
        }
        head.next = null;
        return original;
    }
}