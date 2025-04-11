class Solution {
public:
    int countSymmetricIntegers(int low, int high) {
        int count = 0 ;

        for(int num = low ; num <= high ; num++){
            if(num>= 10 && num <100 && num % 11 == 0){
                count++;
            }else if(num>=1000 && num < 10000){
                int first = num/1000 ;
                int second = (num/100) % 10;
                int third = (num/10)%10 ;
                int fourth = num % 10;

                if(first+second == third+fourth){
                    count++;
                }
            }
            
        }
        return count;

    }
};