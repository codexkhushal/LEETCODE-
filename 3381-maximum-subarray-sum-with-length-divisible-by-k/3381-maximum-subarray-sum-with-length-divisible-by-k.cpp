class Solution {
public:
    long long maxSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();

        vector<long long> pre(n+1, 0);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }

        long long ans = LLONG_MIN;

        // k buckets for prefix sums by index % k
        vector<priority_queue<long long, vector<long long>, greater<long long>>> pq(k);

        for (int i = 0; i <= n; i++) {
            int r = i % k;

            if (!pq[r].empty()) {
                // best candidate: minimum prefix sum in this modulo class
                ans = max(ans, pre[i] - pq[r].top());
            }

            // add this prefix to the bucket
            pq[r].push(pre[i]);
        }

        return ans;
    }
};
