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

/**
 * Maximum Depth of Binary Tree - BFS. We iterate over the nodes of the tree. At every depth we check all the nodes of the trees and iterate the depth as we
 * go along.
 *
 * Average - O(N) time - N nodes | O(N) space
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode currNode;
        while(!queue.isEmpty()) {
            result += 1;
            int size = queue.size();

            // we check all the children at the current depth that we are at
            for(int i=0; i<size; i++) {
                currNode = queue.poll();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
        }

        return result;
    }
}

/**
 * Maximum Depth of Binary Tree - DFS.
 *
 * Average - O(N) time - N nodes | O(N) space
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}