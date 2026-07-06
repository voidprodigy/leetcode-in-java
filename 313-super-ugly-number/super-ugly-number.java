class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int k = primes.length;

        int[] ugly = new int[n];
        int[] index = new int[k];
        long[] next = new long[k];

        ugly[0] = 1;

        for (int i = 0; i < k; i++) {
            next[i] = primes[i];
        }

        for (int i = 1; i < n; i++) {

            long min = next[0];

            for (int j = 1; j < k; j++) {
                min = Math.min(min, next[j]);
            }

            ugly[i] = (int) min;

            for (int j = 0; j < k; j++) {

                if (next[j] == min) {
                    index[j]++;
                    next[j] = (long) primes[j] * ugly[index[j]];
                }
            }
        }

        return ugly[n - 1];
    }
}