import java.util.Arrays;

public class hw7 {
    public int minMeetingRooms(int[][] intervals) {
        int[][] events = new int[intervals.length * 2][];
        
        // fill events array
        int index = 0;
        for (int[] interval : intervals) {
            events[index++] = new int[]{interval[0], 1}; // Start of a job, +1 server needed
            events[index++] = new int[]{interval[1], -1}; // End of a job, -1 server released
        }

        // sort events by start time
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int maxServers = 0, activeServers = 0;

        for (int[] event : events) {
            activeServers += event[1]; // update count of active servers
            maxServers = Math.max(maxServers, activeServers); // update max
        }

        return maxServers;
    }
    public static void main(String[] args) {
        // hw7 test = new hw7();
        // int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        // int result1 = test.minMeetingRooms(intervals1);
        // System.out.println("Test Case 1: " + result1);

        // int[][] intervals2 = {{0, 1}, {1, 2}, {2, 3}};
        // int result2 = test.minMeetingRooms(intervals2);
        // System.out.println("Test Case 2: " + result2);
    }

}
