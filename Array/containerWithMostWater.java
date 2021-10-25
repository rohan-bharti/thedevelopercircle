/**
 * Container With Most Water. We use the two pointer approach to get the max area. We iterate over the array
 * to find the max possible height and max possible breadth which would result in the max area. We move forward and backward
 * with two pointers, calculate the possible area with diff combinations and keep a track of the max area possible.
 *
 * Average - O(N) time | O(1) space
 */
class Solution {
    public int maxArea(int[] height) {
        int start=0, maxArea=0;
        int end = height.length - 1;

        while(start < end) {
            maxArea = Math.max(Math.min(height[start], height[end])*(end-start), maxArea);

            if(height[start] > height[end])
                end--;
            else
                start++;
        }

        return maxArea;
    }
}