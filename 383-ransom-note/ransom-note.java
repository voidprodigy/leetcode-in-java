class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Optimization: If the note has more characters than the magazine, 
        // it's mathematically impossible to construct.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // An array to store the counts of each lowercase letter (a-z)
        int[] letterCounts = new int[26];

        // Populate the frequency bucket from the magazine
        for (int i = 0; i < magazine.length(); i++) {
            letterCounts[magazine.charAt(i) - 'a']++;
        }

        // Match and consume characters for the ransom note
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            
            // If we don't have this letter left, the construction fails
            if (letterCounts[index] == 0) {
                return false;
            }
            
            letterCounts[index]--;
        }

        return true;
    }
}