class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        int result =0;
        for(int i = 0 ; i < n ;i++){
            count =0;
            while(nums[i]!=0){
                nums[i]= nums[i]/10;
                count++;
            }
            if(count % 2 ==0){
                result = result+1;
            }
        }
        return result;
    }
};