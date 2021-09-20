/**
 * Climbing Stairs Recursion solution memoized; top down
 * Dynamic Programming.
 */
class SolutionCSRM {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        //specify the base case outside the recursion method
        memo[0] = 1;
        memo[1] = 1;
        
        return recurse(n, memo);
    }
    
    private int recurse(int n, int[] memo) {
        // check if memoized solution exists
        if(memo[n] > 0)
            return memo[n];
        
        // compute the number of ways
        int numberOfWays = recurse(n-1, memo) + recurse(n-2, memo);
        memo[n] = numberOfWays;
        return numberOfWays;
    }
}