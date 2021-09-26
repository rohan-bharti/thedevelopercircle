/**
 * We use DP to iterate through various possible paths. Each cell holds the number of ways that particular
 * cell can be reached. Once we get to a cell again, we return the number of paths previously calculated for that cell.
 * For the base condition we equate all the cells in the first row and col to 1 because there is only one way to reach the cell.
 * 
 * Time Complexity: O(MxN) Time | O(MxN) Space
 */
class uniquePathsDP {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=0; i<n; i++) {
            dp[0][i] = 1;
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}