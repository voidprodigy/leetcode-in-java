class Solution {
    public int mySqrt(int x) {

        // sqrt(0) = 0
        // sqrt(1) = 1
        if (x < 2) {
            return x;
        }

        // Search space
        long left = 1;
        long right = x;

        while (left <= right) {

            // Prevent overflow
            long mid = left + (right - left) / 2;

            long square = mid * mid;

            // Perfect square found
            if (square == x) {
                return (int) mid;
            }

            // Need a larger number
            if (square < x) {
                left = mid + 1;
            }

            // Need a smaller number
            else {
                right = mid - 1;
            }
        }

        /*
         * When loop ends:
         * right = largest value whose square <= x
         */
        return (int) right;
    }
}