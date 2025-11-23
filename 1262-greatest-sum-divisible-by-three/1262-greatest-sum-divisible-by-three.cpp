
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        long long total = 0;
        int r1[2] = {INT_MAX, INT_MAX};
        int r2[2] = {INT_MAX, INT_MAX};

        for (int x : nums) {
            total += x;
            int m = x % 3;
            if (m == 1) {
                if (x < r1[0]) { r1[1] = r1[0]; r1[0] = x; }
                else if (x < r1[1]) r1[1] = x;
            } else if (m == 2) {
                if (x < r2[0]) { r2[1] = r2[0]; r2[0] = x; }
                else if (x < r2[1]) r2[1] = x;
            }
        }

        if (total % 3 == 0) return (int)total;
        int rem = total % 3;
        long long option1 = LLONG_MIN, option2 = LLONG_MIN;

        if (rem == 1) {
            if (r1[0] != INT_MAX) option1 = total - r1[0];
            if (r2[1] != INT_MAX) option2 = total - (r2[0] + r2[1]);
        } else {
            if (r2[0] != INT_MAX) option1 = total - r2[0];
            if (r1[1] != INT_MAX) option2 = total - (r1[0] + r1[1]);
        }

        long long ans = max(option1, option2);
        return (ans < 0) ? 0 : (int)ans;
    }
};