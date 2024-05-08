
I split the job intervals into an array called events that holds the start and end time of each job. The starting event means we need a server and the event means we have a spare server. I then sorted the events array by order of starting time. I go through the whole array, adjusting the amount of current servers using the start/end times. It also keeps track of highest number of servers required at any point in time.

I think the algorithm is in O(n logn) time because it is sorted and uses O(n) space with the creation of the events array.
