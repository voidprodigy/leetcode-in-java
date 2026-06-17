class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        /*
         * IP needs exactly 4 parts.
         * Minimum length = 4
         * Maximum length = 12
         */
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(s, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(String s,
                           int index,
                           List<String> parts) {

        /*
         * If we already have 4 parts.
         */
        if (parts.size() == 4) {

            /*
             * Valid IP only if all digits
             * have been used.
             */
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }

            return;
        }

        /*
         * Try segment lengths:
         * 1 digit
         * 2 digits
         * 3 digits
         */
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String segment =
                    s.substring(index, index + len);

            /*
             * Reject leading zeros.
             *
             * "0" is valid
             * "01" is invalid
             */
            if (segment.length() > 1 &&
                segment.charAt(0) == '0') {
                continue;
            }

            int value = Integer.parseInt(segment);

            /*
             * Segment must be <=255
             */
            if (value > 255) {
                continue;
            }

            // Choose
            parts.add(segment);

            // Explore
            backtrack(s,
                      index + len,
                      parts);

            // Undo choice
            parts.remove(parts.size() - 1);
        }
    }
}