import java.util.*;

/**
 * Subsets: requires to take one element at a time, then two, up till the length of the incoming
 * int array. The point is to generate the power set of the given integers.
 * 
 * Average - O(2^N) time | O(N) space
 */
class SolutionS {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int index, int[] nums) {
        if(current.size() > nums.length)
            return;
        
        result.add(new ArrayList<>(current));
        
        for(int i=index; i<nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, i+1, nums);
            current.remove(current.size() - 1);
        }
    }
}