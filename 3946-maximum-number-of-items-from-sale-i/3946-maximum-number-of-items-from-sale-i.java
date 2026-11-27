import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];

        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    cnt++;
                }
            }
            freeCount[i] = cnt;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstGain = 1 + freeCount[i];
            int[] nextDp = Arrays.copyOf(dp, budget + 1);

            for (int b = price; b <= budget; b++) {
                nextDp[b] = Math.max(nextDp[b], dp[b - price] + firstGain);
            }

            for (int b = price; b <= budget; b++) {
                nextDp[b] = Math.max(nextDp[b], nextDp[b - price] + 1);
            }

            dp = nextDp;
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}
