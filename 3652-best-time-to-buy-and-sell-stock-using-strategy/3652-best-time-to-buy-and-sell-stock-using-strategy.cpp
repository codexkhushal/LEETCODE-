class Solution {
public:
    long long maxProfit(vector<int>& pr, vector<int>& st, int k) {
        int n = pr.size();
        long long ans = 0, total = 0;

        for (int i = 0; i < n; ++i) total += pr[i] * st[i];
        ans = total;

        int l1 = 0, r1 = k/2 - 1, l2 = k/2, r2 = k-1;

        for (int i = l1; i <= r1; ++i) total -= (pr[i] * st[i]);
        for (int i = l2; i <= r2; ++i) total = total - (pr[i] * st[i]) + pr[i];
        ans = max (ans, total);

        while (r2+1 < n) {
            total = total + (pr[l1] * st[l1]) - (pr[r1+1] * st[r1+1]);
            total = total - pr[l2] + (pr[l2] * st[l2]) - (pr[r2+1] * st[r2+1]) + pr[r2+1];
            ans = max (ans, total);
            ++l1, ++r1, ++l2, ++r2;
        }

        return ans;
    }
};