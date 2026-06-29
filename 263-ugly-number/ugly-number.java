class Solution {
    public boolean isUgly(int n) {
        // Step 1: Negative numbers and 0 are NOT ugly
        if (n <= 0) return false;

        // Step 2: Divide by 2 as long as possible
        while (n % 2 == 0) {
            n = n / 2;
        }

        // Step 3: Divide by 3 as long as possible
        while (n % 3 == 0) {
            n = n / 3;
        }

        // Step 4: Divide by 5 as long as possible
        while (n % 5 == 0) {
            n = n / 5;
        }

        // Step 5: If we are left with 1 → only had 2,3,5 factors
        return n == 1;
    }
}