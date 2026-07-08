import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];

        int wordIndex = -1;

        // Stores indices of words whose remaining prefix is palindrome
        List<Integer> palindromeList = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();


    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        // Insert all words into Trie in reverse order
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        // Search pairs for every word
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, result);
        }

        return result;
    }


    private void insert(String word, int index) {

        TrieNode node = root;

        // Insert from right to left
        for (int i = word.length() - 1; i >= 0; i--) {

            // If remaining prefix is palindrome
            if (isPalindrome(word, 0, i)) {
                node.palindromeList.add(index);
            }

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];
        }

        node.wordIndex = index;

        // Empty remaining part is palindrome
        node.palindromeList.add(index);
    }


    private void search(
            String word,
            int index,
            List<List<Integer>> result) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            /*
             Case:
             Trie contains a complete word
             and remaining substring is palindrome
            */

            if (node.wordIndex >= 0
                    && node.wordIndex != index
                    && isPalindrome(word, i, word.length() - 1)) {

                result.add(
                    Arrays.asList(index, node.wordIndex)
                );
            }

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                return;
            }

            node = node.child[c];
        }


        /*
         Current word completely matched.
         Add words whose remaining part is palindrome.
        */

        for (int j : node.palindromeList) {

            if (j != index) {
                result.add(Arrays.asList(index, j));
            }
        }
    }


    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}