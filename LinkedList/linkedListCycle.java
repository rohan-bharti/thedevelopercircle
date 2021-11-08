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

/**
 * Linked List Cycle. We go through the linkedlist and add the nodes to a hash table. Along with traversing, we check if the
 * next node is already present in the hashtable or not, based on which we return the result.
 *
 * Average - O(N) time | O(N) space
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
            head = head.next;
        }
        return false;
    }
}

/**
 * Linked List Cycle. We take two pointers - slow and fast. The idea is to move one pointer faster and if a cycle exists,
 * the head.next.next will be equal to the two steps preceeding node which is stored via the slow pointer.
 *
 * Average - O(N) time | O(1) space
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}