class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        unordered_map<int , int>mp;
        int current = 0 ;
        int ans = 0 ;
        for(auto  num : nums){
            mp[num]++;
            current = max(current , mp[num]);
        }
        
        for(auto  c : mp){
            if(c.second == current ){
                ans+= c.second;
            }
        }
        return ans;
    }
};