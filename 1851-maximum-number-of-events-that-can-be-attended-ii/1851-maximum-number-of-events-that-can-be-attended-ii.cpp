class Solution {
public:
    vector<vector<int>> dp;
    int n;
    vector<int> next;

    int attend(int k, int i, vector<vector<int>>& events) {
        if (i == n || k == 0)
            return 0;
        if (dp[k][i] != -1)
            return dp[k][i];

        int attend_i = events[i][2] + attend(k - 1, next[i], events);

        int skip_i = attend(k, i + 1, events);

        int ans = max(attend_i, skip_i);
        return dp[k][i] = ans;
    }
    int maxValue(vector<vector<int>>& events, int k) {
        n = events.size();
        sort(events.begin(), events.end());
        dp.assign(k + 1, vector<int>(n + 1, -1));
        next.assign(n, n);
        for (int i = 0; i < n; i++) {
            next[i] = upper_bound(events.begin() + i + 1, events.end(),
                                  vector<int>{events[i][1] + 1, 0, 0}) -
                      events.begin();
        }
        return attend(k, 0, events);
    }
};