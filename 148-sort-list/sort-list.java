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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find length
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // size = length of sublists to merge
        for (int size = 1; size < n; size *= 2) {

            ListNode prev = dummy;
            curr = dummy.next;

            while (curr != null) {

                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);

                prev.next = merge(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // Split list after 'size' nodes
    private ListNode split(ListNode head, int size) {

        if (head == null) return null;

        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }

        ListNode second = head.next;
        head.next = null;

        return second;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}