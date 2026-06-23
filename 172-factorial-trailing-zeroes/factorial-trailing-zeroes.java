class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0;

        for (int divisor = 5; divisor <= n; divisor *= 5) {
            zeros += n / divisor;
        }

        return zeros;
    }
}