import java.util.ArrayList;
import java.util.List;


/**
 * Question: https://leetcode.com/problems/permutations/
 * There are N! permutations possible for a list of numbers with N distinct characters
 * can get there by swapping all numbers.
 * 
 * Because this there are N distinct integers in the list, leaf node can be taken in as is. If there were any repetetions - could have used a set 
 * can also add all non leaf nodes but but would def need a set in that case - we have to reach the leafs anyways so it makes more sense to do it this way.
 * 
 * ~ O(N!) time and space complexity.
 * 
 * A great post on leetcode discussing approach to backtracking questions in java: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Permutations {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int nums[] = {1,2,3};
        System.out.println(solution.permute(nums));
    }
    
}

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permuteList = new ArrayList<List<Integer>>();
        recursePermute(nums,permuteList,0);
        return permuteList;
    }
    
    public void recursePermute(int[] nums,List<List<Integer>> permuteList, int left) {
        //edge control, add to the list at the leaf of recursion tree.
        if(left == nums.length-1) {
            List<Integer> permutation = new ArrayList<Integer>();
            for(int i =0;i <= nums.length-1;i++) {
                permutation.add(nums[i]);
            }
            permuteList.add(permutation);
            return;
        }
        
        
        for(int right = left;right<= nums.length-1;right++) {
            // Swap
            swap(nums,left,right);
            recursePermute(nums,permuteList,left+1);
            // Unswap
            swap(nums,left,right);
        }   
        
    }
    
    public void swap(int[] nums,int left, int right) {
        // swap left and right 
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
    }
    
    
}
