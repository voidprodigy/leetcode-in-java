class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        dfs(num, target, 0, "", 0, 0);

        return ans;
    }

    private void dfs(String num, int target, int index,
                     String expr, long value, long prev) {

        if (index == num.length()) {

            if (value == target)
                ans.add(expr);

            return;
        }

        for (int i = index; i < num.length(); i++) {

            // No leading zeros
            if (i != index && num.charAt(index) == '0')
                break;

            String curStr = num.substring(index, i + 1);

            long cur = Long.parseLong(curStr);

            if (index == 0) {

                dfs(num, target,
                        i + 1,
                        curStr,
                        cur,
                        cur);

            } else {

                // Addition
                dfs(num, target,
                        i + 1,
                        expr + "+" + curStr,
                        value + cur,
                        cur);

                // Subtraction
                dfs(num, target,
                        i + 1,
                        expr + "-" + curStr,
                        value - cur,
                        -cur);

                // Multiplication
                dfs(num, target,
                        i + 1,
                        expr + "*" + curStr,
                        value - prev + prev * cur,
                        prev * cur);
            }
        }
    }
}