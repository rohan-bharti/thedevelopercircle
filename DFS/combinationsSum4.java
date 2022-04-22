class Solution {
    Map<Integer, Integer> cache = new HashMap<>(); // stores the target sum along with the number of ways to get the target sum
    
    public int combinationSum4(int[] nums, int target) {
        if(target == 0)
            return 1;
        
        if(cache.containsKey(target))
            return cache.get(target);
        
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            if(target - nums[i] >= 0)
                result += combinationSum4(nums, target - nums[i]);
        }
        
        cache.put(target, result);
        return result;
    }
}