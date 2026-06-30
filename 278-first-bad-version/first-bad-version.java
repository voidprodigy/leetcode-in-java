

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Prevents integer overflow
            int mid = left + (right - left) / 2; 
            
            if (isBadVersion(mid)) {
                // The first bad version is at mid or earlier
                right = mid;
            } else {
                // The first bad version is strictly after mid
                left = mid + 1;
            }
        }
        
        // left and right converge to the first bad version
        return left;
    }
}