class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(arr[a], arr[b]));
        
    
        for (int i : indices) {
            for (int j = i + 1; j <= i + d && j < n; j++) {
                if (arr[j] >= arr[i]) break;
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            for (int j = i - 1; j >= i - d && j >= 0; j--) {
                if (arr[j] >= arr[i]) break;
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        int max = 0;
        for (int val : dp) max = Math.max(max, val);
        return max;
    }
}