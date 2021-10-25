import java.util.*;

class paintFence {
    /**
     * Bottom up Dynamic Programming Approach. DP because we have to calculate the number of ways to paint a fence
     * and second, each transition is dependent on the prev one. In this case, there cannot be three or more consecutive posts with the same color,
     * hence we keep a track of what we painted the prev fences.
     *
     * Average - O(N) time | O(N) space (N is the number of fences)
     */
    public int numWaysBUDP(int n, int k) {
        // can only be painted one way
        if(n==1)
            return k;
        // first fence can be painted k ways, and the second as well can be painted k ways. (No restrictions)
        if(n==2)
            return k*k;

        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;

        for(int i=3; i<=n; i++) {
            // either paint the ith fence a diff color
            // or paint the ith fence the same color as i-1th fence. But we have to make sure that
            // i-2 is a diff color.
            dp[i] = (k-1)*dp[i-1] + 1*(k-1)*dp[i-2];
        }

        return dp[n];
    }

    /**
     * Top Down Dynamic Programming Recursion with Memoization. DP because we have to calculate the number of ways to paint a fence
     * and second, each transition is dependent on the prev one. In this case, there cannot be three or more consecutive posts with the same color,
     * hence we keep a track of what we painted the prev fences.
     *
     * Average - O(N) time because of memoization | O(N) space for Recursion stack (N is the number of fences)
     */
    class numWaysTDDP {
        Map<Integer, Integer> map = new HashMap<>();

        private int computeWays(int n, int k) {
            if(n==1)
                return k;
            if(n==2)
                return k*k;

            if(map.containsKey(n)) {
                return map.get(n);
            }

            map.put(n, ((k-1)*computeWays(n-1, k) + 1*(k-1)*computeWays(n-2, k)));
            return map.get(n);
        }

        public int numWays(int n, int k) {
            return computeWays(n, k);
        }
    }
}