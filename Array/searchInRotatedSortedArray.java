/**
 * Search in Rotated Sorted Array. We know the array is sorted in two parts after rotation. By doing binary search we are trying to analyze
 * which part might contain the target.
 *
 * Average - O(logN) time | O(1) space
 */
class  searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[start]) { //check if mid is the rotated subarray
                if(target < nums[mid] && target >= nums[start]) //check if the target lies in the rotated part
                    end = mid-1;
                else
                    start = mid+1;
            } else { //check if the mid is in the 'before reverted' array
                if(target > nums[mid] && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }

        return -1;
    }
}