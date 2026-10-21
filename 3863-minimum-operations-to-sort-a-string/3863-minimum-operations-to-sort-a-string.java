class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        if (n == 2) return -1;
        
        char minChar = s.charAt(0);
        char maxChar = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        boolean hasMinInside = false;
        boolean hasMaxInside = false;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minChar) hasMinInside = true;
            if (s.charAt(i) == maxChar) hasMaxInside = true;
        }
        
        if (hasMinInside || hasMaxInside) {
            return 2;
        }
        
        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) {
            int minCount = 0;
            int maxCount = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == minChar) minCount++;
                if (s.charAt(i) == maxChar) maxCount++;
            }
            if (minCount == 1 && maxCount == 1) {
                return 3;
            }
        }
        
        return 2;
    }
}