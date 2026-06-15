class Solution {
    public boolean isNumber(String s) {

        // Tracks if we've seen at least one digit
        boolean seenDigit = false;

        // Tracks if we've seen a decimal point '.'
        boolean seenDot = false;

        // Tracks if we've seen an exponent 'e' or 'E'
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // CASE 1: Current character is a digit
            if (Character.isDigit(ch)) {

                // Once we see a digit, mark it
                seenDigit = true;
            }

            // CASE 2: Current character is '+' or '-'
            else if (ch == '+' || ch == '-') {

                /*
                 * Sign is valid only:
                 * 1. At the beginning of the string
                 * 2. Immediately after e or E
                 *
                 * Examples:
                 * "+3"
                 * "-1.5"
                 * "2e+10"
                 *
                 * Invalid:
                 * "3+5"
                 * "12-4"
                 */
                if (i > 0 &&
                        s.charAt(i - 1) != 'e' &&
                        s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // CASE 3: Current character is '.'
            else if (ch == '.') {

                /*
                 * Dot is invalid if:
                 * 1. We already saw a dot
                 * 2. We already saw exponent
                 *
                 * Valid:
                 * "3.14"
                 * ".5"
                 * "4."
                 *
                 * Invalid:
                 * "1.2.3"
                 * "1e2.3"
                 */
                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;
            }

            // CASE 4: Current character is 'e' or 'E'
            else if (ch == 'e' || ch == 'E') {

                /*
                 * Exponent is invalid if:
                 * 1. Already seen exponent
                 * 2. No digit before exponent
                 *
                 * Valid:
                 * "2e10"
                 * "3.5E7"
                 *
                 * Invalid:
                 * "e10"
                 * "1e2e3"
                 */
                if (seenExponent || !seenDigit) {
                    return false;
                }

                seenExponent = true;

                /*
                 * After exponent we must see digits again.
                 *
                 * Example:
                 * "1e" -> invalid
                 * So reset digit flag.
                 */
                seenDigit = false;
            }

            // CASE 5: Any other character is invalid
            else {
                return false;
            }
        }

        /*
         * String is valid only if we ended after seeing digits.
         *
         * Examples:
         * "123" -> true
         * "1e10" -> true
         * "1e" -> false
         * "." -> false
         */
        return seenDigit;
    }
}