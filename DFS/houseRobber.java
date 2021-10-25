/**
 * We start from the 0th house. When at a certain house, we either choose the
 * next house or the gold from the current and next to next house since we
 * cannot rob two adjacent houses.
 *
 * Average - O(N) time | O(N) Space
 */
class houseRobber {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return robFrom(0, nums, memo);
    }

    private int robFrom(int house, int[] nums, int[] memo) {
        if (house >= nums.length) {
            return 0;
        }

        if (memo[house] > -1)
            return memo[house];

        int result = Math.max(robFrom(house + 1, nums, memo), robFrom(house + 2, nums, memo) + nums[house]);

        memo[house] = result;
        return result;
    }
}