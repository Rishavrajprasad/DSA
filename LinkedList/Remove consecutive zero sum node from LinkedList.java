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
// class Solution {
//     public ListNode removeZeroSumSublists(ListNode head) {
//         int prefixSum =0;
//         HashMap<Integer, ListNode> map = new HashMap<>();
//         ListNode dummyNode = new ListNode(0);
//         dummyNode.next = head;
//         map.put(0,dummyNode);
//         while(head!=null)
//         {
//             prefixSum+=head.val;
//             if(map.containsKey(prefixSum))
//             {
//                 ListNode start = map.get(prefixSum);
//                 ListNode temp = start;
//                 int sum = prefixSum;
//                 while(temp !=head)
//                 {
//                     temp = temp.next;
//                     sum+=temp.val;
//                     if(temp !=head)
//                     map.remove(sum);
//                 }
//                 start.next = head.next;
//             }
//             else
//             {
//                 map.put(prefixSum,head);
//             }
//             head=head.next;
//         }
//         return dummyNode.next;
//     }
// }

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> mp = new HashMap();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        for(ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            mp.put(sum, node);
        }
        sum = 0;

        for(ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = mp.get(sum).next;
        }
        return dummy.next;
    }
}
