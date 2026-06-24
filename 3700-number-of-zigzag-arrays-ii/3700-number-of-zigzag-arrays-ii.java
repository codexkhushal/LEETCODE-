class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;
        
        long[][] T = new long[size][size];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                T[y + m][x] = 1;
            }
            for (int y = x + 1; y < m; y++) {
                T[y][x + m] = 1;
            }
        }
        
        long[][] T_pow = power(T, n - 2, size);
        
        long[] initial = new long[size];
        for (int y = 0; y < m; y++) {
            initial[y] = y;
            initial[y + m] = m - 1 - y;
        }
        
        long result = 0;
        for (int i = 0; i < size; i++) {
            long totalForState = 0;
            for (int j = 0; j < size; j++) {
                totalForState = (totalForState + T_pow[i][j] * initial[j]) % MOD;
            }
            result = (result + totalForState) % MOD;
        }
        
        return (int) result;
    }

    private long[][] power(long[][] base, long exp, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base, size);
            }
            base = multiply(base, base, size);
            exp >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}