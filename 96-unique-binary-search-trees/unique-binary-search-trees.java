class Solution {
    public int numTrees(int n) {

        /*
         * dp[i] =
         * Number of unique BSTs
         * that can be formed using i nodes.
         */
        int[] dp = new int[n + 1];

        /*
         * Base cases.
         */
        dp[0] = 1;
        dp[1] = 1;

        /*
         * Build answers from smaller
         * node counts to larger.
         */
        for (int nodes = 2; nodes <= n; nodes++) {

            /*
             * Try every node as root.
             */
            for (int root = 1; root <= nodes; root++) {

                int leftNodes = root - 1;
                int rightNodes = nodes - root;

                dp[nodes] +=
                        dp[leftNodes] *
                        dp[rightNodes];
            }
        }

        return dp[n];
    }
}