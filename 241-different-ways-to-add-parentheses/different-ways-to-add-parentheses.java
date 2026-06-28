class Solution {

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> result = new ArrayList<>();

        // Traverse the expression
        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If current character is an operator
            if (ch == '+' || ch == '-' || ch == '*') {

                // Solve left and right parts recursively
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Combine every left result with every right result
                for (int a : left) {
                    for (int b : right) {

                        if (ch == '+')
                            result.add(a + b);

                        else if (ch == '-')
                            result.add(a - b);

                        else
                            result.add(a * b);
                    }
                }
            }
        }

        // Base case: expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}