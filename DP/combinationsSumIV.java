/**
 * Combinations Sum IV. Top Down Approach. We check how many possible combinations we can generate to get the sum up to the target and
 * store that in the result variable.
 *
 * Average - O(N.T) time - N since each caculation will be once and for each calculation the wort we could go up to is T recursion calls |
 * O(T) space for memoized array
 */
class Solution {
    // cache
    Integer[] memo;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums); // minor optimization
        memo = new Integer[target + 1]; // index being the target, the value holds the number of combinations
        return combinations(nums, target);
    }

    private int combinations(int[] nums, int remainder) {
        if(remainder == 0)
            return 1; // a valid combination

        if(memo[remainder] != null)
            return memo[remainder];

        int result = 0;
        for(int num: nums) {
            if(num <= remainder)
                result += combinations(nums, remainder - num); // storing the num of possible results
            else
                break; // minor optimization
        }

        memo[remainder] = result;
        return result;
    }
}

/**
 * Combinations Sum IV. Bottom Up Approach. We check how many possible combinations we can generate to get the sum up to the target and
 * store that in a dp array.
 *
 * Average - O(N.T) time - N is the nums and T is target| O(T) space for memoized array
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums); // minor optimization

        int[] dp = new int[target+1]; // index holds the sum and value holds the number of ways to compute the sum
        dp[0] = 1; // empty set

        for(int sum = 1; sum <= target; sum++) {
            for(int num: nums) {
                if(num <= sum)
                    dp[sum] += dp[sum - num];
                else
                    break; // minor optimization
            }
        }

        return dp[target];
    }
}