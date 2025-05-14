class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        int uniquele = 0 ;
        int count = 1; 

        for(int i = 1 ; i < n ; i ++){
            if(nums[i]==nums[uniquele]){
                count ++;
                if(count <= 2){
                    uniquele++;
                    nums[uniquele] = nums[i];
                }
            }
            else{
                count = 1;
                uniquele++;
                nums[uniquele]=nums[i];
            }
        }
        return uniquele+1;

    }
};