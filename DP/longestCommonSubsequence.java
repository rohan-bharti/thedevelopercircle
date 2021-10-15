/**
 * Longest Common Subsequence. The idea is to compare smaller portions of the two strings to create a memoized table to further grow towards
 * the bigger problems.
 *
 * Time - O(M.N) | Space - O(M.N)
 */
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // The dp represents both the strings places on a 2-D array char by char
        // The row/col index '0' is for an empty string ""
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i==0 || j==0) {
                    // lcs("",anything) || lcs(anything, "") will be 0 since no matching characters
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    // lcs("aa","za") = 1 + lcs("a", "z") -> which is the diagonally left element
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    // lcs("az", "bz") = Math.max(lcs("a", "bz"), lcs("az", "b"))
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n]; 
    }
}