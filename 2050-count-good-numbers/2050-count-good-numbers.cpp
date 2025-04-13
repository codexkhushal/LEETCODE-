class Solution {
public:
    long long power(long long n, long long m, long long MOD) {
        long long ans = 1;
        while (m) {
            if (m % 2 == 1) {
                ans = (ans * n) % MOD;
            }
            n = (n * n) % MOD;
            m /= 2;
        }
        return ans;
    }

    int countGoodNumbers(long long n) {
        const int MOD = 1e9 + 7;
        long long even_positions = (n + 1) / 2;
        long long odd_positions = n / 2;

        long long even_part = power(5, even_positions, MOD);
        long long odd_part = power(4, odd_positions, MOD);

        return (even_part * odd_part) % MOD;
    }
};
