class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] means number of distinct subsequences of s[0...i-1] that equal t[0...j-1]
        double[][] dp = new double[m + 1][n + 1];
        
        // Base case: If t is empty, there is 1 way (empty subsequence)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Match found: use it (dp[i-1][j-1]) + ignore it (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // No match: ignore it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return (int) dp[m][n];
    }
}