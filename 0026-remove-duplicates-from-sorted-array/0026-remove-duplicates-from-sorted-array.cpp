class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        int uniqele= 0 ;
        

        for(int i = 1 ; i < n;i++){
            if(nums[i] != nums[uniqele]){
               uniqele++;
               nums[uniqele]=nums[i];
            }
            
        }
        return uniqele+1;
    }
};