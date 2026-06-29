class Solution {
    public int nthUglyNumber(int n) {

        // Array to store first n ugly numbers
        int[] ugly = new int[n];

        // First ugly number is always 1
        ugly[0] = 1;

        // Three pointers
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        // Generate ugly numbers
        for (int i = 1; i < n; i++) {

            // Next possible multiples
            int next2 = ugly[i2] * 2;
            int next3 = ugly[i3] * 3;
            int next5 = ugly[i5] * 5;

            // Choose the smallest one
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            // Move all pointers that match
            if (ugly[i] == next2)
                i2++;

            if (ugly[i] == next3)
                i3++;

            if (ugly[i] == next5)
                i5++;
        }

        // nth ugly number
        return ugly[n - 1];
    }
}
