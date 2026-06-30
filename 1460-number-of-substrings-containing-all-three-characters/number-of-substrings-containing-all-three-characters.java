class Solution {
    public int numberOfSubstrings(String s) {
        // Track the last seen index of 'a', 'b', and 'c'
        // Index 0 -> 'a', Index 1 -> 'b', Index 2 -> 'c'
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Update the index for the current character
            // s.charAt(i) - 'a' maps 'a' to 0, 'b' to 1, and 'c' to 2
            lastSeen[s.charAt(i) - 'a'] = i;
            
            // If we have seen all three characters at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the earliest occurrence among the three
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                
                // Substrings starting from index 0 up to minIndex and ending at i are valid
                count += minIndex + 1;
            }
        }
        
        return count;
    }
}