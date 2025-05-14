class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> used ;
        while(true){
            int sum = 0 ;
            int temp = n ;

            while(temp != 0){
                int digit = temp%10;
                sum+= digit * digit;
                temp = temp / 10 ;
            }
            if(sum==1){
                return true;
            }
            if(used.find(sum)!= used.end()){
                return false; 
            }

            used.insert(sum);
             n = sum ; 
        }
    }
};