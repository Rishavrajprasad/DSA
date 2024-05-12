/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // *********BRUTE FORCE****************
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode temp = head;
        // while(temp != null && temp.next != null)
        // {
        //     if(set.contains(temp))
        //     {
        //         return temp;
        //     }
        //     else
        //     {
        //         set.add(temp);
        //         temp = temp.next;
        //     }
        // }
        // return null;

        //  Two Pointers Slow and Fast;
         if(head == null || head.next == null)
         return null;

         ListNode slow = head;
         ListNode fast = head;

         while(fast != null && fast.next != null)
         {
            slow= slow.next;
            fast = fast.next.next;

            if(slow == fast)
            break;
         }
         if(slow != fast)
         return null;
         
         ListNode temp = head;
         while(temp != slow)
         {
            temp = temp.next;
            slow = slow.next;
         }
         return temp;
    }

}
