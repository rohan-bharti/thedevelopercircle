/**
 * Non-overlapping Intervals. The idea is to sort the intervals by their starting point. Once that is done, we iterate over the elements
 * and keep a track of the ending index. The ending index is supposed to be the minimum value to avoid larger overlaps among the intervals.
 *
 * Average - O(NlogN) time | O(1) space
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));

        int result = 0;
        int end = intervals[0][1];

        for(int i=1; i<intervals.length; i++) {
            // check if an overlap exists
            if(intervals[i][0] < end) {
                // smaller end value since we want to avoid overlaps. The bigger the end value,
                // the more chances that it will end up overlapping with other intervals.
                end = Math.min(end, intervals[i][1]);
                result++;
            }
            else
                end = intervals[i][1];
        }

        return result;
    }
}
