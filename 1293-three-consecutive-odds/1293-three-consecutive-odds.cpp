class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int n = arr.size();
        int count = 0;
        for(int i = 0 ; i < n-2 ;i++){
            if(arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0){
                count+=3;
                return true;
            }
            
        }
        return false;
    }
};