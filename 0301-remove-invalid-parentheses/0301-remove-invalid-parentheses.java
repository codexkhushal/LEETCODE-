class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRem = 0, rightRem = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        backtrack(s, 0, 0, 0, leftRem, rightRem, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int open, int close, int leftRem, int rightRem, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        if (c == '(') {
            int i = index;
            while (i < s.length() && s.charAt(i) == '(') {
                i++;
            }
            int count = i - index;

            for (int rem = 0; rem <= Math.min(leftRem, count); rem++) {
                int take = count - rem;
                for (int j = 0; j < take; j++) {
                    current.append('(');
                }
                backtrack(s, i, open + take, close, leftRem - rem, rightRem, current, result);
                current.setLength(len);
            }
        } else if (c == ')') {
            int i = index;
            while (i < s.length() && s.charAt(i) == ')') {
                i++;
            }
            int count = i - index;

            for (int rem = 0; rem <= Math.min(rightRem, count); rem++) {
                int take = count - rem;
                if (open >= close + take) {
                    for (int j = 0; j < take; j++) {
                        current.append(')');
                    }
                    backtrack(s, i, open, close + take, leftRem, rightRem - rem, current, result);
                    current.setLength(len);
                }
            }
        } else {
            current.append(c);
            backtrack(s, index + 1, open, close, leftRem, rightRem, current, result);
            current.setLength(len);
        }
    }
}