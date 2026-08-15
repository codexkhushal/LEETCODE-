class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        int[] freq = new int[26];
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq[c - 'a']++;
            
            while (freq[c - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}