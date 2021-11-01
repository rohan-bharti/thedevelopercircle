/**
 * Insert Interval. We check the beginnings and endings of the intervals, based on which we decide if we wanna merge the newInterval and how.
 *
 * Average - O(N) time | O(N) space
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
            return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        int index = 0;

        // check if the currInterval(end) < newInterval(start), hence no further action is required
        while(index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }

        // here the newInterval(start) < currInterval(end), hence merging reqd. We do that till the
        // newInterval(end) >= currInterval(start)
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        result.add(newInterval);

        while(index < intervals.length) {
            result.add(intervals[index]);
            index++;
        }

        int[][] resultArray = new int[result.size()][2];

        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}