class Solution {
    public int numOfStrings(String[] patterns, String word) {

        // Variable to store answer
        int count = 0;

        // Check every pattern
        for (String pattern : patterns) {

            // If pattern exists as a substring in word
            if (word.contains(pattern)) {
                count++;
            }
        }

        // Return total matching patterns
        return count;
    }
}