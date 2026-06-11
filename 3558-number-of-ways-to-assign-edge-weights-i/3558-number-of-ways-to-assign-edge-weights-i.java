class Solution {
    private int maxDepth = 0;
    private final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        maxDepth = 0;
        dfs(1, 0, 0, adj);

        return power(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int currentDepth, List<List<Integer>> adj) {
        maxDepth = Math.max(maxDepth, currentDepth);

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, currentDepth + 1, adj);
            }
        }
    }

    private int power(long base, long exp) {
        if (exp < 0) return 0; 
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }
}