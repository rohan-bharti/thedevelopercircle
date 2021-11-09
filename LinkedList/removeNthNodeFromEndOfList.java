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

/**
* Remove Nth Node From End of List. This problem can be done in one or two passes. One pass would mean iterating till the end to find
* the length and then setting the moving pointer to the head and go up till n and make the modifications. Two pass is faster since
* we use two pointers (fast and slow). The fast pointer is supposed to move uptil n steps, to create the required gap between the fast and the slow pointers.
* We then move both the pointers, and when we reach the end, we make the modification to get rid of the nth element from the end.
*
* Average - O(N) time | O(1) space
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // handle corner cases like a single element in the linked list
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        int i=0;
        while(i<n) {
            fast = fast.next;
            i++;
        }

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }
}