/**
 * Graph Valid Tree with DFS and memoization. We create an adjacency list to connect the edges with all the neighbors, both ways since it is an
 * undirected graph. We create a hashset to keep a track of unique nodes visited (avoid duplication of visiting same nodes). The set must be equal
 * to the size of the graph. This maintains a check for both connected and cycles in the graph. We use DFS to iterate over the graph nodes.
 *
 * Average - O(N) time | O(N) space
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> connectedVertices = new HashSet<>();

        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(0, adjList, connectedVertices);

        return connectedVertices.size() == n;
    }

    private void dfs(int index, List<List<Integer>> adjList, Set<Integer> seen) {
        if(seen.contains(index))
            return;

        seen.add(index);
        for(int neighbour: adjList.get(index))
            dfs(neighbour, adjList, seen);
    }
}

/**
 * Graph Valid Tree with BFS. We create an adjacency list to connect the edges with all the neighbors, both ways since it is an
 * undirected graph. We create a hashset to keep a track of unique nodes visited (avoid duplication of visiting same nodes). The set must be equal
 * to the size of the graph. This maintains a check for both connected and cycles in the graph. We use BFS to iterate the graph nodes.
 *
 * Average - O(N) time | O(N) space
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> connectedVertices = new HashSet<>();

        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        connectedVertices.add(0);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int neighbour: adjList.get(curr)) {
                if(!connectedVertices.contains(neighbour)) {
                    connectedVertices.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        return connectedVertices.size() == n;
    }
}