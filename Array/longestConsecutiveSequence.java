/**
 * Longest Consecutive Sequence. We put the elements in a hashset to access elements in constant time. We iterate over the nums once put in the hashset
 * and check if there exists num-1 in the set. If not, we are at the min element, so we iterate over consecutive elements in the array, keep a count of
 * it.
 *
 * Average - O(N) time | O(N) space
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestConsecutiveLength = 0;
        
        for(int num: nums) {
            set.add(num);
        }
        
        for(int num: set) {
            if(!set.contains(num-1)) {
                int currentLength = 0;
                int currNum = num;
                
                while(set.contains(currNum++)) {
                    currentLength++;
                }
                
                longestConsecutiveLength = Math.max(longestConsecutiveLength, currentLength);
            }
        }
        
        return longestConsecutiveLength;
    }
}