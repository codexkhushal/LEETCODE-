import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodeCount = new int[1];
                int[] edgeCount = new int[1];
                
                dfs(i, adj, visited, nodeCount, edgeCount);
                
                if (edgeCount[0] == nodeCount[0] * (nodeCount[0] - 1)) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] nodeCount, int[] edgeCount) {
        visited[node] = true;
        nodeCount[0]++;
        edgeCount[0] += adj.get(node).size();

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, nodeCount, edgeCount);
            }
        }
    }
}