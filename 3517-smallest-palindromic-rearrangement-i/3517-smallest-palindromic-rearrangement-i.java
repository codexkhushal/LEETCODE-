class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder half = new StringBuilder();
        char middle = 0;
        
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                middle = (char) ('a' + i);
            }
            for (int j = 0; j < count[i] / 2; j++) {
                half.append((char) ('a' + i));
            }
        }
        
        String left = half.toString();
        String right = half.reverse().toString();
        
        if (middle != 0) {
            return left + middle + right;
        } else {
            return left + right;
        }
    }
}
