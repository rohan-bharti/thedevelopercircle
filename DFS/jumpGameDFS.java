/**
 * Jump Game with Backtracking. We check from each of the positions in the array, the max distance
 * we can jump from that index adn see if we can reach the last index,=.
 * 
 * Average - O(2^N) time - for each cell we check if we can reach it or not | O(N) recursion space
 */
class Solution {
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }
    
    private boolean jump(int[] nums, int index) {
        if(index == nums.length-1)
            return true;
        
        int maxIndexJump = Math.min(index + nums[index], nums.length - 1);
        // for(int pos=maxIndexJump; pos>index; pos--) Slight optimization
        for(int pos=index+1; pos<=maxIndexJump; pos++) {
            if(jump(nums, pos))
                return true;
        }
        
        return false;
    }
}