class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        int n = spells.size();
        int m = potions.size();
        vector<int> pairs(n);

        sort(potions.begin(), potions.end());

        for(int i = 0; i < n; i++) {
            long long spell = spells[i];
            
            long long low = 0, high = m-1;
            int index = -1;
            while(low <= high) {
                int mid = (low + high) / 2;
                
                if(spell * potions[mid] >= success) {
                    index = mid;
                    high = mid-1;
                } else low = mid + 1;
            }

        
            pairs[i] = (index != -1) ? (m-index) : 0;
        }

        return pairs;
    }
};