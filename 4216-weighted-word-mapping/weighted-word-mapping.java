class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int totalWeight = 0;

            for (char character : word.toCharArray()) {
                int index = character - 'a';
                totalWeight += weights[index];
            }

            int remainder = totalWeight % 26;

            // Reverse mapping: 0 -> 'z', 1 -> 'y', ..., 25 -> 'a'
            char mappedCharacter = (char) ('z' - remainder);
            result.append(mappedCharacter);
        }

        return result.toString();
    }
}