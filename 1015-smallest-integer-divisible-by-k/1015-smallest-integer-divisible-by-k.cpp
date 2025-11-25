class Solution {
public:
      int smallestRepunitDivByK(int k) {
        size_t i=0;
        for (size_t r=1%k; i<k and r; ++i,r=(r*10+1)%k);
        return (i+2)%(k+2)-1; } 
        };