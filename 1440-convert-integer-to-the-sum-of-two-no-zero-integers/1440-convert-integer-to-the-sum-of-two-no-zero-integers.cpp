class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        if(n==2) return {1,1};
        int a,b;
        a=1;
        b=n-1;
        while(haszero(a) || haszero(b) ){
            a++;
            b--;
        }
        return {a,b};
    }
    bool haszero(int n){
        while (n>0){
            if(n%10 == 0) return true;
            n = n/10;
        }
        return false;
    }
};