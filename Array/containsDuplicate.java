/**
 * Contains Duplicate. We put the elements in a hashtable. Check if the element is already
 * present in the hashtable or not and return true/false appropriately.
 *
 * Average - O(N) time | O(1) space
 */
class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]))
                return true;

            set.add(nums[i]);
        }

        return false;
    }
}