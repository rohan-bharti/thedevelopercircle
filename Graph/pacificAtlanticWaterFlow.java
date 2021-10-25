/**
 * Pacific Atlantic Water Flow with DFS and memoization. We start at the cornermost edges reachable to Atlantic and Pacific oceans. We come inwards via
 * DFS to check if the water can flow from those nodes to the respective oceans. Once we have the reachable indices for Atlantic and Pacific oceans
 * respectively, we can check indices reachable to both the oceans and that is the result.
 *
 * Average - O(M.N) time | O(M.N) space
 */
class Solution {
    private static int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return result;

        int rowNum = heights.length;
        int colNum = heights[0].length;

        // arrays to check respective ocean's reachability
        boolean[][] pacificReachable = new boolean[rowNum][colNum];
        boolean[][] atlanticReachable = new boolean[rowNum][colNum];

        // start from the nodes reachble to both the oceans row-wise and column-wise
        // and move inwards to find other reachable indices
        for(int i=0; i<heights.length; i++) {
            dfs(i,0,heights,pacificReachable);
            dfs(i,heights[0].length-1,heights,atlanticReachable);
        }
        for(int i=0; i<heights[0].length; i++) {
            dfs(0,i,heights,pacificReachable);
            dfs(heights.length-1,i,heights,atlanticReachable);
        }

        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] reachable) {
        reachable[i][j] = true;
        for(int[] dir: dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // check if we escape the boundaries
            if(newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length)
                continue;

            // check if we have already visited the node successfully
            if(reachable[newRow][newCol])
                continue;

            // since we are coming inwards, if the height of the node is less that means the water can't flow
            if(heights[newRow][newCol] < heights[i][j])
                continue;

            dfs(newRow, newCol, heights, reachable);
        }
    }
}