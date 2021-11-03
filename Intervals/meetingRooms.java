import java.util.*;

/**
 * Meeting Rooms. We sort the array on the basis of the first index of the intervals and then check if the second index of an interval (ending time)
 * is less than the first index if the next interval (starting time), if we find such a case, the means there is an overlap
 * between the two meetings and hence, we return false
 *
 * Average - O(NlogN) time | O(1) space (N is the number of meetings)
 */
class SolutionCAM {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1])
                return false;
        }

        return true;
    }
}