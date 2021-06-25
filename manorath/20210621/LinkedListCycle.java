
/**
 *  Question -> https://leetcode.com/problems/linked-list-cycle
 * 
 * The whol;e Idea is to have a faster moving pointer and a slow moving one. They are bound to intersect at some point if there a loop 
 * 
 *  O(N) time complexity | O(1) Space
 */
public class LinkedListCycle {
    
}

class Solution5 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            
        }
        return true;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
