class Solution {
public:
    int bestClosingTime(string customers) {
        int curr = 0, pen = INT_MAX, tot = 0, ans = 0;
        for(char x: customers) {
            if(x == 'Y') tot++;
        }

        for(int i = 0; i < customers.size(); i++) {
            if(tot - curr < pen) {
                pen = tot - curr;
                ans = i;
            }
            if(customers[i] == 'Y') curr++;
            else curr--;
        }
        if(tot - curr < pen) {
            ans = customers.size();
        }
        return ans;
    }
};