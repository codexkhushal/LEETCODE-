class Solution {
public:
    long long flowerGame(int n, int m) {
        long long even1 = n / 2, odd1 = (n / 2) + (n % 2);
        long long even2 = m / 2, odd2 = (m / 2) + (m % 2);
        return (even1 * odd2 + odd1 * even2);
    }
};