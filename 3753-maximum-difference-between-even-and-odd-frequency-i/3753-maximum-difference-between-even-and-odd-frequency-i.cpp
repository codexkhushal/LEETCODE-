class Solution {
public:
    int maxDifference(string s) {
        unordered_map<char,int> mp;

        for(auto& ch : s){
            mp[ch]++;
        }

        int maxOdd = 0;
        int minEven = INT_MAX;

        for(auto it = mp.begin(); it != mp.end() ; it++){
            if(it->second % 2 ==1){
                maxOdd = max(maxOdd , it->second);
            }else{
                minEven = min(minEven, it->second);
            }
        }

        return maxOdd - minEven;
    }
};