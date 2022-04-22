class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1; //For having target as 0, there is one way by NOT selecting any number from nums
            
        for(int currTarget = 1; currTarget <= target; currTarget++) {
            for(int num: nums) {
                if(currTarget - num >= 0)
                    dp[currTarget] += dp[currTarget - num];
            }
        }
        
        return dp[target];
    }
}