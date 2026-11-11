class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;
        
        long totalCost = 0;
        
        long bothCount = Math.min(n1, n2);
        totalCost += bothCount * Math.min(cb, c1 + c2);
        n1 -= bothCount;
        n2 -= bothCount;
        
        if (n1 > 0) {
            totalCost += n1 * Math.min(cb, c1);
        } else if (n2 > 0) {
            totalCost += n2 * Math.min(cb, c2);
        }
        
        return totalCost;
    }
}