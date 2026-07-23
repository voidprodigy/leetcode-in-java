import java.util.*;

class Solution {
    
    // We use this class to store details about each block of zeros.
    class ZeroBlock {
        int start, end, len;
        
        ZeroBlock(int s, int e, int l) {
            start = s;
            end = e;
            len = l;
        }
    }

    // A simple tree to find the maximum sum in a specific range quickly.
    class SegmentTree {
        int n;
        int[] tree;
        
        SegmentTree(int[] data) {
            n = data.length;
            tree = new int[2 * n];
            
            for (int i = 0; i < n; i++) {
                tree[n + i] = data[i];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
            }
        }
        
        int query(int left, int right) {
            if (left > right) {
                return 0;
            }
            
            left += n;
            right += n + 1;
            int res = 0;
            
            while (left < right) {
                if (left % 2 == 1) {
                    res = Math.max(res, tree[left++]);
                }
                if (right % 2 == 1) {
                    res = Math.max(res, tree[--right]);
                }
                left /= 2;
                right /= 2;
            }
            return res;
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        List<ZeroBlock> zeros = new ArrayList<>();
        int i = 0;
        int baseOnes = 0;
        
        // Find all zero blocks and count the total ones.
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                int end = i - 1;
                zeros.add(new ZeroBlock(start, end, end - start + 1));
            } else {
                baseOnes++;
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        
        // If there are no zeros, the answer for any query is just the total ones.
        if (zeros.isEmpty()) {
            for (int q = 0; q < queries.length; q++) {
                ans.add(baseOnes);
            }
            return ans;
        }

        int m = zeros.size();
        int[] adjSums = new int[Math.max(1, m - 1)];
        for (int j = 0; j < m - 1; j++) {
            adjSums[j] = zeros.get(j).len + zeros.get(j + 1).len;
        }
        
        SegmentTree st = m > 1 ? new SegmentTree(adjSums) : null;

        int[] starts = new int[m];
        int[] ends = new int[m];
        for (int j = 0; j < m; j++) {
            starts[j] = zeros.get(j).start;
            ends[j] = zeros.get(j).end;
        }

        // Process each query one by one.
        for (int q = 0; q < queries.length; q++) {
            int L = queries[q][0];
            int R = queries[q][1];

            int idxFirst = lowerBound(ends, L);
            int idxLast = upperBound(starts, R) - 1;

            if (idxFirst > idxLast || idxFirst == idxLast) {
                ans.add(baseOnes);
                continue;
            }

            if (idxLast == idxFirst + 1) {
                int l1 = zeros.get(idxFirst).end - Math.max(L, zeros.get(idxFirst).start) + 1;
                int l2 = Math.min(R, zeros.get(idxLast).end) - zeros.get(idxLast).start + 1;
                ans.add(baseOnes + l1 + l2);
                continue;
            }

            int l1 = zeros.get(idxFirst).end - Math.max(L, zeros.get(idxFirst).start) + 1;
            int l2 = zeros.get(idxFirst + 1).len;
            int maxGain = l1 + l2;

            int lk = Math.min(R, zeros.get(idxLast).end) - zeros.get(idxLast).start + 1;
            int lk_1 = zeros.get(idxLast - 1).len;
            if (lk + lk_1 > maxGain) {
                maxGain = lk + lk_1;
            }

            if (idxLast - 2 >= idxFirst + 1 && st != null) {
                int midMax = st.query(idxFirst + 1, idxLast - 2);
                if (midMax > maxGain) {
                    maxGain = midMax;
                }
            }

            ans.add(baseOnes + maxGain);
        }
        
        return ans;
    }

    // Helper method to find the first index that is >= the target.
    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Helper method to find the first index that is > the target.
    private int upperBound(int[] arr, int target) {
        int left = 0; 
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}