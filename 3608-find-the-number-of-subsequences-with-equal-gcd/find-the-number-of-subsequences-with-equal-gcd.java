class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int MAX_VAL = 200;
        
        // dp[g1][g2] = number of ways to get GCD of seq1 = g1, GCD of seq2 = g2
        long[][] dp = new long[MAX_VAL + 1][MAX_VAL + 1];
        dp[0][0] = 1; // 0 means empty subsequence
        
        for (int x : nums) {
            long[][] newDp = new long[MAX_VAL + 1][MAX_VAL + 1];
            
            for (int g1 = 0; g1 <= MAX_VAL; g1++) {
                for (int g2 = 0; g2 <= MAX_VAL; g2++) {
                    long cur = dp[g1][g2];
                    if (cur == 0) continue;
                    
                    // Option 1: skip this element
                    newDp[g1][g2] = (newDp[g1][g2] + cur) % MOD;
                    
                    // Option 2: add to seq1
                    int newG1 = (g1 == 0) ? x : gcd(g1, x);
                    newDp[newG1][g2] = (newDp[newG1][g2] + cur) % MOD;
                    
                    // Option 3: add to seq2
                    int newG2 = (g2 == 0) ? x : gcd(g2, x);
                    newDp[g1][newG2] = (newDp[g1][newG2] + cur) % MOD;
                }
            }
            
            dp = newDp;
        }
        
        long answer = 0;
        for (int g = 1; g <= MAX_VAL; g++) {
            answer = (answer + dp[g][g]) % MOD;
        }
        
        return (int) answer;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}