public class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        long digitSum = 0;
        String s = String.valueOf(n);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0') {
                sb.append(c);
                digitSum += (c - '0');
            }
        }

        if (sb.length() == 0) {
            return 0;
        }

        long x = Long.parseLong(sb.toString());

        return x * digitSum;
    }
}