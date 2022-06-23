/**
The preorder goes root, left, right. The inorder goes left, root, right. We fetch the root at every step from the preorder and keep a counter
incrementing as we go through. Once we are at a root, we get the indicies of the immediate left and right nodes for the root from the inorder
array. To get the left and right children from the inorder, we create a map for all the elements to their respective indicies. We recursively call
this operation for all the nodes in the preorder array and for each of those nodes create the links for left and right children.

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
    int preorderIndex;
    Map<Integer, Integer> inorderElementToIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return null;
        
        preorderIndex = 0;
        inorderElementToIndex = new HashMap<>();
        
        for(int i=0; i<preorder.length; i++) {
            inorderElementToIndex.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right) {
        if(left > right)
            return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = helper(preorder, left, inorderElementToIndex.get(rootValue) - 1);
        root.right = helper(preorder, inorderElementToIndex.get(rootValue) + 1, right);
        
        return root;
    }
}