class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int,int >mp;
        int result = 0;

        for(auto &num :nums){
            mp[num]++;
        }

        for(auto &num : nums){
            int minN = num;
            int maxN = num + 1;

            if(mp.count(maxN)){
                result = max(result , mp[maxN]+mp[minN]);
            }
        }
        return result; 
    }
};