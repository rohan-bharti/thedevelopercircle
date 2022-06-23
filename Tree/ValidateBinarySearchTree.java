/**
BST is a tree a node's value must be greater than to all the nodes to the left and less than all the nodes to the right.
We perform DFS to go through the tree and keep two pointers (low and high) which gets updated recursively to ensure
that a node's value doesn't break the conditions. If a node's value in the tree violates these rules, we return false.

T - O(N)
S - O(N)
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long left, long right) {
        if(root == null)
            return true;
        
        if(!(root.val > left && root.val < right))
            return false;
        
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}