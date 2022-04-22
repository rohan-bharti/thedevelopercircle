class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        
        Arrays.fill(cache, -1);
        
        return dfs(nums, cache, 0);
    }
    
    private int dfs(int[] nums, int[] cache, int pos) {
        if(pos >= nums.length)
            return 0;
        
        if(cache[pos] > -1)
            return cache[pos];
        
        int result = Math.max(nums[pos] + dfs(nums, cache, pos+2), dfs(nums, cache, pos+1));
        
        cache[pos] = result;
        return result;
    }
}