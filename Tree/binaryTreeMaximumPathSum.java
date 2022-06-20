/**
 * Binary Tree Maximum Path Sum
 *
 * We use DFS to traverse the tree. At each node we make a decision what is the max sum path we can take if we go either left OR right, and that
 * is what the fn pathSum does. We run the pathSum method for both the left and the right children, make a note that we take a math.max with 0, this is because
 * if we get a negative value from either (left or right) OR both, we want to go with (right or left) OR take the value of the parent node itself respectively.
 * While we are traversing all the paths, we keep a running result to compute the value of all the possible valid paths for the nodes, inc the node
 * and its right and left subtrees valid paths.
 *
 * T - O(N) we visit each node exactly once
 * S - O(lgN) the height of the tree
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
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        pathSum(root);
        return result;
    }
    
    private int pathSum(TreeNode node) {
        if(node == null)
            return 0;
        
        int leftChildPathSum = Math.max(0, pathSum(node.left));
        int rightChildPathSum = Math.max(0, pathSum(node.right));
        
        result = Math.max(result, node.val + leftChildPathSum + rightChildPathSum);
        
        return Math.max(leftChildPathSum, rightChildPathSum) + node.val;
    }
}