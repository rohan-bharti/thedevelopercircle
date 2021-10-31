/**
 * Number of Connected Components in an Undirected Graph with DFS. We create an adjacency list to connect the edges with all the neighbors, both ways since it is an
 * undirected graph. We create a hashset to keep a track of unique nodes visited (avoid duplication of visiting same nodes). We run DFS in order to
 * find connected components.
 *
 * Average - O(V for DFS + E for AdjList) time | O(E+V) space
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        int numOfComponents = 0;

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                numOfComponents++;
                dfs(i, adjList, visited);
            }
        }

        return numOfComponents;
    }

    private void dfs(int index, List<List<Integer>> adjList, Set<Integer> visited) {
        visited.add(index);

        for(int neighbour: adjList.get(index)) {
            if(!visited.contains(neighbour)) {
                dfs(neighbour, adjList, visited);
            }
        }
    }
}