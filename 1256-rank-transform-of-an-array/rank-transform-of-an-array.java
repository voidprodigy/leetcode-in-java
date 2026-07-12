import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Put all unique elements into a sorted structure
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        // Step 2: Use a Map to store the rank of each element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            rankMap.put(num, rank++);
        }
        
        // Step 3: Build the result array using the rankMap
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}