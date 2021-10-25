import java.util.Arrays;

/**
 * Longest Increasing Subsequence. We iterate over the elements of the given array, check if there
 * exists a previous element which is smaller than the current element and keep a track of the length
 * of the element so far.
 *
 * Average - O(N^2) time | O(N) space
 */
class SolutionLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1)
            return 1;

        int[] dp = new int[nums.length];
        int longestLength = 0;

        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            longestLength = Math.max(longestLength, dp[i]);
        }

        return longestLength;
    }
}