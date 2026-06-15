class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        // Pointers for both strings starting from the end
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Loop as long as there are digits to process or a remaining carry
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            // Add digit from string 'a' if available
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to integer
                i--;
            }
            
            // Add digit from string 'b' if available
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to integer
                j--;
            }
            
            // The current bit to append is sum % 2 (either 0 or 1)
            result.append(sum % 2);
            
            // Calculate the new carry (sum / 2)
            carry = sum / 2;
        }
        
        // Since we added digits from right to left, reverse the result
        return result.reverse().toString();
    }
}