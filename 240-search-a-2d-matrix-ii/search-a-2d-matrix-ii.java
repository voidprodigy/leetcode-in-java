class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }

            // If current value is greater than target,
            // move left
            else if (matrix[row][col] > target) {
                col--;
            }

            // If current value is smaller than target,
            // move down
            else {
                row++;
            }
        }

        return false;
    }
}