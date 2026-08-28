class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        for (int i = halfLen; i >= 0; i--) {
            int[] curCount = halfCount.clone();
            StringBuilder prefix = new StringBuilder();
            boolean valid = true;

            for (int j = 0; j < i; j++) {
                char c = target.charAt(j);
                if (curCount[c - 'a'] > 0) {
                    prefix.append(c);
                    curCount[c - 'a']--;
                } else {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                continue;
            }

            if (i < halfLen) {
                char targetChar = target.charAt(i);
                int nextChar = -1;
                for (int c = targetChar - 'a' + 1; c < 26; c++) {
                    if (curCount[c] > 0) {
                        nextChar = c;
                        break;
                    }
                }

                if (nextChar == -1) {
                    continue;
                }

                prefix.append((char) ('a' + nextChar));
                curCount[nextChar]--;

                for (int c = 0; c < 26; c++) {
                    while (curCount[c] > 0) {
                        prefix.append((char) ('a' + c));
                        curCount[c]--;
                    }
                }

                String firstHalf = prefix.toString();
                String fullPalindrome = buildPalindrome(firstHalf, midChar, n);
                return fullPalindrome;
            } else {
                String firstHalf = prefix.toString();
                String fullPalindrome = buildPalindrome(firstHalf, midChar, n);
                if (fullPalindrome.compareTo(target) > 0) {
                    return fullPalindrome;
                }
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, char midChar, int n) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            sb.append(midChar);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}