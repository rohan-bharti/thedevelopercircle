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
* Invert Binary Tree - DFS. We iterate over the nodes of the tree. At every depth we swap the left and the right.
*
* Average - O(N) time - N nodes | O(depth) space at the max.
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }
}

/**
* Invert Binary Tree - DFS. We iterate over the nodes of the tree. At every depth we swap the left and the right.
*
* Average - O(N) time - N nodes | O(N) space for the queue.
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;

            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }

        return root;
    }
}