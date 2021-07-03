import java.util.*;

/**
 * We sort the array on the basis of the first index of the intervals and then check if the second index of an interval (ending time)
 * is less than the first index if the next interval (starting time), if we find such a case, the means there is an overlap
 * between the two meetings and hence, we return false
 * 
 * Average - O(NlogN) time | O(1) space (N is the number of meetings)
 */
class SolutionCAM {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean canAttend = true;
        
        if(intervals.length == 0 || intervals == null)
            return canAttend;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0])
                canAttend = false;
        }
        
        return canAttend;
    }
}