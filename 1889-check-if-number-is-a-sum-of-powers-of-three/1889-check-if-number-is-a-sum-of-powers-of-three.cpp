class Solution {
public:
    bool checkPowersOfThree(int n) {
        int rem;
        while(n){
            rem = n%3;
            if(rem==2){
                return false;
            }
            n=n/3;
        }
        return true;
    }
};