class Solution {
    public int climbStairs(int n) {

        // If n = 1
        // Only one way: [1]
        if (n == 1) {
            return 1;
        }

        // Ways to reach step 1
        int first = 1;

        // Ways to reach step 2
        int second = 2;

        /*
         * Build answers from step 3 to n
         *
         * Example:
         * step 3 = step1 + step2
         * step 4 = step2 + step3
         * ...
         */
        for (int i = 3; i <= n; i++) {

            int current = first + second;

            // Move window forward
            first = second;
            second = current;
        }

        return second;
    }
}