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
 * Same Tree - DFS.
 *
 * Average - O(N) time - N nodes | O(logN) average space since we store all the nodes at one depth, O(N) completely unbalanced tree
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p==null || q==null)
            return false;

        if(p.val != q.val)
            return false;

        boolean leftBranchIdentical = isSameTree(p.left, q.left);
        boolean rightBranchIdentical = isSameTree(p.right, q.right);

        return leftBranchIdentical && rightBranchIdentical;
    }
}

/**
 * Same Tree - BFS.
 *
 * Average - O(N) time - N nodes | O(logN) average space since we store all the nodes at one depth, O(N) completely unbalanced tree
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()) {
            TreeNode currP = queue.poll();
            TreeNode currQ = queue.poll();

            // when we are at the last depth and all left/right are null
            if(currP == null && currQ == null)
                continue;

            if(currP == null || currQ == null)
                return false;

            if(currP.val != currQ.val)
                return false;

            queue.add(currP.left);
            queue.add(currQ.left);
            queue.add(currP.right);
            queue.add(currQ.right);
        }

        return true;
    }
}