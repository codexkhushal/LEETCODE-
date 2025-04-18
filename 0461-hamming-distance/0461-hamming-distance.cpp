class Solution {
public:
    int hammingDistance(int x, int y) {
        x = x^y;
        int count = 0 ;
        while(x!=0){
            if(x%2 == 1){
                count++;
            }x =x / 2;
        }
        return count;
    }
};