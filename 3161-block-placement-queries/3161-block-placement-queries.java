import java.util.*;

class Solution {
    private int[] tree;
    private int n;

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftMax = query(2 * node, start, mid, l, r);
        int rightMax = query(2 * node + 1, mid + 1, end, l, r);
        return Math.max(leftMax, rightMax);
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        
        this.n = maxCoord + 1;
        this.tree = new int[4 * n];
        
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(n - 1); 
        
        update(1, 0, n - 1, n - 1, n - 1); 

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 1) {
                int x = q[1];
                if (obstacles.contains(x)) continue; 
                
                int prev = obstacles.floor(x);
                int next = obstacles.ceiling(x);

                obstacles.add(x);

                update(1, 0, n - 1, x, x - prev);
                update(1, 0, n - 1, next, next - x);
            } else {
                int x = q[1];
                int sz = q[2];
                
                int prev = obstacles.floor(x);
                
                int maxInternalGap = query(1, 0, n - 1, 0, x);
                int trailingGap = x - prev;
                
                int maxAvailableGap = Math.max(maxInternalGap, trailingGap);
                
                ans.add(maxAvailableGap >= sz);
            }
        }

        return ans;
    }
}