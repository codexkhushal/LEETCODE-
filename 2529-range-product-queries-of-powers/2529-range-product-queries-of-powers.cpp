class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        const int mod = 1e9 + 7;
        int power = 1;
        while (power <= n)
            power <<= 1;
        power >>= 1;
        vector<int> parts;
        int m = n;
        while (m > 0){
            if (power <= m){
                parts.push_back(power);
                m -= power;
            }
            power >>= 1;
        }
        int k = (int)parts.size();
        vector<vector<int>> prefix(k, vector<int>(k, 0));
        for (int i = 0; i < k; i++){
            prefix[i][i] = parts[k - 1 - i];
            for (int j = i + 1; j < k; j++){
                long long prod = 1LL * prefix[i][j - 1] * parts[k - 1 - j];
                prefix[i][j] = (int)(prod % mod);
            }
        }
        vector<int> res;
        res.reserve(queries.size());
        for (auto &q : queries){
            res.push_back(prefix[q[0]][q[1]]);
        }
        return res;
    }
};