class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getMinChanges(s, i, j);
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], 1000000);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = j * 2; i <= n; i++) {
                for (int p = (j - 1) * 2; p <= i - 2; p++) {
                    if (dp[p][j - 1] != 1000000) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost[p][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int getMinChanges(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = len;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;
            int currentChanges = 0;
            for (int group = 0; group < d; group++) {
                int l = start + group;
                int r = start + len - d + group;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        currentChanges++;
                    }
                    l += d;
                    r -= d;
                }
            }
            minChanges = Math.min(minChanges, currentChanges);
        }

        return minChanges;
    }
}