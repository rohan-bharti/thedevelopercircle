/**
 * We start from the 0th house. When at a certain house, we either choose the
 * next house or the gold from the current and next to next house since we
 * cannot rob two adjacent houses.
 * 
 * Average - O(N) time | O(N) Space
 */
class houseRobberDP {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // amount of money robbing 0th house
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}