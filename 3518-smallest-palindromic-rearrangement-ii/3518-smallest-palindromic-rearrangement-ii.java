
class Solution {
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }
        
        if (countWays(halfCount, halfLen) < k) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfCount[c] > 0) {
                    halfCount[c]--;
                    long ways = countWays(halfCount, halfLen - 1 - i);
                    if (k <= ways) {
                        sb.append((char) ('a' + c));
                        break;
                    } else {
                        k -= ways;
                        halfCount[c]++;
                    }
                }
            }
        }
        
        String left = sb.toString();
        String mid = "";
        if (n % 2 != 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 != 0) {
                    mid = String.valueOf((char) ('a' + i));
                    break;
                }
            }
        }
        
        StringBuilder res = new StringBuilder(left);
        res.append(mid);
        res.append(new StringBuilder(left).reverse().toString());
        return res.toString();
    }
    
    private long countWays(int[] counts, int total) {
        long res = 1;
        int remaining = total;
        for (int i = 0; i < 26; i++) {
            int c = counts[i];
            for (int j = 1; j <= c; j++) {
                res = res * (remaining - c + j) / j;
                if (res > LIMIT) {
                    return LIMIT;
                }
            }
            remaining -= c;
        }
        return Math.min(res, LIMIT);
    }
}