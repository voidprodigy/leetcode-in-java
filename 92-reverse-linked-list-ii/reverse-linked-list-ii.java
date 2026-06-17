/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {

        // No reversal needed
        if (head == null || left == right) {
            return head;
        }

        /*
         * Dummy node helps when left = 1
         * because head itself may change.
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        /*
         * Move prev to node just before
         * the left position.
         */
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        /*
         * curr points to first node
         * of reversal section.
         */
        ListNode curr = prev.next;

        /*
         * Reverse nodes using head insertion.
         */
        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            // Remove next from its position
            curr.next = next.next;

            // Insert next after prev
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}