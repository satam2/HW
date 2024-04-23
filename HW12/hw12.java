import java.util.*;

public class hw12 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // make graph adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // virtual node 0 connections (wells)
        for (int i = 0; i < wells.length; i++) {
            graph.get(0).add(new int[]{i + 1, wells[i]});
            graph.get(i + 1).add(new int[]{0, wells[i]});
        }
        // add pipes
        for (int[] pipe : pipes) {
            graph.get(pipe[0]).add(new int[]{pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[]{pipe[0], pipe[2]});
        }

        // minimum cost using array
        int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;  // Start with the virtual node
        
        boolean[] inMST = new boolean[n + 1];
        int totalCost = 0;

        for (int i = 0; i <= n; i++) {
            // find next node with the smallest cost
            int u = -1;
            for (int j = 0; j <= n; j++) {
                if (!inMST[j] && (u == -1 || minCost[j] < minCost[u])) {
                    u = j;
                }
            }
            
            // include in MST
            inMST[u] = true;
            totalCost += minCost[u];

            // update cost for neighbors
            for (int[] adj : graph.get(u)) {
                int v = adj[0];
                int cost = adj[1];
                if (!inMST[v] && cost < minCost[v]) {
                    minCost[v] = cost;
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args){
        // hw12 test = new hw12();
        // int[] wells = {1,1};
        // int[][] houses = {{1,2,1},{1,2,2}};
        // int result = test.minCostToSupplyWater(2, wells, houses);
        // System.out.println(result);
    }
}
