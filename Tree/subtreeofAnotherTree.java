/**
Let's talk in terms of a parent tree and child tree. We check if the child tree is the same as the entire tree or the left subtree or the
right subtree. We check if they're identical or not by running dfs on the two trees.

T - O(S.T)
S - O(logS*logT) ??
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        
        // A null tree will always be a subtree of a non null tree
        if(subRoot == null)
            return true;
        
        // check if the two trees are equal at the respective root levels
        if(helper(root, subRoot))
            return true;
        
        // compare the subtree to the left and the right of the parent tree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean helper(TreeNode node1, TreeNode node2) {
        // if either are null, it will return false, if both are null, it will return true
        if(node1 == null || node2 == null)
            return node1 == node2;
        
        // ensure that the left and right children are also equal if two nodes values are same
        if(node1.val == node2.val)
            return helper(node1.left, node2.left) && helper(node1.right, node2.right);
        
        // it means that either of the two nodes have different children/values
        return false;
    }
}