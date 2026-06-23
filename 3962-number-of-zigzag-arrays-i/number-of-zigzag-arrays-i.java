class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        // Build lengths 3..n
        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long prefix = 0;
            for (int v = 1; v <= m; v++) {
                newUp[v] = prefix;
                prefix = (prefix + down[v]) % MOD;
            }

            long suffix = 0;
            for (int v = m; v >= 1; v--) {
                newDown[v] = suffix;
                suffix = (suffix + up[v]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        } else {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        }

        return (int) ans;
    }
}