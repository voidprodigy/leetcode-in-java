class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] base = new long[m];

        // U(2)
        for (int i = 0; i < m; i++) {
            base[i] = i;
        }

        long[][] B = new long[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + 1) + (j + 1) > m + 1) {
                    B[i][j] = 1;
                }
            }
        }

        long[][] P = power(B, n - 2);

        long[] U = multiply(P, base);

        long ans = 0;
        for (long x : U) {
            ans = (ans + x) % MOD;
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }

    private long[][] power(long[][] A, long exp) {
        int n = A.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }

            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}