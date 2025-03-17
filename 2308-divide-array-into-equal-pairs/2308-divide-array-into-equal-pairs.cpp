class Solution {
public:
    bool divideArray(vector<int>& nums) {
        unordered_map<int, int> freq;
        for (int n : nums) {
            freq[n]++;
        }
        
        for (const auto& [_, count] : freq) {
            if (count % 2) return false;
        }
        
        return true;
    }
};
