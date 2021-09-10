import java.util.*;

/**
 * We compute the number of possible combinations to see if by summing them up we can get to the target
 * value as supplied in the function.
 * 
 * Average - O(2^N) time | recursion stack - space
 */
class SolutionCS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<Integer>(), candidates, target, 0);
        return combinations;
    }
    
    private void backtrack(List<List<Integer>> combinations, List<Integer> current, int[] candidates, int target, int index) {
        if(target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=index; i<candidates.length; i++) {
            if(target<0)
                break;
            current.add(candidates[i]);
            backtrack(combinations, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}
