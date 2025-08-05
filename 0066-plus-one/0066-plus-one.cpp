class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        // int n = digits.size();
        // for(int i = 0 ; i < n ; i++){
        //     if(digits[n-1] == 0 ||digits[n-1] == 1 ||digits[n-1] == 2 ||digits[n-1] == 3 ||digits[n-1] == 4 ||digits[n-1] == 5 ||digits[n-1] == 6 ||digits[n-1] == 7 ||digits[n-1] == 8 ) {
        //         digits[n-1]++;
        //     }
        //     else{
        //         digits[n-1] = 0;
        //         digits[n-2]++;
        //     }
        // }
        // return digits;

        // int i = digits.size()-1;
        // while (i >= 0) {
        //     if (digits[i] < 9) {
        //         digits[i] += 1;
        //         return digits;
        //     }
        //     else {
        //         digits[i] = 0;
        //         i--;
        //     }
        // }

        
        // digits[0] = 1;
        // digits.push_back(0);

        // return digits;

       
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
            if (i == 0) {
                digits.insert(digits.begin(), 1);
                return digits;
            }
        }
        return digits;        
    
    }
};