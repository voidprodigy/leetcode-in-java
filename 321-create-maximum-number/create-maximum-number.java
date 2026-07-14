class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        int[] ans = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {

            int[] a = maxArray(nums1, i);
            int[] b = maxArray(nums2, k - i);

            int[] cur = merge(a, b);

            if (greater(cur, 0, ans, 0)) {
                ans = cur;
            }
        }

        return ans;
    }

    private int[] maxArray(int[] nums, int k) {

        int[] stack = new int[k];
        int top = -1;
        int drop = nums.length - k;

        for (int num : nums) {

            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b) {

        int[] ans = new int[a.length + b.length];
        int i = 0, j = 0;

        for (int idx = 0; idx < ans.length; idx++) {
            if (greater(a, i, b, j)) {
                ans[idx] = a[i++];
            } else {
                ans[idx] = b[j++];
            }
        }

        return ans;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}