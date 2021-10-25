/**
 * Maximum Subarray. We hold a variable to store the sum of contiguous members.
 * If the sum becomes < 0, we set it to 0. The maxSum holds the maximum sum of the contiguous array.
 *
 * Average - O(N) time | O(1) space
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cumSum = 0;

        for(int i=0; i<nums.length; i++) {
            cumSum += nums[i];
            maxSum = Math.max(maxSum, cumSum);

            cumSum = cumSum < 0 ? 0 : cumSum;
        }

        return maxSum;
    }

    /**
      The below approach uses Divide and conquer. We use dfs to get all possible mids. For each of the mids, we calculate the max
      sum of all the left values to that mid and the right max values to the mid. We check whichever is the greatest and return that in the
      merge function. For all the possible max sum values of the mids we keep a track of the max value returned by each mid, and the largest
      is our answer.

      Average - O(NlogN) time | O(1) space
     */
    public int maxSubArrayDAC(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    private int dfs(int[] nums, int i, int j) {
        if(i==j)
            return nums[i];

        int mid = (i+j)/2;
        int left = dfs(nums, i, mid);
        int right = dfs(nums, mid+1, j);

        int merge = merge(nums, mid);
        return Math.max(left, Math.max(right, merge));
    }

    private int merge(int[] nums, int m) {
        int leftMax = Integer.MIN_VALUE;
        int left = 0;
        for(int i=m; i>=0; i--) {
            left += nums[i];
            leftMax = Math.max(leftMax, left);
        }

        int rightMax = Integer.MIN_VALUE;
        int right = 0;
        for(int i=m+1; i<nums.length; i++) {
            right += nums[i];
            rightMax = Math.max(rightMax, right);
        }

        return Math.max(leftMax + rightMax, Math.max(leftMax, rightMax));
    }
}