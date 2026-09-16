class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        long totalPoints = n + k - 1;
        long totalChoices = 2 * k;

        if (totalChoices > totalPoints) {
            return 0;
        }

        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= totalChoices; i++) {
            numerator = (numerator * (totalPoints - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }

    private long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}