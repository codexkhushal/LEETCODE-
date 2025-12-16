class Solution {
public:
    vector<vector<int>> g;
    vector<int> p, f;
    int b;
    array<int, 161> dp[161][2];

    int maxProfit(int n, vector<int>& present, vector<int>& future, vector<vector<int>>& hierarchy, int budget) {
        g.assign(n + 1, {});
        b = budget, p = present, f = future;

        for (auto& v : hierarchy)
            g[v[0]].push_back(v[1]);

        for (int i = 0; i <= n; ++i)
            for (int y = 0; y < 2; ++y)
                dp[i][y][0] = -1;

        dfs(1, 0);
        return *max_element(dp[1][0].begin(), dp[1][0].begin() + b + 1);
    }

    array<int, 161> dfs(int node, bool bossBought) {
        if (dp[node][bossBought][0] == -1) {
            const int NEG = -1000000000;

            array<int, 161> o1 = {};
            array<int, 161> o2 = {};
            for (int i = 0; i < 161; ++i) o1[i] = o2[i] = NEG;

            o1[0] = 0;
            for (auto& e : g[node]) {
                auto c = dfs(e, 0);
                array<int, 161> nw = {};
                for (int i = 0; i < 161; ++i) nw[i] = NEG;
                for (int i = 0; i <= b; ++i) if (o1[i] != NEG) {
                    for (int j = 0; i + j <= b; ++j) if (c[j] != NEG) {
                        nw[i + j] = max(nw[i + j], o1[i] + c[j]);
                    }
                }
                o1 = nw;
            }

            int cost = p[node - 1];
            if (bossBought) cost /= 2;
            if (cost <= b) o2[cost] = f[node - 1] - cost;

            for (auto& e : g[node]) {
                auto c = dfs(e, 1);
                array<int, 161> nw = {};
                for (int i = 0; i < 161; ++i) nw[i] = NEG;
                for (int i = 0; i <= b; ++i) if (o2[i] != NEG) {
                    for (int j = 0; i + j <= b; ++j) if (c[j] != NEG) {
                        nw[i + j] = max(nw[i + j], o2[i] + c[j]);
                    }
                }
                o2 = nw;
            }

            for (int i = 0; i <= b; ++i) o1[i] = max(o1[i], o2[i]);
            dp[node][bossBought] = o1;
        }
        return dp[node][bossBought];
    }
};