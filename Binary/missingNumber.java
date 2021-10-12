/**
 * Missing Number. The xor of a number with itself results in 0. For an array [0,1,2,3.....a(n-2), a(n-1)], the xor operation would look like
 * (0^1^2^3^...^a(n-2)^a(n-1))^(0^1^2....^a(n-2)^a(n-1)^n).
 * 
 * Average - O(n) time | O(1) space
 */
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        
        return missing;
    }
}