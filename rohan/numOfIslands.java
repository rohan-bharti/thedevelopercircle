/**
 * We use DFS to iterate the graph. We take one node and check all of its neighbors. If the neighbors are a '1',
 * we continue to check for the last neighbor to have a 0 around em. Consecutively, as we are searching, we mark
 * the node as a 0, so that we don't double count it. This a graph problem and good to know about it. The standard
 * iteration of a graph happens through a nested for loop.
 * 
 * Time Complexity: O(MxN) Time | O(MxN) Space
 */
class SolutionNOI {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        
        if(grid == null || grid.length == 0)
            return numOfIslands;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1')
                    numOfIslands += dfs(grid, i , j);
            }
        }
        
        return numOfIslands;
    }
    
    private int dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[i].length || grid[i][j] =='0')
            return 0;
        
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        return 1;
    }
}