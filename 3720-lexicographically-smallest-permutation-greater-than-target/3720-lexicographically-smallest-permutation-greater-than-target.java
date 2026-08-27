class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int longestPrefix = -1;
        for (int i = 0; i < n; i++) {
            int charIdx = target.charAt(i) - 'a';
            if (freq[charIdx] > 0) {
                freq[charIdx]--;
                longestPrefix = i;
            } else {
                break;
            }
        }

        for (int p = longestPrefix + 1; p >= 0; p--) {
            int[] currentFreq = new int[26];
            for (int i = 0; i < 26; i++) {
                currentFreq[i] = freq[i];
            }
            for (int i = p; i <= longestPrefix; i++) {
                currentFreq[target.charAt(i) - 'a']++;
            }

            int targetChar = (p < n) ? (target.charAt(p) - 'a') : -1;
            int nextChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentFreq[c] > 0) {
                    nextChar = c;
                    break;
                }
            }

            if (nextChar != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, p));
                sb.append((char) ('a' + nextChar));
                currentFreq[nextChar]--;

                for (int c = 0; c < 26; c++) {
                    while (currentFreq[c] > 0) {
                        sb.append((char) ('a' + c));
                        currentFreq[c]--;
                    }
                }

                return sb.toString();
            }
        }

        return "";
    }
}