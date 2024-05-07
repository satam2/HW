from typing import List

class hw7():
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        events = []
        for start, end in intervals:
            events.append((start, 1))  # job starts, need one more server
            events.append((end, -1))   # hob ends, free one server

        # sort events
        events.sort(key=lambda x: (x[0], x[1]))

        max_servers = 0
        current_servers = 0

        # calculate the max servers needed
        for _, event in events:
            current_servers += event
            if current_servers > max_servers:
                max_servers = current_servers

        return max_servers
    
# test = hw7()
# print(test.minMeetingRooms([[0, 30], [5, 10], [15, 20]]))  # 2
# print(test.minMeetingRooms([[0, 1], [1, 2], [2, 3]]))      # 1
