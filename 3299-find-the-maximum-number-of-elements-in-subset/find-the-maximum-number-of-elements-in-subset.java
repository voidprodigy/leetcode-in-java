import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {
            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (cur > 1000000000L) {
                    break;
                }

                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) == 1) {
                // Can use cur as center
                len++;
            } else {
                // Last level counted twice, but center needs only one
                len--;
            }

            ans = Math.max(ans, Math.max(1, len));
        }

        return ans;
    }
}