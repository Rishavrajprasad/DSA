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
    public int pairSum(ListNode head) {

        //Base Case ke liye hai 
        if(head == null)
        return 0;
        ListNode temp = head;

        // int count = 0;
        // int max = 0;
        // while(temp !=null)
        // {
        //     count++;
        //     temp = temp.next;
        // }
        // temp = head;
        // if(count == 2)
        // return head.val+head.next.val;
        
        // Stack<Integer> stack = new Stack<>();
        // while(temp!=null)
        // {
        //     stack.push(temp.val);
        //     temp =temp.next;
        // }
        // temp = head;
        // for(int i =0;i<count/2;i++)
        // {
        //     int sum = stack.peek()+temp.val;
        //     stack.pop();
        //     max= Math.max(sum,max);
        //     temp=temp.next;
        // }
        // return max;


        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode prev= null;
        ListNode nextNode = null;
        while(mid !=null)
        {
            nextNode = mid.next;
            mid.next = prev;
            prev     = mid;
            mid      = nextNode;
        }

        int result = 0;
        ListNode curr = head;

        while(prev != null)
        {
            if(result<(curr.val+prev.val))
            {
                result = curr.val+prev.val;
            }
            curr = curr.next;
            prev = prev.next;
        }

        return result;
    }
}
