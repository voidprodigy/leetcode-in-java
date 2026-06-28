class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // XOR of all numbers = unique1 ^ unique2
        for (int num : nums) {
            xor ^= num;
        }

        // Find the rightmost set bit
        int diff = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        // Divide numbers into two groups and XOR separately
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}