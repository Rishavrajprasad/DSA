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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallptr = small;
        ListNode largeptr = large;
        while (head != null) {
            if (head.val < x) {
                smallptr.next = head;
                smallptr = smallptr.next;
            } else {
                largeptr.next = head;
                largeptr = largeptr.next;
            }
            head = head.next;
        }
        smallptr.next = large.next;
        largeptr.next = null;
        return small.next;
    }
}
