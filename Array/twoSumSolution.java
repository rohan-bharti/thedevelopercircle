import java.util.*;

/**
 * Two Sum. We store the values in a 
 * 
 * Average - O(N) time | O(N) space
 */
class twoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsIndices.containsKey(target - nums[i])) {
                int index1 = numsIndices.get(target - nums[i]);
                int index2 = i;
                return new int[] { index1, index2 };
            }

            numsIndices.put(nums[i], i);
        }

        return null;
    }
}