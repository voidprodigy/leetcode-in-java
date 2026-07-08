class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // count[i] = number of non-zero digits in s[0 ... i-1]
        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];

            if (s.charAt(i) != '0') {
                count[i + 1]++;
            }
        }

        int k = count[n];

        // prefixValue[i] = number formed by first i non-zero digits
        long[] prefixValue = new long[k + 1];

        // prefixSum[i] = sum of first i non-zero digits
        long[] prefixSum = new long[k + 1];

        // powers of 10
        long[] pow10 = new long[k + 1];
        pow10[0] = 1;

        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int idx = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                idx++;

                prefixValue[idx] =
                    (prefixValue[idx - 1] * 10 + digit) % MOD;

                prefixSum[idx] =
                    prefixSum[idx - 1] + digit;
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            // Range in compressed non-zero digit array
            int left = count[l];
            int right = count[r + 1];

            int len = right - left;

            if (len == 0) {
                answer[q] = 0;
                continue;
            }

            // Extract x from prefix number
            long x =
                (prefixValue[right]
                - (prefixValue[left] * pow10[len]) % MOD
                + MOD) % MOD;

            // Digit sum
            long sum =
                prefixSum[right] - prefixSum[left];

            answer[q] = (int) ((x * sum) % MOD);
        }

        return answer;
    }
}