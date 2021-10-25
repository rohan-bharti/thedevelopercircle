/**
 * We have to find the number of cells labeled as 1 and do not have a pairing 1 cell directly/indirectly to the border
 * of the grid. We can run DFS on the bordering pairs and mark corresponding connected cells to the border 1 cells to 0.
 * Then we can simply take a count of the remaining cells.
 *
 * Time - O(2^M) M being the border 1 cells | Space - O(1) in place
 */
class SolutionNOE {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int numEnclaves(int[][] grid) {
        int numOfCells = 0;
        int m = grid.length;
        int n = grid[0].length;

        if(grid == null || grid.length == 0)
            return numOfCells;

        //marking the 1 cells in first row and last row to 0
        for(int i=0; i<n; i++) {
            if(grid[0][i] == 1) dfs(grid, 0, i);
            if(grid[m-1][i] == 1) dfs(grid, m-1, i);
        }

        //marking the 1 cells in first col and last col to 0
        for(int i=0; i<m; i++) {
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][n-1] == 1) dfs(grid, i, n-1);
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    numOfCells ++;
                }
            }
        }

        return numOfCells;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        for(int[] dir: dirs) {
            dfs(grid, i+dir[0], j+dir[1]);
        }
    }
}