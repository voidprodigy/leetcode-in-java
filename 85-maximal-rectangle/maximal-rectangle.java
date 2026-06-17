class Solution {

    // Finds largest rectangle area in a histogram
    private int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Traverse all bars + one extra iteration
        for (int i = 0; i <= n; i++) {

            /*
             * At i == n, we assume current height = 0.
             * This forces all remaining bars in stack
             * to be processed.
             */
            int currentHeight = (i == n) ? 0 : heights[i];

            /*
             * Maintain increasing order of heights in stack.
             *
             * If current height is smaller than the height
             * at stack top, then the bar at stack top
             * cannot extend further.
             *
             * So calculate its maximum possible area.
             */
            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {

                // Height of rectangle
                int height = heights[stack.pop()];

                int width;

                /*
                 * If stack becomes empty after popping:
                 *
                 * This means current bar is the first
                 * smaller element on the right and there
                 * is no smaller element on the left.
                 *
                 * Width = i
                 */
                if (stack.isEmpty()) {
                    width = i;
                } else {

                    /*
                     * stack.peek() now points to the
                     * Previous Smaller Element.
                     *
                     * Current index i is the
                     * Next Smaller Element.
                     *
                     * Width = NSE - PSE - 1
                     */
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            // Store current index
            stack.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        // Edge case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        /*
         * heights[j] stores number of consecutive 1's
         * ending at current row for column j.
         */
        int[] heights = new int[cols];

        int answer = 0;

        // Process every row
        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {

                    /*
                     * Increase height because
                     * consecutive 1 continues.
                     */
                    heights[j]++;

                } else {

                    /*
                     * Reset height because
                     * rectangle cannot pass through 0.
                     */
                    heights[j] = 0;
                }
            }

            // Find largest rectangle in current histogram
            answer = Math.max(answer,
                    largestRectangleArea(heights));
        }

        return answer;
    }
}