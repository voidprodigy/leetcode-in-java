import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) id[i] = i;
        Arrays.sort(id, Comparator.comparingInt(i -> nums[i]));

        int[] a = new int[n], pos = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[id[i]];
            pos[id[i]] = i;
        }

        int L = 32 - Integer.numberOfLeadingZeros(n);
        int[][] up = new int[L][n];

        for (int i = 0, r = 0; i < n; i++) {
            while (r + 1 < n && a[r + 1] - a[i] <= maxDiff) r++;
            up[0][i] = r;
        }

        for (int k = 1; k < L; k++)
            for (int i = 0; i < n; i++)
                up[k][i] = up[k - 1][up[k - 1][i]];

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int x = pos[queries[q][0]], y = pos[queries[q][1]];
            if (x > y) { int t = x; x = y; y = t; }

            if (x == y) continue;

            int cur = x, d = 0;

            for (int k = L - 1; k >= 0; k--)
                if (up[k][cur] < y && up[k][cur] > cur) {
                    cur = up[k][cur];
                    d += 1 << k;
                }

            ans[q] = up[0][cur] >= y ? d + 1 : -1;
        }
        return ans;
    }
}