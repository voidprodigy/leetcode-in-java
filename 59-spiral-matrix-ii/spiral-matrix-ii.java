class Solution {
    public int[][] generateMatrix(int n) {

        int[][] a = new int[n][n];

        int t = 0;
        int b = n - 1;
        int l = 0;
        int r = n - 1;

        int x = 1;

        while (t <= b && l <= r) {

            for (int i = l; i <= r; i++) {
                a[t][i] = x++;
            }
            t++;

            for (int i = t; i <= b; i++) {
                a[i][r] = x++;
            }
            r--;

            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    a[b][i] = x++;
                }
                b--;
            }

            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    a[i][l] = x++;
                }
                l++;
            }
        }

        return a;
    }
}