class Solution {

    public boolean isInterleave(String s1,
                                String s2,
                                String s3) {

        int m = s1.length();
        int n = s2.length();

        /*
         * Length mismatch means impossible.
         */
        if (m + n != s3.length()) {
            return false;
        }

        /*
         * dp[i][j]
         * =
         * Can first i chars of s1
         * and first j chars of s2
         * form first (i+j) chars of s3?
         */
        boolean[][] dp =
                new boolean[m + 1][n + 1];

        /*
         * Empty strings form empty string.
         */
        dp[0][0] = true;

        /*
         * First column:
         * Only characters from s1.
         */
        for (int i = 1; i <= m; i++) {

            dp[i][0] =
                dp[i - 1][0]
                &&
                s1.charAt(i - 1)
                == s3.charAt(i - 1);
        }

        /*
         * First row:
         * Only characters from s2.
         */
        for (int j = 1; j <= n; j++) {

            dp[0][j] =
                dp[0][j - 1]
                &&
                s2.charAt(j - 1)
                == s3.charAt(j - 1);
        }

        /*
         * Fill remaining table.
         */
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char target =
                        s3.charAt(i + j - 1);

                /*
                 * Take from s1.
                 */
                if (s1.charAt(i - 1) == target) {

                    dp[i][j] |= dp[i - 1][j];
                }

                /*
                 * Take from s2.
                 */
                if (s2.charAt(j - 1) == target) {

                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}