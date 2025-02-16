class Solution {
public:
    bool solve(int i, int n, vector<int>& result, vector<bool>& used) {
        if (i >= result.size()) {
            return true;
        }
        
        if (result[i] != -1) {
            return solve(i + 1, n, result, used);
        }
        
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            
            if (num == 1) {
                result[i] = num;
                used[num] = true;
                if (solve(i + 1, n, result, used)) {
                    return true;
                }
                result[i] = -1;
                used[num] = false;
            } else {
                int j = i + num;
                if (j < result.size() && result[j] == -1) {
                    result[i] = result[j] = num;
                    used[num] = true;
                    if (solve(i + 1, n, result, used)) {
                        return true;
                    }
                    result[i] = result[j] = -1;
                    used[num] = false;
                }
            }
        }
        
        return false;
    }
    
    vector<int> constructDistancedSequence(int n) {
        vector<int> result(2 * n - 1, -1);
        vector<bool> used(n + 1, false);
        solve(0, n, result, used);
        return result;
    }
};
