import java.util.*;

/**
 * Two Sum. We store the values in a hashmap and check if the difference of the target and the current values exists in the array.
 * This would give us the two numbers that add to the given target.
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

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int counterPart = target - nums[i];
            
            if(map.containsKey(counterPart) && map.get(counterPart) != i) {
                return new int[] { i, map.get(counterPart) };
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return null;
    }
}