/**
Great tree question to understand in-order DFS and serialization/deserialization. We use a constant string for delimiter and null values. 
We traverse the tree using DFS and created an encoded string for serialization. 
For deserialization, we take the encoded string, split the string into separate Strings using the defined delimiter 
and add all of that into a queue because we need to process them in a FIFO manner. 
We use the queue to poll elements and then again using DFS mechanism create tree nodes and have the structure ready.

T - O(N)
S - O(N)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String DELIMITER = ",";
    private String NULL = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return NULL + DELIMITER;
        
        String leftChildString = serialize(root.left);
        String rightChildString = serialize(root.right);
        
        return root.val + DELIMITER + leftChildString + rightChildString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(DELIMITER)));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        String value = queue.poll();
        
        if(value.equals(NULL))
            return null;
        
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        newNode.left = helper(queue);
        newNode.right = helper(queue);
        
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));