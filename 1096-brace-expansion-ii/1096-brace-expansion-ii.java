class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Set<String>> values = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '{') {
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(ops, values);
                    }
                    ops.push('*');
                }
                ops.push('{');
            } else if (c == '}') {
                while (!ops.isEmpty() && ops.peek() != '{') {
                    evaluate(ops, values);
                }
                ops.pop();
            } else if (c == ',') {
                while (!ops.isEmpty() && ops.peek() != '{') {
                    evaluate(ops, values);
                }
                ops.push('+');
            } else {
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(ops, values);
                    }
                    ops.push('*');
                }
                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                values.push(set);
            }
        }

        while (!ops.isEmpty()) {
            evaluate(ops, values);
        }

        List<String> result = new ArrayList<>(values.pop());
        Collections.sort(result);
        return result;
    }

    private void evaluate(Stack<Character> ops, Stack<Set<String>> values) {
        char op = ops.pop();
        Set<String> set2 = values.pop();
        Set<String> set1 = values.pop();
        Set<String> res = new HashSet<>();

        if (op == '*') {
            for (String s1 : set1) {
                for (String s2 : set2) {
                    res.add(s1 + s2);
                }
            }
        } else if (op == '+') {
            res.addAll(set1);
            res.addAll(set2);
        }

        values.push(res);
    }
}