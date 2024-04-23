I first made a graph using an adjacency list representation. The hint mentioned something called a virtual node and I kinda had to Google what that was. It basically connects to each house with an edge with the same weight as the well cost so each house can either connect via pipe or their own well.

I decided to use Prim's algorithm to implement the MST because we did not learn about disjoint set nor union-find yet. It goes through the list and for every edge that is the minimum cost and does not form a cycle is added to the MST (keeps track of previously added nodes). This is an example of a greedy algorithm because it always chooses the path of least weight.

I feel like there is definitely a better optimized more efficient method of doing this.
