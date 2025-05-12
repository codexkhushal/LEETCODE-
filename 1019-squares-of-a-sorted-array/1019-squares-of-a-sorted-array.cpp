class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int>sqr;
        for(int i = 0 ; i < n ; i++){
            sqr.push_back(nums[i]*nums[i]);
        }
        sort(sqr.begin(),sqr.end());
        return sqr;
    }

};