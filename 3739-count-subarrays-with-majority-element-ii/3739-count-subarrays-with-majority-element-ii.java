class Solution {
    private int[] bit;
    private int size;

    private void update(int idx, int val) {
        while (idx <= size) {
            bit[idx] += val;
            idx += (idx & -idx);
        }
    }

    private int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        size = 2 * n + 2;
        bit = new int[size + 1];

        long totalSubarrays = 0;
        int currentPrefixSum = 0;
        
        int offset = n + 1;
        update(0 + offset, 1);

        for (int x : nums) {
            currentPrefixSum += (x == target) ? 1 : -1;
            totalSubarrays += query(currentPrefixSum + offset - 1);
            update(currentPrefixSum + offset, 1);
        }

        return totalSubarrays;
    }
}