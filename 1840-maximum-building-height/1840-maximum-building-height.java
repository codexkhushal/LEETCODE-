import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        
        int[][] res = new int[m + 2][2];
        for (int i = 0; i < m; i++) {
            res[i] = restrictions[i];
        }
        res[m] = new int[]{1, 0};
        res[m + 1] = new int[]{n, n - 1};

        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));

        int N = res.length;

        for (int i = 1; i < N; i++) {
            int diffDist = res[i][0] - res[i - 1][0];
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + diffDist);
        }

        for (int i = N - 2; i >= 0; i--) {
            int diffDist = res[i + 1][0] - res[i][0];
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + diffDist);
        }

        int result = 0;

        for (int i = 1; i < N; i++) {
            int leftPos = res[i - 1][0];
            int leftHt  = res[i - 1][1];

            int currPos = res[i][0];
            int currHt  = res[i][1];

            int d      = currPos - leftPos;
            int htDiff = Math.abs(leftHt - currHt);

            int peak = Math.max(leftHt, currHt) + (d - htDiff) / 2;

            result = Math.max(result, peak);
        }

        return result;
    }
}