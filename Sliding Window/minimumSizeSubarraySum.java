/**
 * Sliding Window Concept: Since we have to find a contiguous block of subarray from the given
 * array, and the solution of the problem is supposed to be validated based on the sliding window
 *
 * Average - O(N) time | O(1) space
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        int sum = 0;

        for(int end=0; end<nums.length; end++) {
            sum += nums[end];

            while(sum >= target) {
                minLength = Math.min(minLength, end-start+1);
                sum -= nums[start++];
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}