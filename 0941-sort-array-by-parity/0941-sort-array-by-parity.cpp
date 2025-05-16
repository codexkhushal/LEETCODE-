class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size();

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ;j < n ; j++){
                if(nums[i]%2 != 0 ){
                    swap(nums[i] ,nums[j]);
                }
            }
        }
        return nums;
    }
};
