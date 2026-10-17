
class Solution {
    private static final int MOD = 1_000_000_007;

    long[] sumSq;
    long[] sumVal;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumVal = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSumSq = 0;

        for (int j = 0; j < n; j++) {
            int prev = lastSeen.getOrDefault(nums[j], -1);
            lastSeen.put(nums[j], j);

            // Update range [prev + 1, j] by adding 1 to distinct counts
            update(1, 0, n - 1, prev + 1, j, 1);

            // The root (index 1 covering 0 to n-1) maintains the sum of squares for all subarrays ending at j
            totalSumSq = (totalSumSq + sumSq[1]) % MOD;
        }

        return (int) totalSumSq;
    }

    private void applyLazy(int node, int l, int r, long val) {
        long len = (r - l + 1);
        // (a + val)^2 = a^2 + 2*val*a + val^2 * len
        sumSq[node] = (sumSq[node] + 2 * val * sumVal[node] + val * val * len) % MOD;
        sumVal[node] = (sumVal[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            applyLazy(2 * node, l, mid, lazy[node]);
            applyLazy(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) {
            return;
        }
        if (ql <= l && r <= qr) {
            applyLazy(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumVal[node] = (sumVal[2 * node] + sumVal[2 * node + 1]) % MOD;
    }
}