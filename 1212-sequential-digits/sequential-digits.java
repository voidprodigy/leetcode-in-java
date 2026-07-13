import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Generate all sequential digit numbers
        // Start with each possible first digit (1-9)
        for (int start = 1; start <= 9; start++) {
            int num = start;
            int nextDigit = start + 1;
            
            // Build numbers by adding digits
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                
                // If within range, add to result
                if (num >= low && num <= high) {
                    result.add(num);
                }
                
                nextDigit++;
            }
        }
        
        // Sort the result (though it should be somewhat sorted, 
        // we sort to be safe)
        Collections.sort(result);
        return result;
    }
}