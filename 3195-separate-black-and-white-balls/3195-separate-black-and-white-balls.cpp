class Solution {
public:
    long long minimumSteps(string s) {
        long long steps = 0;
        long long countZero = 0;
        
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == '0') {
                countZero++;
            } else {                
                steps += countZero;
            }
        }

        return steps;
    }
};
