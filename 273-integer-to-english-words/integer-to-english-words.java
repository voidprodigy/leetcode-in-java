class Solution {

    // Words for numbers less than 20
    String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    // Words for multiples of 10
    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Thousand units
    String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        String result = "";
        int index = 0;

        while (num > 0) {

            // Process each group of 3 digits
            if (num % 1000 != 0) {

                String part = helper(num % 1000);

                if (!result.isEmpty())
                    result = part + thousands[index] + " " + result;
                else
                    result = part + thousands[index];
            }

            num /= 1000;
            index++;
        }

        return result.trim();
    }

    // Converts numbers from 1 to 999
    private String helper(int num) {

        if (num == 0)
            return "";

        // 1 - 19
        if (num < 20)
            return below20[num] + " ";

        // 20 - 99
        if (num < 100)
            return tens[num / 10] + " " + helper(num % 10);

        // 100 - 999
        return below20[num / 100] + " Hundred " + helper(num % 100);
    }
}