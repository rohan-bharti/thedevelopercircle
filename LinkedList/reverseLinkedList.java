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
 * Reverse Linked List. Recursive Approach. The idea is to iterate over the nodes until we reach a node which has its next/itself as null which implies
 * that we have reached the last node. The last node alone itself is a reversed linkedlist. We then recurse backwards to add the nodes
 * one by one to it in reverse order.
 *
 * Average - O(N) time | O(N) space recursion stack
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode reversedLinkedListNode = reverseList(head.next);

        // let's take last two nodes [4 -> 5], the head is on 4, we point the 4.next(5).next to 4 which implies [4 <- 5]
        head.next.next = head;
        // set the current head's next to null because it will be updated in the next recursion call
        head.next = null;
        return reversedLinkedListNode;
    }
}

/**
 * Reverse Linked List. Iterative Approach. We iterate over the nodes and take two pointers prev and curr. The idea is to
 * point the next of curr to prev until we reach the last node. We update the two pointers as we traverse the linked list.
 *
 * Average - O(N) time | O(1) space
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        return prev;
    }
}