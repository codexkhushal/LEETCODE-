class Solution {
    long long sol(int ind,long long len,vector<int>&prices){
        if(ind == prices.size())return len;


        if(prices[ind]==prices[ind-1]-1){
            len +=sol(ind+1,len+1,prices);
        }else{
            len +=sol(ind+1,1,prices);
        }
        return len;
    }

    long long sol2(vector<int>&prices){
        int pre = prices[0],last = 0;
        long long ans = 0;
        
        for(int i=1;i<prices.size();i++){
            if(prices[i]!=pre-1){
                long long n = (i-last);     
                ans +=n*(n+1)/2;       
                last = i;           
            }
            pre = prices[i];
        }

            long long n = (prices.size()-last);
            ans +=n*(n+1)/2;

        return ans;
    }
public:
    long long getDescentPeriods(vector<int>& prices) {
        return sol2(prices);
    }
};