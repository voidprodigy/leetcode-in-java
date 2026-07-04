class Solution {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;

        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        // First pass: find bulls and count unmatched digits
        for (int i = 0; i < secret.length(); i++) {

            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }

        // Count cows
        for (int digit = 0; digit < 10; digit++) {
            cows += Math.min(secretFreq[digit], guessFreq[digit]);
        }

        return bulls + "A" + cows + "B";
    }
}