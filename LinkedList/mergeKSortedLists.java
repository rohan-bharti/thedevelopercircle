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
* Merge K Sorted Lists. We create a Priority Queue to keep a track of the min node of all the head nodes present in the heap.
* The idea is to poll the queue to get the min node and add that to our result linkedlist.
*
* Average - O(2*(nlogK)) time because insert/deletion operation for a node in a heap would be logk, and we'll be doing
* that N times, N being the total number of elements in the k lists | O(n) space for the final linked list and O(k) for the PQ
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        // Structure the min heap and define the custom comparator for the ListNode datatype
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            lists.length,
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if(o1.val < o2.val)
                        return -1;
                    else if(o1.val > o2.val)
                        return 1;
                    else
                        return 0;
                }
            }
        );

        // Add the heads of all the incoming linked list
        for(ListNode head: lists) {
            if(head!=null)
                queue.add(head);
        }

        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;

        // Polling the queue and appending the result
        while(!queue.isEmpty()) {
            ListNode smallestNode = queue.poll();

            head.next = smallestNode;
            head = smallestNode;

            if(smallestNode.next != null)
                queue.add(smallestNode.next);
        }

        return dummyNode.next;
    }
}