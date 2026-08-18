class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51]; // Since 0 <= nums[i] <= 50

        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    seen[nums[j]] = true;
                    freq[nums[j]]++;
                }
            }
        }

        int ans = -1;
        for (int val = 50; val >= 0; val--) {
            if (freq[val] == 1) {
                return val;
            }
        }

        return ans;
    }
}