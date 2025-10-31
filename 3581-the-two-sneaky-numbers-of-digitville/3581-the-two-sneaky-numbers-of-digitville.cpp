class Solution {
public:
    vector<int> getSneakyNumbers(vector<int>& nums) {
        unordered_map<int,int>mp;
        for(auto c :nums){
            mp[c]++;
        }
        vector<int>result;
        
        for(auto & pair : mp){
            if(pair.second > 1){
                result.push_back(pair.first);
            }
        }
        return result;
    }
};