class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;

        while (i < n) {
            boolean found = false;
            for (int j = i + k - 1; j <= i + k && j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                    i = j + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                i++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}