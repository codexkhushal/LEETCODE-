class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        

        int n = nums.size();
        if (!n) {
            return 0;
        }
        int longest = 1;
        unordered_set<int> my_set(nums.begin(), nums.end());

        for(auto it : my_set){
            if(my_set.find(it-1) == my_set.end()){
                int count = 1;
                int x = it;
                while(my_set.find(x+1) != my_set.end()){
                    count++;
                    x++;
                }
                longest = max(longest, count);
            }
        }
        return longest;

       
    }
};