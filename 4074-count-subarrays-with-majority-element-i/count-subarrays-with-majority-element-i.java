class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int p = nums.length;
        int answer = 0;

        for (int i = 0; i < p; i++) {

            int sum = 0;

            for (int j = i; j < p; j++) {
                if (nums[j] == target)
                    sum++;
                else
                    sum--;

                if (sum > 0)
                    answer++;

            }
        }
        return answer;
    }
}