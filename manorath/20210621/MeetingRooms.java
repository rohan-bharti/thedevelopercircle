import java.util.Arrays;
/**
 * Question: https://leetcode.com/problems/meeting-rooms/
 * 
 * Sort the array and check is start time is lower than ending time for the meeting before.
 * 
 * Time complexity O(nlog(n)) space O(1)
 */
class Solution4 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(int[]a,int[]b)->(Integer.compare(a[0],b[0])));
        for(int i = 1; i <=intervals.length-1;i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
