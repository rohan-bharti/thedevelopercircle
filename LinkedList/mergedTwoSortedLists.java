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
 * Merge Two Sorted Lists. We iterate over both the lists, check which node is smaller, and supply the next node in that particular
 * list. At the end when we reach the end, we iterate back recursively to get to get the sorted linked list.
 *
 * Average - O(N+M) time | O(N+M) space
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/**
 * Merge Two Sorted Lists. We iterate over both the lists, check which node is smaller, and populate the new node's next on that
 * basis maintaining the sorted order of the two lists.
 *
 * Average - O(N+M) time | O(1) space
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode head = dummyNode;

        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
            }
            else {
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }

        if(l1 == null) dummyNode.next = l2;
        if(l2 == null) dummyNode.next = l1;

        return head.next;
    }
}