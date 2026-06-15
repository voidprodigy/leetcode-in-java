class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        // Process all words
        while (i < words.length) {

            // j will find the last word that can fit in current line
            int j = i;

            // Total characters of words only (without spaces)
            int lineLength = 0;

            /*
             * Greedily include as many words as possible.
             *
             * Condition:
             * lineLength = total chars of words
             * (j - i) = minimum spaces between words
             */
            while (j < words.length &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {

                lineLength += words[j].length();
                j++;
            }

            /*
             * Words from index i to j-1 belong to current line
             */
            int numberOfWords = j - i;

            StringBuilder line = new StringBuilder();

            /*
             * CASE 1:
             * Last line OR only one word
             *
             * Left justify
             */
            if (j == words.length || numberOfWords == 1) {

                // Add words separated by single space
                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Fill remaining spaces at end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            /*
             * CASE 2:
             * Fully justify line
             */
            else {

                // Total spaces needed
                int totalSpaces = maxWidth - lineLength;

                // Number of gaps between words
                int gaps = numberOfWords - 1;

                /*
                 * Evenly distributed spaces
                 */
                int spacesPerGap = totalSpaces / gaps;

                /*
                 * Extra spaces go to leftmost gaps
                 */
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    // Don't add spaces after last word
                    if (k < j - 1) {

                        // Every gap gets base spaces
                        for (int s = 0; s < spacesPerGap; s++) {
                            line.append(" ");
                        }

                        /*
                         * Leftmost gaps get one extra space
                         */
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());

            // Move to next line
            i = j;
        }

        return result;
    }
}