/**
 * 3Sum. We need to find all the pairs (excluding duplicates) of 3 integers that sum to 0 in 
 * the given array. We sort the array and use two pointers (start and end) and check if the pair sums to 0.
 * While we are performing the check, we skip over the duplicates. If the sum is less than 0, we inc start to move to
 * higher numbers and if sum is greater than 0, we dec the end pointer to smaller numbers. This is possible because
 * the array has been sorted.
 * 
 * Average - O(N2) time | O(N2 + NlogN) space
 */
class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length <= 2)
            return result;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++) {            
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int start = i+1;
                int end = nums.length - 1;
                
                while(start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while(start < end && nums[start] == nums[start+1]) start++;
                        while(start < end && nums[end] == nums[end-1]) end--;
                        start++;
                        end--;
                    }
                    else if (sum < 0) start++;
                    else end--;
                }   
            }
        }
        
        return result;
    }
}