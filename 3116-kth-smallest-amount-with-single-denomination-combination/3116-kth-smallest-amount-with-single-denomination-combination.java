class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) coins[0] * k;
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(coins, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long count(int[] coins, long target) {
        long total = 0;
        int n = coins.length;
        int numSubsets = 1 << n;

        for (int i = 1; i < numSubsets; i++) {
            long currentLcm = 1;
            int bitCount = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[j]);
                    if (currentLcm > target) {
                        break;
                    }
                }
            }

            if (bitCount % 2 == 1) {
                total += target / currentLcm;
            } else {
                total -= target / currentLcm;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}