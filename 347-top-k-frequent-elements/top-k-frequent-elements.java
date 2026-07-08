import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // Step 3: Keep only top K frequent elements
        for (int num : freq.keySet()) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Store answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}