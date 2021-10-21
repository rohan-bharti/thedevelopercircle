/**
 * Jump Game with DP. Bottom Up DP.
 *
 * Average - O(N^2) time | O(N) recursion space
 */
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<=nums[i]; j++) {
                if(dp[i]) {
                    if(i+j == nums.length-1)
                        return true;
                    else {
                        dp[i+j] = true;
                    }
                }
            }
        }

        return false;
    }
}

/**
 * Jump Game with DP. Bottom Up DP.
 *
 * Average - O(N^2) time | O(N) recursion space
 */
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for(int i=nums.length-2; i>=0; i--) {
            int maxIndexJump = Math.min(nums[i] + i, nums.length - 1);

            for(int j=i+1; j<=maxIndexJump; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

/**
 * Jump Game with DP. Top Down DP.
 *
 * Average - O(N^2) time | O(N) recursion space
 */
class Solution {
    int[] memo;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        memo[nums.length - 1] = 1;

        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int index) {
        if(memo[index] != 0) {
            if(memo[index] == 1)
                return true;
            else
                return false;
        }

        int maxIndexJump = Math.min(index + nums[index], nums.length - 1);

        for(int pos = maxIndexJump; pos > index; pos--) {
            if(jump(nums, pos)) {
                memo[index] = 1;
                return true;
            }
        }

        memo[index] = -1;
        return false;
    }
}