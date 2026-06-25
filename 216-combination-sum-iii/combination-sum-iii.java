import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return ans;
    }

    private void backtrack(int start, int k, int target, List<Integer> curr) {
        if (curr.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) break; // Pruning

            curr.add(i);
            backtrack(i + 1, k, target - i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}