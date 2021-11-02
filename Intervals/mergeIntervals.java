/**
 * Merge Intervals. We sort the intervals based on the starting time. We check for the two successive intervals, if the ending of the first
 * interval is greater than the start of the next interval, we merge by changing the end of the first interval. If that is not the case,
 * we update the currInterval value and push it to the list.
 *
 * Average - O(NlogN) time | O(N) space
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (i,j) -> Integer.compare(i[0], j[0]));

        List<int[]> result = new ArrayList<>();

        int[] currInterval = intervals[0];
        result.add(currInterval);

        for(int[] interval: intervals) {
            // if currInterval(end) > nextInterval(start) => merge the two intervals
            if(currInterval[1] >= interval[0])
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            else {
                currInterval = interval;
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}