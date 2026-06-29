import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {

        // Sort citations in ascending order
        Arrays.sort(citations);

        int n = citations.length;

        // Traverse the sorted array
        for (int i = 0; i < n; i++) {

            // Number of papers from current index to end
            int h = n - i;

            // Check if current citation count satisfies h-index condition
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}