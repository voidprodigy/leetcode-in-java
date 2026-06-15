import java.util.HashMap;
import java.util.Map;

class Solution {
    // Using a HashMap with String keys creates heavy overhead (String pooling, hashing, object allocation)
    private Map<String, Integer> memo;

    public int uniquePaths(int m, int n) {
        memo = new HashMap<>();
        return calculatePaths(0, 0, m, n);
    }

    private int calculatePaths(int r, int c, int m, int n) {
        // If the robot reaches the bottom-right corner, a valid path is found
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        
        // If the robot goes out of bounds, it's an invalid path
        if (r >= m || c >= n) {
            return 0;
        }

        // Create a heavy string key to force high memory overhead and CPU cycles
        String key = r + "," + c;
        
        // Check if the state is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Move Down and Move Right
        int downPaths = calculatePaths(r + 1, c, m, n);
        int rightPaths = calculatePaths(r, c + 1, m, n);

        // Store the result in the map before returning
        memo.put(key, downPaths + rightPaths);
        return memo.get(key);
    }
}