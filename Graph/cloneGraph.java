/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
 * Clone a graph - BFS. We use a hashmap to map the original node to the duplicate node. It also helps in adding the neighbors of a duplicate node
 * by referencing the (original nodes of) the duplicate neighbors in constant time. We use Queue for processing the nodes in the graph. BFS seems more
 * apt since the idea is to traverse the graph level by level and not go all the way in using DFS.
 *
 * Average - O(N+M) time - N nodes and M edges | O(N) space for hashmap and O(W) space for Queue (W being the width of the graph) Width is the max
 * number of neighbors a node has in the given graph.
 */
class Solution {
    public Node cloneGraph(Node start) {
        if(start == null)
            return null;

        // holds a mapping to a node to its duplicate node
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        map.put(start, new Node(start.val));

        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            List<Node> neighbors = currNode.neighbors;

            for(Node node: neighbors) {
                if(!map.containsKey(node)) {
                    map.put(node, new Node(node.val));
                    queue.add(node);
                }

                // establish a relation from the duplicate of currNode to the duplicate of the neighbor of the currNode
                map.get(currNode).neighbors.add(map.get(node));
            }
        }

        return map.get(start);
    }
}

/**
 * Clone a graph - DFS. We use a hashmap to map the original node to the duplicate node. It also helps in adding the neighbors of a duplicate node
 * by referencing the (original nodes of) the duplicate neighbors in constant time.
 *
 * Average - O(N+M) time - N nodes and M edges | O(N) space for hashmap and O(H) space for Stack (H being the height of the graph)
 */
class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        if(map.containsKey(node))
            return map.get(node);

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        for(Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}