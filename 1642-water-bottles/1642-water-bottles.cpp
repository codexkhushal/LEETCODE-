class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int cons = 0 ;
        while(numBottles >= numExchange){
            cons += numExchange;
            numBottles -= numExchange;
            numBottles ++;
        }
        return cons+numBottles;
    }
};