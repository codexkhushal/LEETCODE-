class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || (long) num * 9 < sum) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int d = Math.min(9, sum);
            sb.append(d);
            sum -= d;
        }
        
        return sum == 0 ? sb.toString() : "";
    }
}