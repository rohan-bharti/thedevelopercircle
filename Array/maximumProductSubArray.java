/**
 * Maximum Product Subarray. The idea is to iterate through the array, keep a track of the current Maximum Prod. We define a variable named
 * negProd which keeps a track of the minimum negative value possible because two negatives make a positive. The current max prod also multiplies
 * the negProd with the current nums[i] to check if the maxProduct value has changed.
 * 
 * Average - O(N) time | O(1) space
 */
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int prod, negProd, maxProd;
        prod = negProd = maxProd = nums[0];
        int currProd = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            currProd = prod*nums[i];
            //holds the max product till i index
            prod = Math.max(nums[i], Math.max(currProd, negProd*nums[i]));
            //holds the minimum negative value till the current i index
            negProd = Math.min(nums[i], Math.min(currProd, negProd*nums[i]));

            maxProd = Math.max(maxProd, prod);
        }

        return maxProd;
    }
}