/**
 * Find Minimum in Rotated Sorted Array. Since the array is rotated but sorted, we can use a modified version of Binary Sort.
 * We find the middle, check if the preceding element is greater i.e we have reached the "original" starting point of the array.
 * Else, we check if we are still in the rotated subarray; ie mid > start and mid > end i.e we are yet to reach the original start
 * of the array, hence we move the start to mid+1. Else if we are in a position where the mid is smaller than the start and smaller
 * than the end element, ie we are in the original sorted array but at a pos ahead of the start of the original array. This made sense
 * when I was writing the doc, if it doesn't idgaf. Enjoy.
 * P.S In Sorted Array questions, think of Binary Search.
 * 
 * Average - O(logN) time | O(1) space
 */
class findMinimumInRotatedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            int mid = (start+end)/2;
            
            if(mid>0 && nums[mid-1] > nums[mid])
                return nums[mid]; //found the smallest element in the array
            else if(nums[mid] >= nums[start] && nums[mid] > nums[end])
                start = mid+1; //when middle element is greater than start and greater than the last element
            else
                end = mid-1; //when middle is smaller than the start and less than the last element [7,0,1,2,3]
        }
        
        return nums[start];
    }
}