import java.util.*;

class Solution {
    private ArrayList<Integer>[] adj;
    private int[] depth;
    private int[][] up;
    private int LOG;
    private final int MOD = 1000000007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        dfs(1, 1, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            int lca = getLCA(u, v);
            int k = depth[u] + depth[v] - 2 * depth[lca];

            if (k == 0) {
                ans[i] = 0;
            } else {
                ans[i] = pow2[k - 1];
            }
        }

        return ans;
    }

    private void dfs(int node, int p, int d) {
        depth[node] = d;
        up[node][0] = p;
        for (int neighbor : adj[node]) {
            if (neighbor != p) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int j = LOG - 1; j >= 0; j--) {
            if (((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}