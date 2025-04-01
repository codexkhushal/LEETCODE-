class Solution {
public:
    int n;

    long long solve(int i, vector<vector<int>>& q, vector<long long>& t) {
        if (i >= n) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }

        long long skip = solve(i + 1, q, t);

        int nextIndex = i + q[i][1] + 1;
        long long pick = q[i][0] + solve(nextIndex, q, t);

        
        return t[i] = max(skip, pick);
    }

    long long mostPoints(vector<vector<int>>& questions) {
        n = questions.size();
        vector<long long> t(n, -1); 
        return solve(0, questions, t);
    }
};
