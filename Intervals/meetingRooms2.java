/**
 * Meeting Rooms 2. To find the min number of conf rooms based on intervals given. We use a min heap to keep a track of the
 * number of conf rooms. We sort the intervals and add the end time of the first meeting to the Priority Queue, a min Heap to
 * keep the minimum end time on the top.
 *
 * Average - O(NlogN) time for sorting and removing an element from a min heap | O(N) space (N is the number of meetings)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));
        minHeap.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            // If the start time is more than the min end time, then we remove the curr room because it can be used
            // for another meeting with the intervals given.
            if(intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Add/use the same room removed with the new end time.
            minHeap.add(intervals[i][1]);
        }

        // the heap contains the min number of rooms that we might end up moving.
        return minHeap.size();
    }
}

/**
 * Meeting Rooms 2. To find the min number of conf rooms based on intervals given. The intervals can be arranged in diff
 * order, we care only about the start and the end times. We create two arrays containing start and end times; sort them.
 * We have to pointers for start and end, check if the curr meeting end time is greater than the curr start time, which means we'll
 * need a new room. If the curr end time is less than the curr start time, it means that we can end up using the same room.
 *
 * Average - O(NlogN) time for sorting | O(N) space (N is the number of meetings)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        int index = 0;
        for(int[] interval: intervals) {
            startTimes[index] = interval[0];
            endTimes[index] = interval[1];
            index++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int numofRooms = 0;
        for(int startPtr=0, endPtr=0; startPtr<intervals.length; startPtr++) {
            if(endTimes[endPtr] > startTimes[startPtr]) {
                numofRooms++;
            } else {
                endPtr++;
            }
        }

        return numofRooms;
    }
}