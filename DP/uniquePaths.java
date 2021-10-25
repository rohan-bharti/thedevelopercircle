/**
 * Unique Paths with DFS. We start at (0,0) and see how many ways can we reach the end of the matrix (m-1, n-1).
 * We can only move downwards or to the right. To avoid redundancy we memoize the result as we go across different cells
 * in the matrix.
 *
 * Average - O(M*N) time - each cell will be visited once | O(M*N) space for memo array
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        //init with -1 value
        for(int[] arr : memo) {
          Arrays.fill(arr, -1);
        }

        return calculateWays(0, 0, m, n, memo);
    }

    private int calculateWays(int x, int y, int m, int n,int[][] memo) {
        if(x == m-1 || y == n-1)
            return 1;

        if(memo[x][y] != -1)
            return memo[x][y];

        if(x < m-1 && y < n-1) {
            memo[x][y] = calculateWays(x+1, y, m, n, memo) + calculateWays(x, y+1, m, n, memo);
            return memo[x][y];
        }

        return 0;
    }
}

/**
 * Unique Paths with DP. We initialize the first row and col to 1 since for the first row and col, we can only move in 1 direction.
 * (right and downwards).
 *
 * Average - O(M*N) time - each cell will be visited once | O(M*N) space for memo array
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }

        for(int j=0; j<n; j++) {
            dp[0][j] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}