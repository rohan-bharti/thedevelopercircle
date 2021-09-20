import java.util.*;

/**
 * Use backtracking to iterate over the sample space and generate the possible combinations
 * using the given input and correspondingly update them to the given List.
 * 
 * Time Complexity: NPK = N!/(N-k)! Time | O(N!) Space
 */
class SolutionP {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums);
        return result;
    }
    
    private static void dfs(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if(nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(current.contains(nums[i]))
                continue;
            
            current.add(nums[i]);
            dfs(result, current, nums);
            current.remove(current.size() - 1);
        }
    }
}