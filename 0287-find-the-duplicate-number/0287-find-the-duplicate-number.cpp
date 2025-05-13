class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        unordered_set<int> st; 

        for(auto & see : nums){
            if(st.count(see)){
                return see;
            }
            st.insert(see);
        }
        return -1;
    }
};