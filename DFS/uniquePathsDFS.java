/**
 * We use DFS to iterate through various possible paths. Each cell holds the number of ways that particular
 * cell can be reached. Once we get to a cell again, we return the number of paths previously calculated for that cell.
 * 
 * Time Complexity: ~ Time | O(MxN) Space
 */
class uniquePathsDFS {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(0, 0, m, n, memo);
    }
    
    private int dfs(int x, int y, int m, int n, int[][] memo) {
        if(x<0 || x>=m || y<0 || y>=n)
            return 0;
        
        if(memo[x][y] != 0)
            return memo[x][y];

        if(x == m-1 && y == n-1) {
            return 1;
        }
        
        memo[x][y] = dfs(x, y+1, m, n, memo) + dfs(x+1, y, m, n, memo);
        return memo[x][y];
    }
}
