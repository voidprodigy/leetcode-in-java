class Solution {
    public int[] plusOne(int[] digits) {

        // Start from the last digit because we need to add 1
        // to the least significant digit.
        for (int i = digits.length - 1; i >= 0; i--) {

            // If current digit is less than 9,
            // simply increment it and return.
            //
            // Example:
            // [1,2,3]
            // Last digit = 3
            // 3 + 1 = 4
            // Result = [1,2,4]
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9:
            // 9 + 1 = 10
            //
            // Put 0 here and carry 1 to the left.
            //
            // Example:
            // [1,2,9]
            // becomes [1,2,0]
            // carry moves to digit 2
            digits[i] = 0;
        }

        /*
         * If we reach here,
         * every digit was 9.
         *
         * Example:
         * [9]
         * [9,9]
         * [9,9,9]
         *
         * After loop:
         * [0]
         * [0,0]
         * [0,0,0]
         *
         * Need a new array:
         * [1,0]
         * [1,0,0]
         * [1,0,0,0]
         */

        int[] result = new int[digits.length + 1];

        // Put 1 in first position.
        // Remaining positions are already 0 by default.
        result[0] = 1;

        return result;
    }
}