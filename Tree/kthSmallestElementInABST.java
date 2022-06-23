/**
We do an inorder traversal because that helps us give the elements of a BST in an increasing order. To find the kth smallest element,
one way is to keep a track of running smallest index and its corresponding element. When we hit the kth index, we stop traversing and return that
element.

T - O(k)
S - O(k)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // hold the kth index and its corresponding element
        int[] nums = new int[2];
        
        helper(root, k, nums);
        return nums[1];
    }
    
    private void helper(TreeNode node, int k, int[] nums) {
        if(node == null)
            return;
        
        helper(node.left, k, nums);
        if(++nums[0] == k) {
            nums[1] = node.val;
            return;
        }
        
        helper(node.right, k, nums);
    }
}