class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they can't be anagrams
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        // Count characters in s
        // Subtract characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If any count is not zero, not an anagram
        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }
}