class Solution {

    static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        long[][] ways = new long[n][n];

        // Starting point S
        ways[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                char cell = board.get(i).charAt(j);

                if (cell == 'X' || cell == 'S') {
                    continue;
                }

                int maxScore = -1;
                long pathCount = 0;

                // From below
                if (i + 1 < n && ways[i + 1][j] > 0) {

                    if (score[i + 1][j] > maxScore) {
                        maxScore = score[i + 1][j];
                        pathCount = ways[i + 1][j];
                    }
                    else if (score[i + 1][j] == maxScore) {
                        pathCount = (pathCount + ways[i + 1][j]) % MOD;
                    }
                }

                // From right
                if (j + 1 < n && ways[i][j + 1] > 0) {

                    if (score[i][j + 1] > maxScore) {
                        maxScore = score[i][j + 1];
                        pathCount = ways[i][j + 1];
                    }
                    else if (score[i][j + 1] == maxScore) {
                        pathCount = (pathCount + ways[i][j + 1]) % MOD;
                    }
                }

                // From bottom-right diagonal
                if (i + 1 < n && j + 1 < n
                        && ways[i + 1][j + 1] > 0) {

                    if (score[i + 1][j + 1] > maxScore) {
                        maxScore = score[i + 1][j + 1];
                        pathCount = ways[i + 1][j + 1];
                    }
                    else if (score[i + 1][j + 1] == maxScore) {
                        pathCount =
                            (pathCount + ways[i + 1][j + 1]) % MOD;
                    }
                }

                // Cell is unreachable
                if (maxScore == -1) {
                    continue;
                }

                int value = 0;

                if (cell != 'E') {
                    value = cell - '0';
                }

                score[i][j] = maxScore + value;
                ways[i][j] = pathCount;
            }
        }

        if (ways[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{
            score[0][0],
            (int) ways[0][0]
        };
    }
}