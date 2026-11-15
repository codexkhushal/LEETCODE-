class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0;
        long totalOddSubarrays = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 != 0) {
                totalOddSubarrays += evenCount;
                oddCount++;
            } else {
                totalOddSubarrays += oddCount;
                evenCount++;
            }
        }

        return (int) (totalOddSubarrays % MOD);
    }
}