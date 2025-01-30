class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string>str;
        long long i=0, j=0;
        while(j<nums.size()) {
            string s = to_string(nums[i]);
            if((j+1 < nums.size()) && (static_cast<long long>(nums[j + 1]) - nums[j] == 1)) j++;
            else {
                if(i != j) {
                    s += "->";
                    s += to_string(nums[j]);
                    str.push_back(s);
                    i = j = j + 1;
                }
                else {
                    str.push_back(s);
                    i = j = j + 1;
                }
            }
        }
        return str;
    }
};