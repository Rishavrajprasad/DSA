// class Solution {
    
//     // Helper method to find the length of the linked list
//     private int findLength(ListNode head) {
//         int length = 0;
//         ListNode current = head;
        
//         while (current != null) {
//             length++;
//             current = current.next;
//         }
        
//         return length;
//     }
    
//     public ListNode swapNodes(ListNode head, int k) {
//         // Find the length of the linked list
//         int length = findLength(head);
        
//         // Calculate position of kth node from start (1-based index)
//         int k1 = k;
//         ListNode temp1 = head;
//         while (k1 > 1) {
//             temp1 = temp1.next;
//             k1--;
//         }
        
//         // Calculate position of kth node from end (1-based index)
//         int k2 = length - k + 1;
//         ListNode temp2 = head;
//         while (k2 > 1) {
//             temp2 = temp2.next;
//             k2--;
//         }
        
//         // Swap values of temp1 and temp2 nodes
//         int temp = temp1.val;
//         temp1.val = temp2.val;
//         temp2.val = temp;
        
//         return head;
//     }
// }
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = null;
        ListNode p2 = null;
        
        ListNode temp = head;
        
        while (temp != null) {
            if (p2 != null) {
                p2 = p2.next;
            }
            
            k--;
            if (k == 0) {
                p1 = temp;
                p2 = head;
            }
            
            temp = temp.next;
        }
        
        // Swap values of p1 and p2 nodes
        int tempVal = p1.val;
        p1.val = p2.val;
        p2.val = tempVal;
        
        return head;
    }
}
