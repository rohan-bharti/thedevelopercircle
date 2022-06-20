/**
 * Binary Tree Level Order Traversal
 *
 * BFS is used for tree traversal level wise. We iterate level by level, take the elements out in each level and append it to the running list.
 *
 * T - O(N) we visit each node exactly once
 * S - O(N) the queue can have N/2 elements at the max
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()) {
            result.add(new ArrayList<>());
            
            int levelLength = queue.size();
            for(int i=0; i<levelLength; i++) {
                TreeNode currNode = queue.poll();
                
                result.get(level).add(currNode.val);
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            
            level++;
        }
        
        return result;
    }
}