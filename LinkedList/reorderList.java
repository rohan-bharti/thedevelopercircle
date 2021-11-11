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
* Input: head = [1,2,3,4,5]
* Output: [1,5,2,4,3]
*
* Reorder List. This problem can be broken down into halving the list, reversing the second half and merging the two lists created.
*
* Average - O(N) time | O(1) space
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        // first list head
        ListNode l1 = head;
        // second list head
        ListNode slow = head;
        // second list tail
        ListNode fast = head;
        // first list tail
        ListNode prev = null;

        // use the slow-fast approach to get to the end of the list and get the mid element
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // setting the first list's tail to null
        prev.next = null;

        // reversing the second list
        ListNode l2 = reverse(slow);

        // applying custom logic to merge the two lists
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode tempNext = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tempNext;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        // take one node from first list, pointing its next to the corresponding second list's node
        // when we reach the end of the first list, just append the next of the first list to the remaining second list node
        while(l1!=null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            if(l1Next == null)
                break;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
}