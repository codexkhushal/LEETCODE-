class Solution {
public:
    int maxProfit(vector<int>& prices) {
         int maxp = 0 ;
         int mintill = prices[0];

         for(int i = 0 ; i < prices.size();i++){
            mintill = min(mintill , prices[i]);
            int profit = prices[i] - mintill ;
            maxp = max(maxp, profit);
         }
         return maxp;
    }
};