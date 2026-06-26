class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int n = nums.length;
        if (n == 0) return ans;

        int start = nums[0];

        for (int i = 0; i < n; i++) {

            while (i + 1 < n && (long) nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + end);
            }

            if (i + 1 < n) {
                start = nums[i + 1];
            }
        }

        return ans;
    }
}