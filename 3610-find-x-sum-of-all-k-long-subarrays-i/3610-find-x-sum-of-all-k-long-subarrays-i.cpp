class Solution {
public:
    vector<int> findXSum(vector<int>& nums, int k, int x) {
        int n = nums.size();
        vector<int> result;

        for (int i = 0; i <= n - k; ++i) {
            unordered_map<int, int> freq;
            for (int j = i; j < i + k; ++j) {
                freq[nums[j]]++;
            }
            vector<pair<int, int>> freqVec(freq.begin(), freq.end());
            sort(freqVec.begin(), freqVec.end(), [](auto& a, auto& b) {
                if (a.second == b.second)
                    return a.first > b.first;
                return a.second > b.second;
            });

            unordered_set<int> allowed;
            for (int j = 0; j < min(x, (int)freqVec.size()); ++j) {
                allowed.insert(freqVec[j].first);
            }

            int sum = 0;
            for (int j = i; j < i + k; ++j) {
                if (allowed.count(nums[j])) {
                    sum += nums[j];
                }
            }

            result.push_back(sum);
        }

        return result;
    }
};
