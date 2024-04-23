from typing import *
from collections import defaultdict


class hw12():
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        graph = defaultdict(list)
        # add virtual node 0 connections (wells)
        for i in range(1, n+1):
            graph[0].append((i, wells[i-1]))
            graph[i].append((0, wells[i-1]))
        # add pipes
        for pipe in pipes:
            graph[pipe[0]].append((pipe[1], pipe[2]))
            graph[pipe[1]].append((pipe[0], pipe[2]))

        # include node in mst to min_cost
        min_cost = [float('inf')] * (n + 1)
        min_cost[0] = 0 

        in_mst = [False] * (n + 1)
        total_cost = 0

        for _ in range(n + 1):
            # find minimum edge cost
            u = -1
            for i in range(n + 1):
                if not in_mst[i] and (u == -1 or min_cost[i] < min_cost[u]):
                    u = i
            
            # add to MST
            in_mst[u] = True
            total_cost += min_cost[u]

            # update cost for neighbors
            for v, cost in graph[u]:
                if not in_mst[v] and cost < min_cost[v]:
                    min_cost[v] = cost

        return total_cost

# testing
# test = hw12()
# n = 2
# wells = [1, 2]
# pipes = [[1, 2, 1], [1, 2, 2]]
# print(test.minCostToSupplyWater(n, wells, pipes))
