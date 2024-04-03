To complete this problem, I used BFS and a queue. The program finds the intial pixel and puts it into the queue. As long as the queue is not empty, we will change the color of the current pixel if it is the same color as the inital color and go to its neighbors up, down, left, and right (as long as they are within bounds of course). To avoid an infinite loop, we take care of the edge case where we are replacing the old color with the same color. This is sort of a level by level flood fill using BFS.

I think another way we can approach this is by using DFS instead.
